package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class HtmlReport implements ReportGenerator{

	@Override
	public void generate() {

		System.out.println("Html report");
	}

}