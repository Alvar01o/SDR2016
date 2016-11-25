package product;


import base.AbstractBaseManager;

import com.uni.sd.subastadora.dto.product.ProductDTO;
import com.uni.sd.subastadora.dto.product.ProductResult;
import com.uni.sd.subastadora.dto.role.RoleDTO;
import com.uni.sd.subastadora.dto.role.RoleResult;
import com.uni.sd.subastadora.util.CategoryEnum;

public class ProductManager extends AbstractBaseManager {
	public ProductManager() {
		
		super();
	
		
	}
	
	
	public void addProduct(String name,  String description, String category, Integer price, String shippingInfo, Integer userId) {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName(name);
		productDTO.setCategory(CategoryEnum.LIBROS);
		productDTO.setDescription(description);
		productDTO.setPrice(price);
		productDTO.setShippingInfor(shippingInfo);
		productDTO.setUserId(userId);
		
		
		getJerseyClient().resource(getBaseUrl() + "/product").entity(productDTO).post(ProductDTO.class);
	}
	
	
	public void getAllProducts() {
		ProductResult productResult = getJerseyClient().resource(getBaseUrl() + "/product").get(ProductResult.class);
		for (ProductDTO p : productResult.getProducts()) {
			System.out.println("Name: "+p.getName());
			System.out.println("Description: "+p.getDescription());
			//System.out.println("Category: "+p.getCategory());
			System.out.println("Price: "+ p.getPrice());
			System.out.println("Shipping Info: "+p.getShippingInfor());
			System.out.println("User: "+p.getUserId());
			
			
		}
	}
	
	public void getByIdProduct(int id){
		ProductDTO productResult = getJerseyClient().resource(getBaseUrl() + "/product/"+id).get(ProductDTO.class);
		System.out.println("Name: "+ productResult.getName());
		System.out.println("Description: "+ productResult.getDescription());
		System.out.println("Category: "+ productResult.getCategory());
		System.out.println("Price: "+ productResult.getPrice());
		System.out.println("Shipping Info: "+ productResult.getShippingInfor());
		System.out.println("User: "+ productResult.getUserId());
		
	}
	
	public void getByPropertyProduct(String textToFind){
		ProductResult patResult = getJerseyClient().resource(getBaseUrl() + "/product/search/"+textToFind).get(ProductResult.class);
		for (ProductDTO c : patResult.getProducts()) {
			System.out.println("Name: "+ c.getName());
			System.out.println("Description: "+ c.getDescription());
			System.out.println("Category: "+ c.getCategory());
			System.out.println("Price: "+ c.getPrice());
			System.out.println("Shipping Info: "+ c.getShippingInfor());
			System.out.println("User: "+ c.getUserId());
			
		}
		
	}
	
}
