package com.uni.sd.subastadora.dto.product;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseResult;

@XmlRootElement(name = "productResult")
public class ProductResult extends BaseResult<ProductDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<ProductDTO> getProducts() {
		return getList();
	}

	public void setProducts(List<ProductDTO> dtos) {
		super.setList(dtos);
	}
}
