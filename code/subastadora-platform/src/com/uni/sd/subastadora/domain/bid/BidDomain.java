package com.uni.sd.subastadora.domain.bid;


import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.uni.sd.subastadora.domain.base.BaseDomain;
import com.uni.sd.subastadora.domain.typeBid.TypeBidDomain;
import com.uni.sd.subastadora.domain.user.UserDomain;


import com.uni.sd.subastadora.domain.auction.AuctionDomain;

@Entity
@Table(name = "bid")
public class BidDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "amount")
	private Integer _amount;

	@ManyToOne
	private AuctionDomain _auction;
	
	@ManyToOne 
	private TypeBidDomain _typeBid;
	
	@ManyToOne
	private UserDomain _user;
	
	public Integer getId(){
		return _id;
	}
	
	
	public Integer getAmount(){
		return _amount;
	}
	
	public AuctionDomain getAuction(){
		return _auction;
	}
	
	
	public TypeBidDomain getTypeBid(){
		return _typeBid;
	}
	
	
	public UserDomain getUser(){
		return _user;
	}
	
	
	public void setId(Integer id){
		_id=id;
		
	}
	
	public void setAmount(Integer amount){
		_amount=amount;
	}
	
	
	public void setAuction(AuctionDomain auction){
		_auction=auction;
		
	}
	
	public void setUser(UserDomain user){
		_user=user;
	}
	
	public void setTypeBid(TypeBidDomain typeBid){
		_typeBid=typeBid;
	}
}
