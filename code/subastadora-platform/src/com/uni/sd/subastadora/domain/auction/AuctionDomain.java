package com.uni.sd.subastadora.domain.auction;


import java.util.Date;
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
import com.uni.sd.subastadora.domain.bid.BidDomain;
import com.uni.sd.subastadora.domain.creditCard.CreditCardDomain;
import com.uni.sd.subastadora.domain.product.ProductDomain;
import com.uni.sd.subastadora.domain.user.UserDomain;
import com.uni.sd.subastadora.domain.valuation.ValuationDomain;

@Entity
@Table(name = "auction")
public class AuctionDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "auction_time")
	private Date _auction_time;

	@ManyToOne
	private UserDomain _winnerId;
	
	
	@ManyToOne
	private ProductDomain _product;
	
	@OneToMany(mappedBy = "_auction")
	private Set<ValuationDomain> _valuations = new HashSet<>();
	
	
	@OneToMany(mappedBy = "_auction")
	private Set<BidDomain> _bids = new HashSet<>();
	
	
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public Date getTime() {
		return _auction_time;
	}

	public void setTime(Date ti) {
		_auction_time = ti;
	}

	public UserDomain getWinner() {
		return _winnerId;
	}

	public void setWinner(UserDomain userwinner) {
		_winnerId = userwinner;
	}
	
	public ProductDomain getProduct() {
		return _product;
	}

	public void setProduct(ProductDomain product) {
		_product = product;
	}

	public Set<ValuationDomain> getValuations() {
		return _valuations;
	}

	public void setValuations(Set<ValuationDomain> valuations) {
		this._valuations = valuations;
	}
	
	public Set<BidDomain> getBids() {
		return _bids;
	}

	public void setBids(Set<BidDomain> bids) {
		this._bids = bids;
	}
	
}
