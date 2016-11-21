package com.uni.sd.subastadora.service.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.sd.subastadora.dao.role.RoleDaoImpl;
import com.uni.sd.subastadora.dao.role.IRoleDao;
import com.uni.sd.subastadora.domain.role.RoleDomain;
import com.uni.sd.subastadora.dto.role.RoleDTO;
import com.uni.sd.subastadora.dto.role.RoleResult;
import com.uni.sd.subastadora.service.base.BaseServiceImpl;

@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleDTO, RoleDomain, RoleDaoImpl, RoleResult>
		implements IRoleService {
	@Autowired
	private IRoleDao roleDao=new RoleDaoImpl();

	@Override
	@Transactional
	public RoleDTO save(RoleDTO dto) {
		final RoleDomain domain = convertDtoToDomain(dto);
		final RoleDomain roleDomain = roleDao.save(domain);
		return convertDomainToDto(roleDomain);
	}

	@Override
	@Transactional
	public RoleDTO getById(Integer id) {
		final RoleDomain domain = roleDao.getById(id);
		final RoleDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public RoleResult getAll() {
		final List<RoleDTO> roles = new ArrayList<>();
		for (RoleDomain domain : roleDao.findAll()) {
			final RoleDTO dto = convertDomainToDto(domain);
			roles.add(dto);
		}
		final RoleResult rolesResult = new RoleResult();
		rolesResult.setRoles(roles);
		return rolesResult;
	}

	@Override
	@Transactional
	public RoleResult find(String textToFind) {
		final List<RoleDTO> roles = new ArrayList<>();
		for (RoleDomain domain : roleDao.find(textToFind)) {
			final RoleDTO dto = convertDomainToDto(domain);
			roles.add(dto);
		}
		final RoleResult rolResult = new RoleResult();
		rolResult.setRoles(roles);
		return rolResult;
	}

	@Override
	protected RoleDTO convertDomainToDto(RoleDomain domain) {
		final RoleDTO dto = new RoleDTO();
		dto.setId(domain.getId());
		dto.setName(domain.getName());
		return dto;
	}

	@Override
	protected RoleDomain convertDtoToDomain(RoleDTO dto) {
		final RoleDomain domain = new RoleDomain();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		return domain;
	}

}
