package org.example.examples.Reflection.Annotations;

@MyAnnotation(name = "ParentAnnotation", value = 1)
class Parent implements MyMark {

	@MyAnnotation(0)
	private String name;

	public void printParent() {
		System.out.println(name);
	}

}