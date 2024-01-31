package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.service.ReportService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ReportConfig.class);
		

		ReportService service = context.getBean("reportService",ReportService.class);
		service.generateReport();
	}

}