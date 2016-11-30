package com.uni.sd.subastadora.service.product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.sd.subastadora.beans.product.ProductB;
import com.uni.sd.subastadora.dto.product.ProductDTO;
import com.uni.sd.subastadora.dto.product.ProductResult;
import com.uni.sd.subastadora.rest.product.IProductResource;
import com.uni.sd.subastadora.rest.product.ProductResourceImpl;
import com.uni.sd.subastadora.services.base.BaseServiceImpl;
import com.uni.sd.subastadora.service.user.IUserService;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<ProductB, ProductDTO>
		implements IProductService {
	@Autowired
	private IUserService userService;
	@Autowired
	private IProductResource _productResource=new ProductResourceImpl();
	
	
	public ProductServiceImpl() {
	}

	@Override
	public ProductB save(ProductB bean) {
		final ProductDTO dto = convertBeanToDto(bean);
		final ProductDTO productDTO = _productResource.save(dto);
		return convertDtoToBean(productDTO);
	}

	@Override
	public List<ProductB> getAll() {
		final ProductResult result = _productResource.getAll();
		final List<ProductDTO> cList = null == result.getProducts() ? new ArrayList<ProductDTO>()
				: result.getProducts();
		final List<ProductB> bids = new ArrayList<ProductB>();

		for (ProductDTO dto : cList) {
			final ProductB bidB = convertDtoToBean(dto);
			bids.add(bidB);
		}
		return bids;
	}

	@Override
	public ProductB getById(Integer id) {
		final ProductDTO dto = _productResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected ProductB convertDtoToBean(ProductDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name",dto.getName());
		params.put("description", dto.getDescription());
		params.put("price",String.valueOf(dto.getPrice())) ;
		params.put("shippingInfor", dto.getShippingInfor());
		
		final ProductB productB = new ProductB(params);
		productB.setCategory(dto.getCategory());
		//productB.setUser(userService.getById(dto.getUserId()));
		
		return productB;
	}

	@Override
	protected ProductDTO convertBeanToDto(ProductB bean) {
		final ProductDTO dto = new ProductDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setDescription(bean.getDescription());
		dto.setPrice(bean.getPrice());
		dto.setShippingInfor(bean.getShippingInfor());
		dto.setCategory(bean.getCategory());
		dto.setUserId(bean.getUser().getId());

		return dto;
	}
	
	@Override						
	public List<ProductB> find(String textToFind) {		//int maxItems, int page
		final ProductResult result = _productResource.find(textToFind);
		final List<ProductDTO> rList = null == result.getProducts() ? new ArrayList<ProductDTO>()
				: result.getProducts();

		final List<ProductB> bids = new ArrayList<ProductB>();
		for (ProductDTO dto : rList) {
			final ProductB bean = convertDtoToBean(dto);
			bids.add(bean);
		}
		return bids;
	}

}
