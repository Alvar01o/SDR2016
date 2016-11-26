package com.uni.sd.subastadora.dto.bid;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseResult;

@XmlRootElement(name = "bidResult")
public class BidResult extends BaseResult<BidDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<BidDTO> getBids() {
		return getList();
	}

	public void setBids(List<BidDTO> dtos) {
		super.setList(dtos);
	}
}
