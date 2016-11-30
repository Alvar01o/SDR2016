package com.uni.sd.subastadora.service.role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.sd.subastadora.beans.creditCard.CreditCardB;
import com.uni.sd.subastadora.beans.role.RoleB;
import com.uni.sd.subastadora.dto.creditCard.CreditCardDTO;
import com.uni.sd.subastadora.dto.creditCard.CreditCardResult;
import com.uni.sd.subastadora.dto.role.RoleDTO;
import com.uni.sd.subastadora.dto.role.RoleResult;
import com.uni.sd.subastadora.rest.role.IRoleResource;
import com.uni.sd.subastadora.rest.role.RoleResourceImpl;
import com.uni.sd.subastadora.services.base.BaseServiceImpl;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<RoleB, RoleDTO>
		implements IRoleService {
	@Autowired
	private IRoleResource _roleResource=new RoleResourceImpl();
	
	
	public RoleServiceImpl() {
	}

	@Override
	public RoleB save(RoleB bean) {
		final RoleDTO dto = convertBeanToDto(bean);
		final RoleDTO roleDTO = _roleResource.save(dto);
		return convertDtoToBean(roleDTO);
	}

	@Override
	public List<RoleB> getAll() {
		final RoleResult result = _roleResource.getAll();
		final List<RoleDTO> cList = null == result.getRoles() ? new ArrayList<RoleDTO>()
				: result.getRoles();
		final List<RoleB> roles = new ArrayList<RoleB>();

		for (RoleDTO dto : cList) {
			final RoleB roleB = convertDtoToBean(dto);
			roles.add(roleB);
		}
		return roles;
	}

	@Override
	public RoleB getById(Integer id) {
		final RoleDTO dto = _roleResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected RoleB convertDtoToBean(RoleDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
		final RoleB roleB = new RoleB(params);
		return roleB;
	}

	@Override
	protected RoleDTO convertBeanToDto(RoleB bean) {
		final RoleDTO dto = new RoleDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		return dto;
	}
	@Override						
	public List<RoleB> find(String textToFind) {		//int maxItems, int page
		final RoleResult result = _roleResource.find(textToFind);
		final List<RoleDTO> rList = null == result.getRoles() ? new ArrayList<RoleDTO>()
				: result.getRoles();

		final List<RoleB> roles = new ArrayList<RoleB>();
		for (RoleDTO dto : rList) {
			final RoleB bean = convertDtoToBean(dto);
			roles.add(bean);
		}
		return roles;
	}

}
