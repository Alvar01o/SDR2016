package com.uni.sd.subastadora.rest.typeBid;

import com.uni.sd.subastadora.dto.typeBid.TypeBidDTO;
import com.uni.sd.subastadora.dto.typeBid.TypeBidResult;
import com.uni.sd.subastadora.rest.base.IBaseResource;

public interface ITypeBidResource extends IBaseResource<TypeBidDTO> {

	public TypeBidResult getAll();
	public TypeBidResult find(String textToFind, int maxItems, int page);
	public TypeBidResult find(String textToFind);
}

