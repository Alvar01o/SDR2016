package com.uni.sd.subastadora.beans.product;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.uni.sd.subastadora.beans.base.BaseBean;
import com.uni.sd.subastadora.beans.user.UserB;

import com.uni.sd.subastadora.util.CategoryEnum;

public class ProductB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _name;
	private String _description;
	private int _price;
	private String _shippingInfor;
	private CategoryEnum _category;
	private UserB _user;
	
	
	public ProductB(Map<String, String> params) {
		super(params);
	}
	
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}
		
	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}
	
	public int getPrice() {
		return _price;
	}

	public void setPrice(int price) {
		_price = price;
	}
	
	public String getShippingInfor() {
		return _shippingInfor;
	}
	
	public void setShippingInfor(String shippingInfor) {
			_shippingInfor = shippingInfor;
	}

	public void setCategory(CategoryEnum category) {
		_category = category;
	}
		public CategoryEnum getCategory() {
		return _category;
	}
		
		
	public UserB getUser() {
		return _user;
	}

	public void setUser(UserB user) {
		_user = user;
	}

	
	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
		setDescription(params.get("description"));
		setShippingInfor(params.get("shippingInfor"));
		if(null != params.get("price")){
             setPrice(Integer.parseInt(params.get("price")));
        }
     
		if (!StringUtils.isBlank(params.get("category"))) {
			setCategory(CategoryEnum.valueOf(params.get("category")));

		}
	}
	

}
