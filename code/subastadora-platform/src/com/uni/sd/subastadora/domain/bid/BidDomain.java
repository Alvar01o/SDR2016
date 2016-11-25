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
import com.uni.sd.subastadora.domain.product.ProductDomain;
import com.uni.sd.subastadora.domain.user.UserDomain;

@Entity
@Table(name = "auction")
public class BidDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "auction_time")
	private Time _auction_time;

	@ManyToOne
	private UserDomain _winnerId;
	
	
	@ManyToOne
	private ProductDomain _product;
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public Time getTime() {
		return _auction_time;
	}

	public void setTime(Time ti) {
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

}
