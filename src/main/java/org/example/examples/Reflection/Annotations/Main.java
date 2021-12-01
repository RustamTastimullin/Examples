package org.example.examples.Reflection.Annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

class Main {

	public static void main(String[] args) {

		Class<Parent> parentInstance = Parent.class;
		readAnnotation(parentInstance);


//        Parent parent = new Parent();
//        Child child = new Child();

//        testInterface(parent);
//        testInterface(child);
//
//        testAnnotation(parent);
//        testAnnotation(child);
	}

	public static void readAnnotation(AnnotatedElement element) {
		try {
			System.out.println("\nПоиск аннотаций в " + element.getClass().getName());
			Annotation[] annotations = element.getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation instanceof MyAnnotation) {
					System.out.println("Name = " + ((MyAnnotation) annotation).name());
					System.out.println("Value = " + ((MyAnnotation) annotation).value());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//    public static void testInterface(MyMark markedObject) {
//        System.out.println("Метод 'TestInterface' успешно завершен!");
//    }
//
//    public static void testAnnotation(Object object) {
////        System.out.println(object.getClass().isAnnotationPresent(MyAnnotation.class));
//        if (!object.getClass().isAnnotationPresent(MyAnnotation.class)) {
//            throw new RuntimeException("Объект не аннотирован аннотацией 'MyAnnotation'");
//        }
//        System.out.println("Метод 'testAnnotation' успешно завершен!");
//    }
}