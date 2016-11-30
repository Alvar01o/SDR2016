package Sistema
import com.uni.sd.subastadora.beans.role.RoleB
import com.uni.sd.subastadora.service.role.IRoleService
import com.uni.sd.subastadora.service.role.RoleServiceImpl


class RoleController {

	//services
	def IRoleService roleService=new RoleServiceImpl()


	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		def roles = roleService.getAll()
		[roleInstanceList: roles, roleInstanceTotal: roles.size()]
	}
}
