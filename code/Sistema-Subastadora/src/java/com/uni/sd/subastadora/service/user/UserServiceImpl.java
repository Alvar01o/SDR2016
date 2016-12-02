package com.uni.sd.subastadora.service.user;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.sd.subastadora.beans.user.UserB;
import com.uni.sd.subastadora.dto.user.UserDTO;
import com.uni.sd.subastadora.dto.user.UserResult;
import com.uni.sd.subastadora.rest.user.IUserResource;
import com.uni.sd.subastadora.rest.user.UserResourceImpl;
import com.uni.sd.subastadora.services.base.BaseServiceImpl;
import com.uni.sd.subastadora.service.role.IRoleService;
import com.uni.sd.subastadora.service.role.RoleServiceImpl;
import com.uni.sd.subastadora.service.user.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserB, UserDTO>
		implements IUserService {
	
	
	@Autowired
	private IRoleService _roleService=new RoleServiceImpl();
	
	@Autowired
	private IUserResource _userResource=new UserResourceImpl();
	
	public UserServiceImpl() {
	}

	@Override
	public UserB save(UserB bean) {
		final UserDTO dto = convertBeanToDto(bean);
		final UserDTO userDTO = _userResource.save(dto);
		return convertDtoToBean(userDTO);
	}

	@Override
	public List<UserB> getAll() {
		final UserResult result = _userResource.getAll();
		final List<UserDTO> cList = null == result.getUsers() ? new ArrayList<UserDTO>()
				: result.getUsers();
		final List<UserB> bids = new ArrayList<UserB>();

		for (UserDTO dto : cList) {
			final UserB bidB = convertDtoToBean(dto);
			bids.add(bidB);
		}
		return bids;
	}

	@Override
	public UserB getById(Integer id) {
		final UserDTO dto = _userResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected UserB convertDtoToBean(UserDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name",dto.getName());
		params.put("adress", dto.getaddress());
		params.put("email",dto.getEmail());
		params.put("lastName", dto.getLastName());
		params.put("userName",dto.getUserName());
		params.put("password", dto.getPass());
		
		final UserB userB = new UserB(params);
		userB.setRole(_roleService.getById(dto.getRolId()));
		
		return userB;
	}

	@Override
	protected UserDTO convertBeanToDto(UserB bean) {
		final UserDTO dto = new UserDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setLastName(bean.getLastName());
		dto.setUserName(bean.getUserName());
		dto.setAddress(bean.getaddress());
		dto.setEmail(bean.getEmail());
		dto.setPass(bean.getPassword());
		dto.setRolId(bean.getRole().getId());
		return dto;
	}
	
	@Override						
	public List<UserB> find(String textToFind) {		//int maxItems, int page
		final UserResult result = _userResource.find(textToFind);
		final List<UserDTO> rList = null == result.getUsers() ? new ArrayList<UserDTO>()
				: result.getUsers();

		final List<UserB> bids = new ArrayList<UserB>();
		for (UserDTO dto : rList) {
			final UserB bean = convertDtoToBean(dto);
			bids.add(bean);
		}
		return bids;
	}

	@Override
	public List<UserB> find (String textToFind, int maxItems, int page) {
		final UserResult result = _userResource.find(textToFind, maxItems, page);
		final List<UserDTO> rList = null == result.getUsers() ? new ArrayList<UserDTO>()
				: result.getUsers();

		final List<UserB> users = new ArrayList<UserB>();
		for (UserDTO dto : rList) {
			final UserB bean = convertDtoToBean(dto);
			users.add(bean);
		}
		return users;
	}

}
