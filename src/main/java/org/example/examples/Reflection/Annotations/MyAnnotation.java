package org.example.examples.Reflection.Annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
// @Inherited позволяет наследовать аннотации
@Inherited
@Documented
public @interface MyAnnotation {

    String name() default "demoAnnotation";

    int value();
}
