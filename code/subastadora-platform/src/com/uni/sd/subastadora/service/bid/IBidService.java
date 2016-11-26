package com.uni.sd.subastadora.service.bid;

import com.uni.sd.subastadora.dao.bid.BidDaoImpl;
import com.uni.sd.subastadora.domain.bid.BidDomain;
import com.uni.sd.subastadora.dto.bid.BidDTO;
import com.uni.sd.subastadora.dto.bid.BidResult;
import com.uni.sd.subastadora.service.base.IBaseService;

public interface IBidService extends IBaseService<BidDTO, BidDomain, BidDaoImpl, BidResult> {

	public BidResult find(String textToFind);
}
