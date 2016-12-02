package com.uni.sd.subastadora.rest.user;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.auction.AuctionDTO;
import com.uni.sd.subastadora.dto.user.UserDTO;
import com.uni.sd.subastadora.dto.user.UserResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("userResource")
public class UserResourceImpl extends BaseResourceImpl<UserDTO> implements
		IUserResource {

	public UserResourceImpl() {
		super(UserDTO.class, "/user");
	}

	@Override
	@CacheEvict(value = CACHE_REGION, key = "'users'")
	@CachePut(value = CACHE_REGION, key = "'user_' + #user.id", condition = "#user.id!=null")
	public UserDTO save(UserDTO user) {
		/*UserDTO newDto = super.save(user);
		if (null == user.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"user_" + newDto.getId(), newDto);
		}
		return newDto;
		
		*/
		final UserDTO newUser = getWebResource().entity(user).post(
				getDtoClass());
		return newUser;
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'user_' + #id")
	public UserDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'users'")
	public UserResult getAll() {
		
		final UserResult result = getWebResource().get(UserResult.class);
		return result;
	}

	@Override
	public UserResult find(String textToFind, int maxItems, int page) {
		
		final UserResult result = findWR(textToFind, maxItems, page).get(
				UserResult.class);
		return result;
	}
	

	public UserResult find(String textToFind) {
		
		final UserResult result = getWebResource().path("/search/" + textToFind).get(UserResult.class);
		return result;
	}

}
