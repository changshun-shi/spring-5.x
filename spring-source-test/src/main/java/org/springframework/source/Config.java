package org.springframework.source;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

//@Configuration
public class Config implements BeanFactoryPostProcessor {
	@Bean("person")
	public Person person() {
		return new Person("Hello", 1948);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("===================Config 的 BeanFactoryPostProcessor==================");
	}
}

class Person implements BeanFactoryPostProcessor, BeanPostProcessor, BeanClassLoaderAware, BeanNameAware, BeanFactoryAware,
		ApplicationContextAware, InitializingBean {
	private String name;
	private int age;

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				'}';
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	Person() {
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("===================Person 的 BeanFactoryPostProcessor==================");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("===================Person 的 postProcessBeforeInitialization==================");
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("===================Person 的 postProcessAfterInitialization==================");
		return null;
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("===================Person 的 setBeanClassLoader==================");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("===================Person 的 setBeanFactory==================");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("===================Person 的 setBeanName==================");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("===================Person 的 setApplicationContext==================");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("===================Person 的 afterPropertiesSet==================");
	}
}
