package com.jpastarterexample.in21mincourse.jpastarterexample;

import com.jpastarterexample.in21mincourse.jpastarterexample.service.EmployeeService;
import com.jpastarterexample.in21mincourse.jpastarterexample.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JpaStarterExampleIn21mincourseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(JpaStarterExampleIn21mincourseApplication.class, args);
//		ProductService productService = run.getBean("productService", ProductService.class);
//		productService.createProduct();
//		EmployeeService employeeService = run.getBean("employeeService", EmployeeService.class);
//		employeeService.saveDummyEmployees();
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
