package com.uni.sd.subastadora.dto.product;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.domain.user.UserDomain;
import com.uni.sd.subastadora.dto.base.BaseDTO;
import com.uni.sd.subastadora.util.CategoryEnum;

@XmlRootElement(name = "product")
public class ProductDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _name;
	private String _description;
	private int _price;
	private String _shippingInfor;
	private CategoryEnum _category;
	private Integer _userId;

	@XmlElement
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}
	
	@XmlElement
	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}
	
	@XmlElement
	public int getPrice() {
		return _price;
	}

	public void setPrice(int price) {
		_price = price;
	}
	
	@XmlElement
	public String getShippingInfor() {
		return _shippingInfor;
	}
	
	public void setShippingInfor(String shippingInfor) {
			_shippingInfor = shippingInfor;
	}

	public void setCategory(CategoryEnum category) {
		_category = category;
	}
	
	@XmlElement
	public CategoryEnum getCategory() {
		return _category;
	}
		
	public void setUserId(Integer userId) {
		_userId = userId;
	}
		
	@XmlElement
	public Integer getUserId() {
		
		return _userId;
	}
}
