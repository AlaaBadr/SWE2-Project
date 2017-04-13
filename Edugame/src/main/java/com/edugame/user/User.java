package com.edugame.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Inheritance
@Table(name = "user")
public abstract class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5744958939104552952L;

	@Column(name = "name")
	private String name;

	@Column(name = "gender")
	private String gender;

	@Column(name = "age")
	private int age;

	@Column(unique = true, name = "email")
	private String email;

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "identity")
	private String identity;

	public User() {
	}

	public User(String name, String gender, int age, String email, String username, String password) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public void setIdentity(String Identity) {
		this.identity = Identity;
	}

	public String getIdentity() {
		return identity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
