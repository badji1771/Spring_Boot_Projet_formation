package com.example.demo.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component()
@Primary //Prioriser le bean a injecter
public class PdfReport implements ReportGenerator{

	@Override
	public void generate() {

		System.out.println("pdf report");
	}

}
