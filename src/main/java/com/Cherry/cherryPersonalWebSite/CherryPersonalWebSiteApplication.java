package com.Cherry.cherryPersonalWebSite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com")
@MapperScan(basePackages="com.mapper")
public class CherryPersonalWebSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CherryPersonalWebSiteApplication.class, args);
	}

}

