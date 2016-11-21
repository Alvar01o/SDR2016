package com.uni.sd.subastadora.dao.user;

import java.util.List;

import com.uni.sd.subastadora.dao.base.IBaseDao;
import com.uni.sd.subastadora.domain.user.UserDomain;

public interface IUserDao extends IBaseDao<UserDomain> {

	public List<UserDomain>find(String textToFind);
}
