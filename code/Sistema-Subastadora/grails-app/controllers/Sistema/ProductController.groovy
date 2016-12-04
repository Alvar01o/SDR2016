package Sistema
import com.uni.sd.subastadora.beans.product.ProductB
import com.uni.sd.subastadora.service.product.IProductService
import com.uni.sd.subastadora.service.product.ProductServiceImpl
import com.uni.sd.subastadora.service.user.IUserService
import com.uni.sd.subastadora.service.user.UserServiceImpl
import com.uni.sd.subastadora.util.CategoryEnum


class ProductController {

	//services
	def IProductService productService=new ProductServiceImpl()
	def IUserService userService=new UserServiceImpl()


	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		def products = productService.getAll()
		[productInstanceList: products, productInstanceTotal: products.size()]
	}
	
	
	def create() {
		def productInstance = new ProductB(params)
		def users = userService.getAll()
		[productInstance: productInstance, userInstanceList:users]
	}
	
	
	def save() {
		params.put("roleId", 1)
		def productInstance = new ProductB(params)
		productInstance.setUser(userService.getById(Integer.valueOf(params.userId)))
		def newProduct = productService.save(productInstance)
		
		if (!newProduct?.getId()) {
			render(view: "create", model: [productInstance: productInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'product.label', default: 'Product'),
			newProduct.getId()
		])
		redirect(action: "show", id: newProduct.getId())

	}
	
	def show(Long id) {
		def productInstance = productService.getById(id.intValue())
		if (!productInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'product.label', default: 'Product'),
				id
			])
		}
		[productInstance: productInstance]
	}

	def edit(Long id) {
		def productInstance = productService.getById(id.intValue())
		
		def users = userService.getAll()
		
		
		if (!productInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'product.label', default: 'Product'),
				id
			])
			redirect(action: "list")
			return
		}

		[productInstance: productInstance, userInstanceList:users]
	}

	def update(Long id, Long version) {
		def productInstance = new ProductB(params)
		productInstance.setId(Integer.parseInt(params.get("edit")))
		productInstance.setName(params.get("name"))
		productInstance.setDescription(params.get("description"))
		productInstance.setPrice(Integer.parseInt(params.get("price")))
		productInstance.setShippingInfor(params.get("shippingInfor"))
		productInstance.setCategory(CategoryEnum.valueOf(params.get("category")))
		productInstance.setUser(userService.getById(Integer.valueOf(params.userId)))
		productService.save(productInstance)
		redirect(action: "list")
	}


}

	
