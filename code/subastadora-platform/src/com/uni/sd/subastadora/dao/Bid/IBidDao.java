package com.uni.sd.subastadora.dao.Bid;

import java.util.List;

import com.uni.sd.subastadora.dao.base.IBaseDao;
import com.uni.sd.subastadora.domain.auction.AuctionDomain;

public interface IBidDao extends IBaseDao<AuctionDomain> {

	public List<AuctionDomain>find(String textToFind);
}
