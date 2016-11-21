package com.uni.sd.subastadora.service.role;

import com.uni.sd.subastadora.dao.role.RoleDaoImpl;
import com.uni.sd.subastadora.domain.role.RoleDomain;
import com.uni.sd.subastadora.dto.role.RoleDTO;
import com.uni.sd.subastadora.dto.role.RoleResult;
import com.uni.sd.subastadora.service.base.IBaseService;

public interface IRoleService extends IBaseService<RoleDTO, RoleDomain, RoleDaoImpl, RoleResult> {

	public RoleResult find(String textToFind);
}
