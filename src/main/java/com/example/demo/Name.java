package com.example.demo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NAMES")
public class Name {

	@Column(name="NAME")
	private String name;

	public Name() {
	}

	public Name(String name) {
		this.name = name;
	}

	@Id
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Name [name=" + name + "]";
	}
	

}
