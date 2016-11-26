package com.uni.sd.subastadora.service.typeBid;


import com.uni.sd.subastadora.dao.typeBid.TypeBidDaoImp;
import com.uni.sd.subastadora.domain.typeBid.TypeBidDomain;
import com.uni.sd.subastadora.dto.typeBid.TypeBidDTO;
import com.uni.sd.subastadora.dto.typeBid.TypeBidResult;
import com.uni.sd.subastadora.service.base.IBaseService;

public interface ITypeBidService extends IBaseService<TypeBidDTO, TypeBidDomain, TypeBidDaoImp, TypeBidResult> {

	public TypeBidResult find(String textToFind);
}
