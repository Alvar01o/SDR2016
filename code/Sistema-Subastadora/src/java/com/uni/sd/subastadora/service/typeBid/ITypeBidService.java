package com.uni.sd.subastadora.service.typeBid;

import java.util.List;

import com.uni.sd.subastadora.beans.typeBid.TypeBidB;
import com.uni.sd.subastadora.dto.typeBid.TypeBidDTO;
import com.uni.sd.subastadora.services.base.IBaseService;

public interface ITypeBidService extends IBaseService<TypeBidB, TypeBidDTO> {
	public List <TypeBidB> find(String textToFind);
}
