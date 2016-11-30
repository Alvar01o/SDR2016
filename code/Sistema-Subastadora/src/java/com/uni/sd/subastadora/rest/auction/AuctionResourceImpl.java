package com.uni.sd.subastadora.rest.auction;

import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.auction.AuctionDTO;
import com.uni.sd.subastadora.dto.auction.AuctionResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("auctionResource")
public class AuctionResourceImpl extends BaseResourceImpl<AuctionDTO> implements IAuctionResource {

	public AuctionResourceImpl() {
		super(AuctionDTO.class, "/auction");
	}

	@Override
	public AuctionResult getAll() {
		final AuctionResult result = getWebResource().get(AuctionResult.class);
		return result;
	}
	
	@Override
	public AuctionResult find(String textToFind) {
		final AuctionResult result = findWR(textToFind).get(AuctionResult.class);
		return result;
	}

}
