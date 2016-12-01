package com.uni.sd.subastadora.service.auction;

import java.util.List;

import com.uni.sd.subastadora.beans.auction.AuctionB;
import com.uni.sd.subastadora.dto.auction.AuctionDTO;
import com.uni.sd.subastadora.services.base.IBaseService;

public interface IAuctionService extends IBaseService<AuctionB, AuctionDTO> {
	public List <AuctionB> find(String textToFind);
}
