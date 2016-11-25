package com.uni.sd.subastadora.service.bid;

import com.uni.sd.subastadora.dao.auction.AuctionDaoImp;
import com.uni.sd.subastadora.domain.auction.AuctionDomain;
import com.uni.sd.subastadora.dto.auction.AuctionDTO;
import com.uni.sd.subastadora.dto.auction.AuctionResult;
import com.uni.sd.subastadora.service.base.IBaseService;

public interface IBidService extends IBaseService<AuctionDTO, AuctionDomain, AuctionDaoImp, AuctionResult> {

	public AuctionResult find(String textToFind);
}
