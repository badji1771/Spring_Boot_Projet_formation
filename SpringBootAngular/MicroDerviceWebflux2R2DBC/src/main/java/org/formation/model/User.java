package org.formation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class User {
	
	@Id
	private Integer id;
	private String name;
	private Integer balance;
	public User() {
		super();
	}
	public User(String name, Integer balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	
	

}
