package com.uni.sd.subastadora.rest.auction;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.auction.AuctionDTO;
import com.uni.sd.subastadora.dto.auction.AuctionResult;
import com.uni.sd.subastadora.dto.role.RoleDTO;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("auctionResource")
public class AuctionResourceImpl extends BaseResourceImpl<AuctionDTO> implements
		IAuctionResource {

	public AuctionResourceImpl() {
		super(AuctionDTO.class, "/auction");
	}

	@Override
	@CacheEvict(value = CACHE_REGION, key = "'auctions'")
	@CachePut(value = CACHE_REGION, key = "'auction_' + #auction.id", condition = "#auction.id!=null")
	public AuctionDTO save(AuctionDTO auction) {
		/*AuctionDTO newDto = super.save(auction);
		if (null == auction.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"auction_" + newDto.getId(), newDto);
		}
		return newDto;
		*/
		final AuctionDTO newAuction = getWebResource().entity(auction).post(
				getDtoClass());
		return newAuction;
		
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'auction_' + #id")
	public AuctionDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'auctions'")
	public AuctionResult getAll() {
		
		final AuctionResult result = getWebResource().get(AuctionResult.class);
		return result;
	}

	@Override
	public AuctionResult find(String textToFind, int maxItems, int page) {
		
		final AuctionResult result = findWR(textToFind, maxItems, page).get(
				AuctionResult.class);
		return result;
	}
	

	public AuctionResult find(String textToFind) {
		
		final AuctionResult result = getWebResource().path("/search/" + textToFind).get(AuctionResult.class);
		return result;
	}

}
