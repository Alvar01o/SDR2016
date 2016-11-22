package com.uni.sd.subastadora.dao.product;

import java.util.List;

import com.uni.sd.subastadora.dao.base.IBaseDao;
import com.uni.sd.subastadora.domain.product.ProductDomain;

public interface IProductDao extends IBaseDao<ProductDomain> {

	public List<ProductDomain>find(String textToFind);
}
