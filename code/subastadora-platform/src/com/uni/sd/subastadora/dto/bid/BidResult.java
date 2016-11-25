package com.uni.sd.subastadora.dto.bid;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseResult;

@XmlRootElement(name = "auctionResult")
public class BidResult extends BaseResult<BidDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<BidDTO> getCountries() {
		return getList();
	}

	public void setCountries(List<BidDTO> dtos) {
		super.setList(dtos);
	}
}
