package com.uni.sd.subastadora.dto.announcement;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseDTO;


@XmlRootElement(name = "announcement")

public class AnnouncementDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Integer _userId; //user id 
	private Integer _productId;

	@XmlElement
	public Integer getUserId() {
		return _userId;
	}

	public void setUserId(Integer id) {
		_userId = id;
	}
	
	@XmlElement
	public Integer getProductId() {
		return _productId;
	}

	public void setProductId(Integer id) {
		_productId = id;
	}



}
