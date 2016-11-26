package com.uni.sd.subastadora.dao.bid;

import java.util.List;

import com.uni.sd.subastadora.dao.base.IBaseDao;
import com.uni.sd.subastadora.domain.bid.BidDomain;

public interface IBidDao extends IBaseDao<BidDomain> {

	public List<BidDomain>find(String textToFind);
}
