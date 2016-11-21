package com.uni.sd.subastadora.dto.user;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseResult;

@XmlRootElement(name = "userResult")
public class UserResult extends BaseResult<UserDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<UserDTO> getCountries() {
		return getList();
	}

	public void setCountries(List<UserDTO> dtos) {
		super.setList(dtos);
	}
}
