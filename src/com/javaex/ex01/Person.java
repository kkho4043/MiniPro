package com.javaex.ex01;

public class Person {

	private String name;
	private String hp;
	private String company;
	
	
	
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getHp() {
		return hp;
	}

	protected void setHp(String hp) {
		this.hp = hp;
	}

	protected String getCompany() {
		return company;
	}

	protected void setCompany(String company) {
		this.company = company;
	}

	public Person() {
		
	}
	public Person(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	
	
	public void draw() {
		
		System.out.print(name + "\t");
		System.out.print(hp + "\t");
		System.out.print(company );
		System.out.println("");
	}
	
}
