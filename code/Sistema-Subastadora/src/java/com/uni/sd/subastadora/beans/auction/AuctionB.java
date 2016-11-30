package com.uni.sd.subastadora.beans.auction;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang.StringUtils;

import com.uni.sd.subastadora.beans.base.BaseBean;
import com.uni.sd.subastadora.beans.product.ProductB;
import com.uni.sd.subastadora.beans.user.UserB;
import com.uni.sd.subastadora.domain.bid.BidDomain;
import com.uni.sd.subastadora.domain.product.ProductDomain;
import com.uni.sd.subastadora.domain.user.UserDomain;
import com.uni.sd.subastadora.domain.valuation.ValuationDomain;

public class AuctionB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private Date _auction_time;
	private UserB _winnerId;
	private ProductB _product;

	public AuctionB(Map<String, String> params) {
		super(params);
	}

	
	public Date getTime() {
		return _auction_time;
	}

	public void setTime(Date ti) {
		_auction_time = ti;
	}

	public UserB getWinner() {
		return _winnerId;
	}

	public void setWinner(UserB userwinner) {
		_winnerId = userwinner;
	}
	
	public ProductB getProduct() {
		return _product;
	}

	public void setProduct(ProductB product) {
		_product = product;
	}


	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		
	}

}