package com.uni.sd.subastadora.rest.bid;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.bid.BidDTO;
import com.uni.sd.subastadora.dto.bid.BidResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("bidResource")
public class BidResourceImpl extends BaseResourceImpl<BidDTO> implements
		IBidResource {

	public BidResourceImpl() {
		super(BidDTO.class, "/bid");
	}

	@Override
	@CacheEvict(value = CACHE_REGION, key = "'bids'")
	@CachePut(value = CACHE_REGION, key = "'bid_' + #bid.id", condition = "#bid.id!=null")
	public BidDTO save(BidDTO bid) {
		BidDTO newDto = super.save(bid);
		if (null == bid.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"bid_" + newDto.getId(), newDto);
		}
		return newDto;
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'bid_' + #id")
	public BidDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'bids'")
	public BidResult getAll() {
		
		final BidResult result = getWebResource().get(BidResult.class);
		return result;
	}

	@Override
	public BidResult find(String textToFind, int maxItems, int page) {
		
		final BidResult result = findWR(textToFind, maxItems, page).get(
				BidResult.class);
		return result;
	}
	

	public BidResult find(String textToFind) {
		
		final BidResult result = getWebResource().path("/search/" + textToFind).get(BidResult.class);
		return result;
	}

}
