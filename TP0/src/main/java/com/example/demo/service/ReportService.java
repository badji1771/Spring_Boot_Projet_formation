package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.model.ReportGenerator;

import jakarta.annotation.Resource;
@Component
public class ReportService {

	@Autowired
//	@Qualifier("pdf")
//	@Resource(name= "htmlReport")
	private ReportGenerator reportGenerator ;
	
	public void generateReport() {
		reportGenerator.generate();
	}
}