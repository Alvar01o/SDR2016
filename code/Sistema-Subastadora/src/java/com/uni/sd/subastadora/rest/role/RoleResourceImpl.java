package com.uni.sd.subastadora.rest.role;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.role.RoleDTO;
import com.uni.sd.subastadora.dto.role.RoleResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("roleResource")
public class RoleResourceImpl extends BaseResourceImpl<RoleDTO> implements
		IRoleResource {

	public RoleResourceImpl() {
		super(RoleDTO.class, "/role");
	}

	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'role_' + #dto.id", condition = "#dto.id!=null")
	public RoleDTO save(RoleDTO dto) {
		final RoleDTO role = getWebResource().entity(dto).post(
				getDtoClass());
		return role;
	}

	//@Cacheable(value = CACHE_REGION, key = "'role_' + #id")
	@Override
	public RoleDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public RoleResult getAll() {
		RoleResult roles = getWebResource().get(RoleResult.class);
		//for (RoleDTO role : roles.getRoles()) {
			//getCacheManager().getCache(CACHE_REGION).put(
			//		"role_" + role.getId(), role);
		//}
		return roles;
	}
}
