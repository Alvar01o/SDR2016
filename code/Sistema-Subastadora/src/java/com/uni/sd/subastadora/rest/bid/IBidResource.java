package com.uni.sd.subastadora.rest.bid;

import com.uni.sd.subastadora.dto.bid.BidDTO;
import com.uni.sd.subastadora.dto.bid.BidResult;
import com.uni.sd.subastadora.rest.base.IBaseResource;

public interface IBidResource extends IBaseResource<BidDTO> {

	public BidResult getAll();
	public BidResult find(String textToFind, int maxItems, int page);
	public BidResult find(String textToFind);
}

