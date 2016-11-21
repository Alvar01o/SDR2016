package com.uni.sd.subastadora.dto.auction;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseResult;

@XmlRootElement(name = "auctionResult")
public class AuctionResult extends BaseResult<AuctionDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<AuctionDTO> getCountries() {
		return getList();
	}

	public void setCountries(List<AuctionDTO> dtos) {
		super.setList(dtos);
	}
}
