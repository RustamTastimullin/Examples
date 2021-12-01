package org.example.examples.Reflection;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMain {

    public static void main(String[] args) {

        Pojo newPojo = createNewPojo();
        setNewPojoFieldsValues(newPojo);
        usingPrivateMethod(newPojo);
    }

    public static void setNewPojoFieldsValues(@NotNull Pojo pojo) {
        try {
            Field[] field = pojo.getClass().getDeclaredFields();
            for (Field tmpField :
                    field) {
                tmpField.setAccessible(true);
                System.out.println("Field: " + tmpField.getName() + " || with value: " + tmpField.get(pojo));
            }
            field[0].set(pojo, 2L);
            field[1].set(pojo, "Test2");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void usingPrivateMethod(@NotNull Pojo pojo) {

        try {
            Method[] method = pojo.getClass().getDeclaredMethods();
            for (Method tmpMethod :
                    method) {
                if (!tmpMethod.canAccess(pojo)) {
                    System.out.println("private method: " + tmpMethod.getName());
                }
            }

            Method privateMethod = pojo.getClass().getDeclaredMethod("printText");
            privateMethod.setAccessible(true);
            System.out.print("Going to use private method: " + privateMethod.getName() + '\n');
            privateMethod.invoke(pojo);

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static Pojo createNewPojo() {
        Object newPojoClass = null;
        try {
            newPojoClass = Class.forName(Pojo.class.getName());
//                можно еще с конструктором создать класс используя переменные (в newInstance)
            newPojoClass = ((Class<?>) newPojoClass).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(newPojoClass);
        return (Pojo) newPojoClass;
    }
}
