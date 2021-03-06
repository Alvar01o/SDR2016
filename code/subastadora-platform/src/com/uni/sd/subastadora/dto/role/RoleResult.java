package com.uni.sd.subastadora.dto.role;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseResult;

@XmlRootElement(name = "roleResult")
public class RoleResult extends BaseResult<RoleDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<RoleDTO> getRoles() {
		return getList();
	}

	public void setRoles(List<RoleDTO> dtos) {
		super.setList(dtos);
	}
}
