package com.example.demo.service;


import com.example.demo.model.ReportGenerator;


public class ReportService {


	
	private ReportGenerator reportGenerator ;
	private String auteur;
	
	
	
	public ReportService(ReportGenerator reportGenerator) {
		super();
		this.reportGenerator = reportGenerator;
	}



//	public void generateReport() {
//		reportGenerator.generate();
//	}
	public void generateReport() {
		reportGenerator.generate(auteur);
	}



	public String getAuteur() {
		return auteur;
	}



	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	
	
}
