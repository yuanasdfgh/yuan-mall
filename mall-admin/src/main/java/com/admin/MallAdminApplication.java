package com.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi

public class MallAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallAdminApplication.class, args);
	}

}
