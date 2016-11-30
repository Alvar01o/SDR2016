package com.uni.sd.subastadora.rest.product;

import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.product.ProductDTO;
import com.uni.sd.subastadora.dto.product.ProductResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("productResource")
public class ProductResourceImpl extends BaseResourceImpl<ProductDTO> implements IProductResource {

	public ProductResourceImpl() {
		super(ProductDTO.class, "/product");
	}

	@Override
	public ProductResult getAll() {
		final ProductResult result = getWebResource().get(ProductResult.class);
		return result;
	}
	
	@Override
	public ProductResult find(String textToFind) {
		final ProductResult result = findWR(textToFind).get(ProductResult.class);
		return result;
	}

}
