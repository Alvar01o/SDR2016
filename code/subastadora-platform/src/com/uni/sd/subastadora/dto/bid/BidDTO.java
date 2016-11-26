package com.uni.sd.subastadora.dto.bid;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.domain.auction.AuctionDomain;
import com.uni.sd.subastadora.domain.typeBid.TypeBidDomain;
import com.uni.sd.subastadora.domain.user.UserDomain;
import com.uni.sd.subastadora.dto.base.BaseDTO;

@XmlRootElement(name = "bid")
public class BidDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	
	private Integer _id;
	private Integer _amount;
	private Integer _auctionId;
	private Integer _typeBidId;
	private Integer _userId;
	
	
	
	@XmlElement
	public Integer getAmount(){
		return _amount;
	}
	
	@XmlElement
	public Integer getAuctionId(){
		return _auctionId;
	}
	
	@XmlElement
	public Integer getTypeBidId(){
		return _typeBidId;
	}
	
	@XmlElement
	public Integer getUserId(){
		return _userId;
	}
	
	
	public void setId(Integer id){
		_id=id;
		
	}
	
	public void setAmount(Integer amount){
		_amount=amount;
	}
	
	
	public void setAuctionId(Integer auction){
		_auctionId=auction;
		
	}
	
	public void setUserId(Integer user){
		_userId=user;
	}
	
	public void setTypeBidId(Integer typeBid){
		_typeBidId=typeBid;
	}
}
