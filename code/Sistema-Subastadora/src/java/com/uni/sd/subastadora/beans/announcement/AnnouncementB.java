package com.uni.sd.subastadora.beans.announcement;

import java.util.Map;


import org.apache.commons.lang.StringUtils;

import com.uni.sd.subastadora.beans.base.BaseBean;
import com.uni.sd.subastadora.beans.product.ProductB;
import com.uni.sd.subastadora.beans.user.UserB;

public class AnnouncementB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private UserB _user;
	private ProductB _product;

	public AnnouncementB(Map<String, String> params) {
		super(params);
	}

	
	public UserB getUser() {
		return _user;
	}

	public void setUser(UserB user) {
		_user = user;
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