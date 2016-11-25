package com.uni.sd.subastadora.dto.typeBid;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseResult;

@XmlRootElement(name = "auctionResult")
public class TypeBidResult extends BaseResult<TypeBidDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<TypeBidDTO> getCountries() {
		return getList();
	}

	public void setCountries(List<TypeBidDTO> dtos) {
		super.setList(dtos);
	}
}
