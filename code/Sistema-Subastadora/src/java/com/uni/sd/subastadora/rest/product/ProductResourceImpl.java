package com.uni.sd.subastadora.rest.product;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.auction.AuctionDTO;
import com.uni.sd.subastadora.dto.product.ProductDTO;
import com.uni.sd.subastadora.dto.product.ProductResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("productResource")
public class ProductResourceImpl extends BaseResourceImpl<ProductDTO> implements
		IProductResource {

	public ProductResourceImpl() {
		super(ProductDTO.class, "/product");
	}

	@Override
	@CacheEvict(value = CACHE_REGION, key = "'products'")
	@CachePut(value = CACHE_REGION, key = "'product_' + #product.id", condition = "#product.id!=null")
	public ProductDTO save(ProductDTO product) {
		/*ProductDTO newDto = super.save(product);
		if (null == product.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"product_" + newDto.getId(), newDto);
		}
		return newDto;*/
		final ProductDTO newProduct = getWebResource().entity(product).post(
				getDtoClass());
		return newProduct;
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'product_' + #id")
	public ProductDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'products'")
	public ProductResult getAll() {
		
		final ProductResult result = getWebResource().get(ProductResult.class);
		return result;
	}

	@Override
	public ProductResult find(String textToFind, int maxItems, int page) {
		
		final ProductResult result = findWR(textToFind, maxItems, page).get(
				ProductResult.class);
		return result;
	}
	

	public ProductResult find(String textToFind) {
		
		final ProductResult result = getWebResource().path("/search/" + textToFind).get(ProductResult.class);
		return result;
	}

}
