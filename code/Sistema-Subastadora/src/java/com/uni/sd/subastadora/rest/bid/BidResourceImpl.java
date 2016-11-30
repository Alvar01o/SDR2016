package com.uni.sd.subastadora.rest.bid;

import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.bid.BidDTO;
import com.uni.sd.subastadora.dto.bid.BidResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("bidResource")
public class BidResourceImpl extends BaseResourceImpl<BidDTO> implements IBidResource {

	public BidResourceImpl() {
		super(BidDTO.class, "/bid");
	}

	@Override
	public BidResult getAll() {
		final BidResult result = getWebResource().get(BidResult.class);
		return result;
	}
	
	@Override
	public BidResult find(String textToFind) {
		final BidResult result = findWR(textToFind).get(BidResult.class);
		return result;
	}

}
