package org.formation.hibernate.entity;

import javax.persistence.Embeddable;

@Embeddable  //Pour dire de remener tous les champs de adresse dans la table person
public class Address {

	private String street;
	private String city;
	private Long zipcode;

	public Address() {
	}

	public Address(String street, String city, Long zipcode) {
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getZipcode() {
		return zipcode;
	}

	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", zipcode=" + zipcode + "]";
	}

}
