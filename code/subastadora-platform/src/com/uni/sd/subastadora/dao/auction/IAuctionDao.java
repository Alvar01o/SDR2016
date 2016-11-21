package com.uni.sd.subastadora.dao.auction;

import java.util.List;

import com.uni.sd.subastadora.dao.base.IBaseDao;
import com.uni.sd.subastadora.domain.auction.AuctionDomain;

public interface IAuctionDao extends IBaseDao<AuctionDomain> {

	public List<AuctionDomain>find(String textToFind);
}
