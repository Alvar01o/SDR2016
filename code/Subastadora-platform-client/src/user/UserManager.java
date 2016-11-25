package user;


import base.AbstractBaseManager;
import com.uni.sd.subastadora.dto.user.UserDTO;
import com.uni.sd.subastadora.dto.user.UserResult;
import com.uni.sd.subastadora.dto.role.RoleDTO;
import com.uni.sd.subastadora.dto.role.RoleResult;

public class UserManager extends AbstractBaseManager {
	public UserManager() {
		
		super();
		addRols();
		
	}
	
	public void addRols(){
		
		RoleDTO rolDTO1 = new RoleDTO();
		rolDTO1.setName("Administrador");
		
		RoleDTO rolDTO2 = new RoleDTO();
		rolDTO2.setName("Subastador");
		
		RoleDTO rolDTO3 = new RoleDTO();
		rolDTO3.setName("Cliente");
		
		getJerseyClient().resource(getBaseUrl() + "/role").entity(rolDTO1).post(RoleDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/role").entity(rolDTO2).post(RoleDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/role").entity(rolDTO3).post(RoleDTO.class);
		
	}
	
	public void addUser(String name, String password, Integer rolId, boolean doctor, String matricula) {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setPass(password);
		userDTO.setRolId(rolId);
		
		
		
		getJerseyClient().resource(getBaseUrl() + "/user").entity(userDTO).post(UserDTO.class);
	}
	
	
	public void getAllUsers() {
		UserResult userResult = getJerseyClient().resource(getBaseUrl() + "/user").get(UserResult.class);
		for (UserDTO p : userResult.getUsers()) {
			System.out.println("Name: "+p.getName());
			System.out.println("Password: "+p.getPass());
			System.out.println("Rol: "+p.getRolId());
			
			
		}
	}
	
	public void getByIdUser(int id){
		UserDTO userResult = getJerseyClient().resource(getBaseUrl() + "/user/"+id).get(UserDTO.class);
		System.out.println("Name: "+ userResult.getName());
		System.out.println("Password: "+ userResult.getPass());
		System.out.println("Rol: "+ userResult.getRolId());
		
	}
	
	public void getByPropertyUser(String textToFind){
		UserResult patResult = getJerseyClient().resource(getBaseUrl() + "/user/search/"+textToFind).get(UserResult.class);
		for (UserDTO c : patResult.getUsers()) {
			System.out.println("Name: "+c.getName());
			System.out.println("Password: "+c.getPass());
			System.out.println("Rol: "+c.getRolId());
			
		}
		
	}
	
}
