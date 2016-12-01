package com.uni.sd.subastadora.service.role;

import java.util.List;

import com.uni.sd.subastadora.beans.role.RoleB;
import com.uni.sd.subastadora.dto.role.RoleDTO;
import com.uni.sd.subastadora.services.base.IBaseService;

public interface IRoleService extends IBaseService<RoleB, RoleDTO> {
	public List <RoleB> find(String textToFind);
}
