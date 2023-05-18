package com.zlx.ict4d.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;


@SpringBootApplication
@EnableScheduling

public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Carry on !!!");


		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 其他配置项
		return factory.createMultipartConfig();
	}

}
