package org.example.examples.Reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ControlledObject(name = "simpleObject")
public class Pojo {

	private Long testId;

	private final String name = "test1";

	private void printText() {
		System.out.println("private method says: testID is: " + testId + ", name: " + name);
	}

	@Override
	public String toString() {
		return "Pojo instance: " +
				"testId=" + testId +
				", name='" + name + '\'';
	}
}

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface ControlledObject {

	String name();
}