package com.java8.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableSwagger2
public class Demo1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Demo1Application.class, args);
//		Map<String, Object> props = new HashMap<>();
//		props.put("hello1", "value1");
//		PropertySource propertySource = new MapPropertySource("myPropertySource", props);
//		run.getEnvironment().getPropertySources().addLast(propertySource);
//		PropertySource<?> myPropertySource = run.getEnvironment().getPropertySources().get("myPropertySource");
//		Object hello1 = myPropertySource.getProperty("hello1");
//		System.out.println(hello1);
	}
}
