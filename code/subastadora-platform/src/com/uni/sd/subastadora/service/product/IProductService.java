package com.uni.sd.subastadora.service.product;

import com.uni.sd.subastadora.dao.product.ProductDaoImpl;
import com.uni.sd.subastadora.domain.product.ProductDomain;
import com.uni.sd.subastadora.dto.product.ProductDTO;
import com.uni.sd.subastadora.dto.product.ProductResult;
import com.uni.sd.subastadora.service.base.IBaseService;

public interface IProductService extends IBaseService<ProductDTO, ProductDomain, ProductDaoImpl, ProductResult> {

	public ProductResult find(String textToFind);
}
