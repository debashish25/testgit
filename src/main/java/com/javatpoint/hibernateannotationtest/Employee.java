package com.javatpoint.hibernateannotationtest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "Fetchbasedonid", query = "from Employee where id=:id"),
		@NamedQuery(name = "Fetchbasedonname", query = "from Employee where firstName=:firstName") })
@Entity
@Table(name = "emp500")
public class Employee {

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName, lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}