package com.uni.sd.subastadora.dto.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseDTO;

@XmlRootElement(name = "user")
public class UserDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String _username;
	private String _name;
	private String _lastname;
	private String _email;	
	private String _address;	
	private String _password;		
	private Integer _rolId;
	
	@XmlElement
 	public Integer getRolId() {
 		return _rolId;
 	}
	
	public void setRolId(Integer rolId) {
 		_rolId = rolId;
 	}
	
	@XmlElement
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}
	@XmlElement
	public String getUserName() {
		return _username;
	}

	public void setUserName(String name) {
		_username = name;
	}
	
	@XmlElement
	public String getLastName() {
		return _lastname;
	}

	public void setLastName(String name) {
		_lastname = name;
	}
	
	@XmlElement
	public String getEmail() {
		return _email;
	}

	public void setEmail(String name) {
		_email = name;
	}	
	
	@XmlElement
	public String getaddress() {
		return _address;
	}

	public void setAddress(String name) {
		_address = name;
	}
	
	@XmlElement
	public String getPass() {
		return _password;
	}

	public void setPass(String name) {
		_password = name;
	}	



}
