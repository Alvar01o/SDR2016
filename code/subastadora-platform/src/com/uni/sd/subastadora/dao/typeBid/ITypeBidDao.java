package com.uni.sd.subastadora.dao.typeBid;


import java.util.List;

import com.uni.sd.subastadora.dao.base.IBaseDao;
import com.uni.sd.subastadora.domain.typeBid.TypeBidDomain;

public interface ITypeBidDao extends IBaseDao<TypeBidDomain> {

	public List<TypeBidDomain>find(String textToFind);
}

