package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.model.HtmlReport;
import com.example.demo.model.PdfReport;
import com.example.demo.model.ReportGenerator;
import com.example.demo.service.ReportService;

@Configuration
public class ReportConfig {

	//Cette methode detect deux bean
//	@Bean
//	 ReportGenerator reportGenerator(ReportGenerator reportGenerator) {
//		return new ReportService(reportGenerator);
//	}
	
	//ici on specifie le bean a utiliser
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	 ReportService reportService(ReportGenerator pdfReport) {
		return new ReportService(pdfReport);
	}
	@Bean
	 ReportGenerator pdfReport() {
		return new PdfReport();
	}
	@Bean
	ReportGenerator htmlReport() {
		return new HtmlReport();
	}
}
