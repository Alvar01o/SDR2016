package com.uni.sd.subastadora.beans.bid;

import java.util.Map;
import org.apache.commons.lang.StringUtils;

import com.uni.sd.subastadora.beans.auction.AuctionB;
import com.uni.sd.subastadora.beans.base.BaseBean;
import com.uni.sd.subastadora.beans.typeBid.TypeBidB;
import com.uni.sd.subastadora.beans.user.UserB;

public class BidB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private Integer _amount;
	private AuctionB _auction;
	private TypeBidB _typeBid;
	private UserB _user;

	public BidB(Map<String, String> params) {
		super(params);
	}

	
	public Integer getAmount(){
		return _amount;
	}
	
	public AuctionB getAuction(){
		return _auction;
	}
	
	
	public TypeBidB getTypeBid(){
		return _typeBid;
	}
	
	
	public UserB getUser(){
		return _user;
	}
	

	public void setAmount(Integer amount){
		_amount=amount;
	}
	
	
	public void setAuction(AuctionB auction){
		_auction=auction;
		
	}
	
	public void setUser(UserB user){
		_user=user;
	}
	
	public void setTypeBid(TypeBidB typeBid){
		_typeBid=typeBid;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		
	}

}
