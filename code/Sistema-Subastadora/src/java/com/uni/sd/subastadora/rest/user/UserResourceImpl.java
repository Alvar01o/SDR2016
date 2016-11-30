package com.uni.sd.subastadora.rest.user;

import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.user.UserDTO;
import com.uni.sd.subastadora.dto.user.UserResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("userResource")
public class UserResourceImpl extends BaseResourceImpl<UserDTO> implements IUserResource {

	public UserResourceImpl() {
		super(UserDTO.class, "/user");
	}

	@Override
	public UserResult getAll() {
		final UserResult result = getWebResource().get(UserResult.class);
		return result;
	}
	
	@Override
	public UserResult find(String textToFind) {
		final UserResult result = findWR(textToFind).get(UserResult.class);
		return result;
	}

}
