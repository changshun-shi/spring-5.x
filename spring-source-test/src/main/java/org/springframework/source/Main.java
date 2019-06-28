package org.springframework.source;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Person person = (Person) context.getBean("person");
		System.out.println(person);
	}
}