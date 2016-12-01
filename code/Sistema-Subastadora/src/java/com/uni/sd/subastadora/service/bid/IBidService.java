package com.uni.sd.subastadora.service.bid;


import java.util.List;

import com.uni.sd.subastadora.beans.auction.AuctionB;
import com.uni.sd.subastadora.beans.bid.BidB;
import com.uni.sd.subastadora.dto.bid.BidDTO;
import com.uni.sd.subastadora.services.base.IBaseService;

public interface IBidService extends IBaseService<BidB, BidDTO> {
	public List <BidB> find(String textToFind);
}
