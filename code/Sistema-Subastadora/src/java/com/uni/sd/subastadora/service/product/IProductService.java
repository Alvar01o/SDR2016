package com.uni.sd.subastadora.service.product;

import java.util.List;

import com.uni.sd.subastadora.beans.product.ProductB;
import com.uni.sd.subastadora.dto.product.ProductDTO;
import com.uni.sd.subastadora.services.base.IBaseService;

public interface IProductService extends IBaseService<ProductB, ProductDTO> {
	public List <ProductB> find(String textToFind);
}
