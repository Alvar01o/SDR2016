package com.uni.sd.subastadora.beans.user;

import java.util.Map;



import org.apache.commons.lang.StringUtils;

import com.uni.sd.subastadora.beans.base.BaseBean;

import com.uni.sd.subastadora.beans.role.RoleB;

public class UserB extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String _name;
	private String _username;
	private String _lastname;	
	private String _email;
	private String _address;
	private String _password;
	private RoleB _role;
	
	public UserB(Map<String, String> params) {
		super(params);
	}
	
	public RoleB getRole() {
			return _role;
 	}
		 
 	public void setRole(RoleB role) {
 		_role = role;
	}	


	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getLastName() {
		return _lastname;
	}

	public void setLastName(String name) {
		_lastname = name;
	}
	
	public String getUserName() {
		return _username;
	}

	public void setUserName(String name) {
		_username = name;
	}
	
	public String getEmail() {
		return _email;
	}

	public void setEmail(String name) {
		_email = name;
	}	
	

	public String getaddress() {
		return _address;
	}

	public void setAddress(String name) {
		_address = name;
	}
	
	public String getPassword(){
		return _password;
	}
	
	public void setPassword(String password){
		_password=password;
	}
	
	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
		setEmail("email");
		setLastName("lastName");
		setPassword("password");
		setUserName("userName");
		setAddress("address");
	}

}
