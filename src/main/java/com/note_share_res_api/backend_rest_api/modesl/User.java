package com.note_share_res_api.backend_rest_api.modesl;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity(name="user_details")
public class User {
	
	public User() {
		
	}
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String email;
	
	
	public User(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
        // this.email = email;
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

	 public String getEmail(){
        return email;
     }

     public void setEmail(String email){
        this.email = email;
     }

 
}
