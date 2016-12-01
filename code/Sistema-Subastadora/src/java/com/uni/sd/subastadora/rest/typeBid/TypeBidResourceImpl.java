package com.uni.sd.subastadora.rest.typeBid;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.typeBid.TypeBidDTO;
import com.uni.sd.subastadora.dto.typeBid.TypeBidResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("typeBidResource")
public class TypeBidResourceImpl extends BaseResourceImpl<TypeBidDTO> implements
		ITypeBidResource {

	public TypeBidResourceImpl() {
		super(TypeBidDTO.class, "/typeBid");
	}

	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'typeBids'")
	//@CachePut(value = CACHE_REGION, key = "'typeBid_' + #typeBid.id", condition = "#typeBid.id!=null")
	public TypeBidDTO save(TypeBidDTO typeBid) {
		TypeBidDTO newDto = super.save(typeBid);
		/*if (null == typeBid.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"typeBid_" + newDto.getId(), newDto);
		}*/
		return newDto;
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'typeBid_' + #id")
	public TypeBidDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'typeBids'")
	public TypeBidResult getAll() {
		
		final TypeBidResult result = getWebResource().get(TypeBidResult.class);
		return result;
	}

	@Override
	public TypeBidResult find(String textToFind, int maxItems, int page) {
		
		final TypeBidResult result = findWR(textToFind, maxItems, page).get(
				TypeBidResult.class);
		return result;
	}
	

	public TypeBidResult find(String textToFind) {
		
		final TypeBidResult result = getWebResource().path("/search/" + textToFind).get(TypeBidResult.class);
		return result;
	}

}
