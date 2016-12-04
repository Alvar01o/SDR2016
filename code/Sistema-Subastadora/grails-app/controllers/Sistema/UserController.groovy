package Sistema
import com.uni.sd.subastadora.beans.role.RoleB
import com.uni.sd.subastadora.beans.user.UserB
import com.uni.sd.subastadora.service.user.IUserService
import com.uni.sd.subastadora.service.user.UserServiceImpl
import com.uni.sd.subastadora.service.role.IRoleService
import com.uni.sd.subastadora.service.role.RoleServiceImpl
import com.uni.sd.subastadora.service.user.IUserService
import com.uni.sd.subastadora.service.user.UserServiceImpl


class UserController {

	//services
	
	def IUserService userService=new UserServiceImpl()
	def IRoleService roleService=new RoleServiceImpl()


	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		def users = userService.getAll()
		[userInstanceList: users, userInstanceTotal: users.size()]
	}
	
	
	def userProfile(Long id) {
		def userInstance = userService.getById(id.intValue())
		def roles = roleService.getAll()
		
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "list")
			return
		}

		[ userInstance: userInstance, roleInstanceList:roles,]
	}
	
	
	
	def save() {
		params.put("roleId", 1)
		def userInstance = new UserB(params)
		userInstance.setRole(roleService.getById(Integer.valueOf(params.roleId)))
		def newUser = userService.save(userInstance)
		
		if (!newUser?.getId()) {
			render(view: "create", model: [userInstance: userInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'user.label', default: 'User'),
			newUser.getId()
		])
		redirect(action: "show", id: newUser.getId())
	}
	
	def show(Long id) {
		def userInstance = userService.getById(id.intValue())
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
		}
		[userInstance: userInstance]
	}

	def edit(Long id) {
		def userInstance = userService.getById(id.intValue())
		def roles = roleService.getAll()
		
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "list")
			return
		}

		[ userInstance: userInstance, roleInstanceList:roles,]
	}

	def update(Long id, Long version) {
		def userInstance = new UserB(params)
		userInstance.setId(Integer.parseInt(params.get("edit")))
		userInstance.setUserName(params.get("userName"))
		userInstance.setLastName(params.get("lastName"))
		userInstance.setName(params.get("name"))
		userInstance.setPassword(params.get("password"))
		userInstance.setEmail(params.get("email"))
		userInstance.setAddress(params.get("address"))
		userInstance.setRole(roleService.getById(Integer.valueOf(params.roleId)))
		userService.save(userInstance)
		redirect(action: "list")
	}

	def update2(Long id, Long version) {
		def user = userService.getById(Integer.parseInt(params.get("edit")))
		def userInstance = new UserB(params)
		userInstance.setId(Integer.parseInt(params.get("edit")))
		userInstance.setUserName(params.get("userName"))
		userInstance.setLastName(params.get("lastName"))
		userInstance.setName(params.get("name"))
		userInstance.setPassword(user.getPassword())
		userInstance.setEmail(params.get("email"))
		userInstance.setAddress(params.get("address"))
		userInstance.setRole(roleService.getById(user.getRole().getId()))
		userService.save(userInstance)
		redirect(action: "list")
		
	}
	
}

	

