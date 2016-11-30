package com.uni.sd.subastadora.rest.typeBid;

import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.typeBid.TypeBidDTO;
import com.uni.sd.subastadora.dto.typeBid.TypeBidResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("typeBidResource")
public class TypeBidResourceImpl extends BaseResourceImpl<TypeBidDTO> implements ITypeBidResource {

	public TypeBidResourceImpl() {
		super(TypeBidDTO.class, "/typeBid");
	}

	@Override
	public TypeBidResult getAll() {
		final TypeBidResult result = getWebResource().get(TypeBidResult.class);
		return result;
	}
	
	@Override
	public TypeBidResult find(String textToFind) {
		final TypeBidResult result = findWR(textToFind).get(TypeBidResult.class);
		return result;
	}

}
