package com.uni.sd.subastadora.rest.role;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
	@CacheEvict(value = CACHE_REGION, key = "'roles'")
	@CachePut(value = CACHE_REGION, key = "'role_' + #role.id", condition = "#role.id!=null")
	public RoleDTO save(RoleDTO role) {
		//RoleDTO newDto = super.save(role);
		/*if (null == role.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"role_" + newDto.getId(), newDto);
		}*/
		
		//return newDto;
		final RoleDTO newRole = getWebResource().entity(role).post(
				getDtoClass());
		return newRole;
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'role_' + #id")
	public RoleDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'roles'")
	public RoleResult getAll() {
		
		final RoleResult result = getWebResource().get(RoleResult.class);
		return result;
	}

	@Override
	public RoleResult find(String textToFind, int maxItems, int page) {
		
		final RoleResult result = findWR(textToFind, maxItems, page).get(
				RoleResult.class);
		return result;
	}
	

	public RoleResult find(String textToFind) {
		
		final RoleResult result = getWebResource().path("/search/" + textToFind).get(RoleResult.class);
		return result;
	}

}
