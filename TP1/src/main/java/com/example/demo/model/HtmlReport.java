package com.example.demo.model;



public class HtmlReport implements ReportGenerator{

	@Override
	public void generate() {

		System.out.println("Html report");
	}

	@Override
	public void generate(String auteur) {

		System.out.println("Html report : "+auteur);
	}

}
