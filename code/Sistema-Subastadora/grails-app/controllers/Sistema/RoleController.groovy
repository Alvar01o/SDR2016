package Sistema
import com.uni.sd.subastadora.beans.role.RoleB
import com.uni.sd.subastadora.service.role.IRoleService
import com.uni.sd.subastadora.service.role.RoleServiceImpl
import com.uni.sd.subastadora.service.user.IUserService
import com.uni.sd.subastadora.service.user.UserServiceImpl


class RoleController {

	//services
	def IRoleService roleService=new RoleServiceImpl()
	def IUserService userService=new UserServiceImpl()


	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		def roles = roleService.getAll()
		[roleInstanceList: roles, roleInstanceTotal: roles.size()]
	}
	
	
	def create() {
		def roleInstance = new RoleB(params)
		[roleInstance: roleInstance]
	}
	
	
	def save() {
		def roleInstance = new RoleB(params)
		def newRole = roleService.save(roleInstance)
		if (!newRole?.getId()) {
			render(view: "create", model: [roleInstance: roleInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'role.label', default: 'Role'),
			newRole.getId()
		])
		redirect(action: "show", id: newRole.getId())
	}
	
	def show(Long id) {
		def roleInstance = roleService.getById(id.intValue())
		if (!roleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'role.label', default: 'Role'),
				id
			])
		}
		[roleInstance: roleInstance]
	}

	def edit(Long id) {
		def roleInstance = roleService.getById(id.intValue())
		if (!roleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'role.label', default: 'Role'),
				id
			])
			redirect(action: "list")
			return
		}

		[roleInstance: roleInstance]
	}

	def update(Long id, Long version) {
		def roleInstance = roleService.getById(id.intValue())
		if (!roleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'role.label', default: 'Role'),
				id
			])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (roleInstance.version > version) {
				roleInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'role.label', default: 'Role')] as Object[],
						"Another user has updated this Client while you were editing")
				render(view: "edit", model: [roleInstance: roleInstance])
				return
			}
		}

		roleInstance.properties = params

		if (!roleInstance.save(flush: true)) {
			render(view: "edit", model: [roleInstance: roleInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'role.label', default: 'Role'),
			roleInstance.id
		])
		redirect(action: "show", id: roleInstance.id)
	}

}

	

