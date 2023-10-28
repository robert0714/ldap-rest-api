package com.ruriel.ldap.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ruriel.ldap.model.User;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class ResponseDTO {

	private String message;
	private List<User> users = new ArrayList<User>();
	 
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
}
