package com.uni.sd.subastadora.rest.auction;

import com.uni.sd.subastadora.dto.auction.AuctionDTO;
import com.uni.sd.subastadora.dto.auction.AuctionResult;
import com.uni.sd.subastadora.rest.base.IBaseResource;

public interface IAuctionResource extends IBaseResource<AuctionDTO> {

	public AuctionResult getAll();
	public AuctionResult find(String textToFind);

}
