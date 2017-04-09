package com.edugame.user;

import java.util.Date;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

//@Entity
public abstract class User {
	
	 private String name;
	   private String gender;
	   private int age;
	   private String email;
	   private String username;
	   private String password;
	   private int ID;
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
	        this.ID= (int) new Date().getTime();
	    }

	    public void setIdentity(String Identity){
	        this.identity=Identity;
	    }
	    public String getIdentity(){
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

	    public int getID() {
	        return ID;
	    }
	    
	    void setID() {
	        this.ID = (int) new Date().getTime();
	    }

}
