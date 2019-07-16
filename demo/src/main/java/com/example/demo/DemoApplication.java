package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@MapperScan("com.example.demo.mapper.newtest")
public class DemoApplication {

	public static void main(String[] args) {
		run(DemoApplication.class, args);
	}

}
//}
