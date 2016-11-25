package com.uni.sd.subastadora.service.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.sd.subastadora.dao.product.ProductDaoImpl;
import com.uni.sd.subastadora.dao.product.IProductDao;
import com.uni.sd.subastadora.dao.user.IUserDao;
import com.uni.sd.subastadora.dao.user.UserDaoImpl;
import com.uni.sd.subastadora.domain.product.ProductDomain;
import com.uni.sd.subastadora.dto.product.ProductDTO;
import com.uni.sd.subastadora.dto.product.ProductResult;
import com.uni.sd.subastadora.service.base.BaseServiceImpl;

@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductDTO, ProductDomain, ProductDaoImpl, ProductResult>
		implements IProductService {
	@Autowired
	private IProductDao productDao= new ProductDaoImpl();
	
	@Autowired
	private IUserDao userDao=new UserDaoImpl();

	@Override
	@Transactional
	public ProductDTO save(ProductDTO dto) {
		final ProductDomain domain = convertDtoToDomain(dto);
		final ProductDomain productDomain = productDao.save(domain);
		return convertDomainToDto(productDomain);
	}

	@Override
	@Transactional
	public ProductDTO getById(Integer id) {
		final ProductDomain domain = productDao.getById(id);
		final ProductDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public ProductResult getAll() {
		final List<ProductDTO> products = new ArrayList<>();
		for (ProductDomain domain : productDao.findAll()) {
			final ProductDTO dto = convertDomainToDto(domain);
			products.add(dto);
		}
		final ProductResult productResult = new ProductResult();
		productResult.setProducts(products);
		return productResult;
	}

	@Override
	@Transactional
	public ProductResult find(String textToFind) {
		final List<ProductDTO> products = new ArrayList<>();
		for (ProductDomain domain : productDao.find(textToFind)) {
			final ProductDTO dto = convertDomainToDto(domain);
			products.add(dto);
		}
		final ProductResult productResult = new ProductResult();
		productResult.setProducts(products);
		return productResult;
	}

	@Override
	protected ProductDTO convertDomainToDto(ProductDomain domain) {
		final ProductDTO dto = new ProductDTO();
		dto.setId(domain.getId());
		dto.setName(domain.getName());
		dto.setDescription(domain.getDescription());
		dto.setPrice(domain.getPrice());
		dto.setShippingInfor(domain.getShippingInfor());
		dto.setUserId(domain.getUser().getId());
		dto.setCategory(domain.getCategory());
		return dto;
	}

	@Override
	protected ProductDomain convertDtoToDomain(ProductDTO dto) {
		final ProductDomain domain = new ProductDomain();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		domain.setDescription(dto.getDescription());
		domain.setPrice(dto.getPrice());
		domain.setShippingInfor(dto.getShippingInfor());
		domain.setCategory(dto.getCategory());
		domain.setUser(userDao.getById(dto.getUserId()));
		
		return domain;
	}

}
