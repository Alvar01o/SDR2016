package com.uni.sd.subastadora.service.user;

import com.uni.sd.subastadora.dao.user.UserDaoImpl;
import com.uni.sd.subastadora.domain.user.UserDomain;
import com.uni.sd.subastadora.dto.user.UserDTO;
import com.uni.sd.subastadora.dto.user.UserResult;
import com.uni.sd.subastadora.service.base.IBaseService;

public interface IUserService extends IBaseService<UserDTO, UserDomain, UserDaoImpl, UserResult> {

	public UserResult find(String textToFind);
}
