package com.uni.sd.subastadora.dto.typeBid;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseResult;

@XmlRootElement(name = "typeBidResult")
public class TypeBidResult extends BaseResult<TypeBidDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<TypeBidDTO> getTypeBids() {
		return getList();
	}

	public void setTypeBids(List<TypeBidDTO> dtos) {
		super.setList(dtos);
	}
}
