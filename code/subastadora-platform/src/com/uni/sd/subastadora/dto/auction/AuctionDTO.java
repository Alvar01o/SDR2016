package com.uni.sd.subastadora.dto.auction;

import java.sql.Time;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseDTO;

@XmlRootElement(name = "auction")
public class AuctionDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/*AGREGAR PRODUCTO ID*/
	private Date _auction_time; 
	private Integer _winner_id; //user id 
	private Integer _productId;

	@XmlElement
	public Integer getWinnerId() {
		return _winner_id;
	}

	public void setWinnerId(Integer id) {
		_winner_id = id;
	}
	
	@XmlElement
	public Integer getProductId() {
		return _productId;
	}

	public void setProductId(Integer id) {
		_productId = id;
	}

	@XmlElement
	public Date getTime() {
		return _auction_time;
	}

	public void setTime(Date t) {
		_auction_time = t;
	}
}
