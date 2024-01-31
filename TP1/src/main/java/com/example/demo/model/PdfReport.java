package com.example.demo.model;



public class PdfReport implements ReportGenerator{

	@Override
	public void generate() {

		System.out.println("pdf report");
	}

	@Override
	public void generate(String auteur) {

		System.out.println("pdf report : "+auteur);
	}

}
