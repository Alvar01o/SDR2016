package com.uni.sd.subastadora.dto.valuation;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseDTO;

@XmlRootElement(name = "valuation")
public class ValuationDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	@Column(name = "score")
	

	private Integer _score;
	private Integer _auctioneerId;
	private Integer _voterId;
	private Integer _auctionId;
	
	
	@XmlElement
	public Integer getScore(){
		return _score;
	}
	
	@XmlElement
	public Integer getAuctionId(){
		return _auctionId;
	}
	
	@XmlElement
	public Integer getAuctioneerId(){
		return _auctioneerId;
	}
	
	@XmlElement
	public Integer getVoterId(){
		return _voterId;
	}
	

	
	public void setScore(Integer score){
		_score=score;
	}
	
	
	public void setAuctionId(Integer auctionId){
		_auctionId=auctionId;
		
	}
	
	public void setVoterId(Integer voterId){
		_voterId=voterId;
	}
	
	public void setAuctioneerId(Integer auctioneerId){
		_auctioneerId=auctioneerId;
	}

}