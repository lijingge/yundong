package com.yundong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@MapperScan("com.yundong.mapper")
public class YundongApplication {

	public static void main(String[] args) {
		SpringApplication.run(YundongApplication.class, args);
	}

}
