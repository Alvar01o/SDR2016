package com.uni.sd.subastadora.dto.valuation;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.uni.sd.subastadora.dto.base.BaseResult;


@XmlRootElement(name = "valuationResult")
public class ValuationResult extends BaseResult<ValuationDTO> {

	private static final long serialVersionUID = 1L;
	
 	@XmlElement
 	public List<ValuationDTO> getValuations() {
 		return getList();
 	}
 
 	public void setValuations(List<ValuationDTO> dtos) {
 		super.setList(dtos);
 	}
 	
}
