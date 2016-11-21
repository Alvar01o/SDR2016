package com.uni.sd.subastadora.dao.role;

import java.util.List;

import com.uni.sd.subastadora.dao.base.IBaseDao;
import com.uni.sd.subastadora.domain.role.RoleDomain;

public interface IRoleDao extends IBaseDao<RoleDomain> {

	public List<RoleDomain>find(String textToFind);
}
