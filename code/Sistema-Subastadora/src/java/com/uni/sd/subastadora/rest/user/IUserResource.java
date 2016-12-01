package com.uni.sd.subastadora.rest.user;

import com.uni.sd.subastadora.dto.user.UserDTO;
import com.uni.sd.subastadora.dto.user.UserResult;
import com.uni.sd.subastadora.rest.base.IBaseResource;

public interface IUserResource extends IBaseResource<UserDTO> {

	public UserResult getAll();
	public UserResult find(String textToFind, int maxItems, int page);
	public UserResult find(String textToFind);
}

