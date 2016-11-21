package com.uni.sd.subastadora.domain.user;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.uni.sd.subastadora.domain.base.BaseDomain;
import com.uni.sd.subastadora.domain.role.RoleDomain;

@Entity
@Table(name = "user")
public class UserDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "name", nullable = false, unique = true)
	private String _name;
	
	@Column(name = "password", nullable = false, unique = false)
	private String _password;

	@ManyToOne
	private RoleDomain _role;
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}
	

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}
	
	public RoleDomain getRole() {
		return _role;
	}

	public void setRole(RoleDomain role) {
		_role = role;
	}

}
