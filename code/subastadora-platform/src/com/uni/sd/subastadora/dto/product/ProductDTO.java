package com.uni.sd.subastadora.dto.product;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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

	@XmlElement
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
}
