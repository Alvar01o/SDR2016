package com.uni.sd.subastadora.domain.valuation;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.uni.sd.subastadora.domain.base.BaseDomain;
import com.uni.sd.subastadora.domain.role.RoleDomain;
import com.uni.sd.subastadora.domain.user.UserDomain;

@Entity
@Table(name = "valuation")
public class ValuationDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "score")
	private Integer _score;

	/*@ManyToOne
	private AuctionDomain _auction;*/
	
	@ManyToOne 
	private UserDomain _auctioneer;
	
	@ManyToOne
	private UserDomain _voter;
	
	public Integer getId(){
		return _id;
	}
	
	
	public Integer getScore(){
		return _score;
	}
	/*
	public ActionDomain getAuction(){
		return _auction;
	}
	*/
	
	public UserDomain getAuctioneer(){
		return _auctioneer;
	}
	
	
	public UserDomain getVoter(){
		return _voter;
	}
	
	
	public void setId(Integer id){
		_id=id;
		
	}
	
	public void setScore(Integer score){
		_score=score;
	}
	
	/*
	public void setAuction(AuctionDomain auction){
		_auction=auction;
		
	}*/
	
	public void setVoter(UserDomain voter){
		_voter=voter;
	}
	
	public void setAuctioneer(UserDomain auctioneer){
		_auctioneer=auctioneer;
	}
}