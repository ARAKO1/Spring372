package com.springbook.biz;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UserVO
 *
 */
@Entity
@Table(name="UVO")
public class UserVO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String password;
	private String name;
	private String role;
	private String address;
	
	public UserVO() {}

	//getter/setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}
	
}
