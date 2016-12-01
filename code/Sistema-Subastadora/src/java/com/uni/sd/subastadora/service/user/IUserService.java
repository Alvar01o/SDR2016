package com.uni.sd.subastadora.service.user;

import java.util.List;

import com.uni.sd.subastadora.beans.user.UserB;
import com.uni.sd.subastadora.dto.user.UserDTO;
import com.uni.sd.subastadora.services.base.IBaseService;

public interface IUserService extends IBaseService<UserB, UserDTO> {
	public List <UserB> find(String textToFind);
}
