package com.uni.sd.subastadora.domain.role;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.uni.sd.subastadora.domain.base.BaseDomain;
import com.uni.sd.subastadora.domain.user.UserDomain;

@Entity
@Table(name = "role")
public class RoleDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "name", nullable = false, unique = true)
	private String _name;
	
	@OneToMany(mappedBy = "_role")
	private Set<UserDomain> _users = new HashSet<>();
	
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
	
	public Set<UserDomain> getUsers() {
		return _users;
	}

	public void setUsers(Set<UserDomain> users) {
		this._users = users;
	}

}
