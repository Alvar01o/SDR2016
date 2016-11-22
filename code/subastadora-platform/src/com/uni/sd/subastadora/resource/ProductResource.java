package com.uni.sd.subastadora.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uni.sd.subastadora.dto.product.ProductDTO;
import com.uni.sd.subastadora.dto.product.ProductResult;
import com.uni.sd.subastadora.service.product.IProductService;

@Path("/product")
@Component
public class ProductResource {
	@Autowired
	private IProductService productService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public ProductDTO getById(@PathParam("id") Integer productId) {
		return productService.getById(productId);
	}

	@GET
	@Produces("application/xml")
	public ProductResult getAll() {
		return productService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public ProductResult search(@PathParam("textToFind") String textToFind) {
		return productService.find(textToFind);
	}

	@POST
	public ProductDTO save(ProductDTO product) {
		return productService.save(product);
	}
}
