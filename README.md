# IDEA构建spring源码

# 环境
win10 + jdk1.8.0_211 + IntelliJ IDEA 2019.1.3

# 步骤

## 下载
在官网下载最新版的spring-framework-5.0.x源码(https://github.com/spring-projects/spring-framework/tree/5.0.x)

## 构建

1. 进入源码目录，打开cmd窗口，输入 ```gradlew :spring-oxm:compileTestJava```
2. 打开Intellij IDEA，依次选择```File -> New -> Project from Existing Sources -> spring项目根目录 -> 选择 build.gradle```，然后如下图，一路ok即可。
3. 新建自己的module，建议新建gradle项目。
4. 再新建的项目中添加依赖`compile(project(":spring-context"))`
6. 测试
编写Main程序，如下：
```java
package org.springframework.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Main {

	@Bean("person")
	public Person person() {
		return new Person("Hello");
	}
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		System.out.println((Person) context.getBean("person"));
	}

}

class Person {
	String name;

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name) {
		this.name = name;
	}
}
```

6. bug修改

点击运行后，项目会报错，具体内容如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190628230753766.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3OTc4MTMw,size_16,color_FFFFFF,t_70)

原因是：`spring-context`项目中引用了`spring-instrument`项目，所以这里要修改module `spring-context`下的`build.gradle`。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190628230828424.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3OTc4MTMw,size_16,color_FFFFFF,t_70)

7. 运行成功，效果如下
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019062823083756.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3OTc4MTMw,size_16,color_FFFFFF,t_70)
