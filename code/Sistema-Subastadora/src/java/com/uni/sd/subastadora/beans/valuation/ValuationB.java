package com.uni.sd.subastadora.beans.valuation;

import java.util.Map;



import org.apache.commons.lang.StringUtils;

import com.uni.sd.subastadora.beans.auction.AuctionB;
import com.uni.sd.subastadora.beans.base.BaseBean;
import com.uni.sd.subastadora.beans.user.UserB;

public class ValuationB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _name;

	public ValuationB(Map<String, String> params) {
		super(params);
	}


	private Integer _score;
	private AuctionB _auction;
	private UserB _auctioneer;
	private UserB _voter;
	
	
	public Integer getScore(){
		return _score;
	}
	
	public AuctionB getAuction(){
		return _auction;
	}
	
	
	public UserB getAuctioneer(){
		return _auctioneer;
	}
	
	
	public UserB getVoter(){
		return _voter;
	}
	
	
	public void setScore(Integer score){
		_score=score;
	}
	
	
	public void setAuction(AuctionB auction){
		_auction=auction;
		
	}
	
	public void setVoter(UserB voter){
		_voter=voter;
	}
	
	public void setAuctioneer(UserB auctioneer){
		_auctioneer=auctioneer;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		
	}

}
