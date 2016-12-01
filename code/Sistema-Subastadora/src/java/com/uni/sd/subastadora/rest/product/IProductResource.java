package com.uni.sd.subastadora.rest.product;

import com.uni.sd.subastadora.dto.product.ProductDTO;
import com.uni.sd.subastadora.dto.product.ProductResult;
import com.uni.sd.subastadora.rest.base.IBaseResource;

public interface IProductResource extends IBaseResource<ProductDTO> {

	public ProductResult getAll();
	public ProductResult find(String textToFind, int maxItems, int page);
	public ProductResult find(String textToFind);
}

