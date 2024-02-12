package org.formation.hibernate.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Contrat {
	
	private LocalDate date;
	private int num;
	private String code;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(code, date, num);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrat other = (Contrat) obj;
		return Objects.equals(code, other.code) && Objects.equals(date, other.date) && num == other.num;
	}
	
	
	

}
