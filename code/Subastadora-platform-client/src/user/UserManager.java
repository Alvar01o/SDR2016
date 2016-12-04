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
	
	public void addUser(String userName, String password, String name, String lastName,  String address, String email, Integer rolId) {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setLastName(lastName);
		userDTO.setUserName(userName);
		userDTO.setPass(password);
		userDTO.setAddress(address);
		userDTO.setEmail(email);
		userDTO.setRolId(rolId);
		
		
		
		getJerseyClient().resource(getBaseUrl() + "/user").entity(userDTO).post(UserDTO.class);
	}
	
	
	public void getAllUsers() {
		UserResult userResult = getJerseyClient().resource(getBaseUrl() + "/user").get(UserResult.class);
		for (UserDTO p : userResult.getUsers()) {
			System.out.println("User Name: "+p.getUserName());
			System.out.println("Password: "+p.getPass());
			System.out.println("Rol: "+p.getRolId());
			System.out.println("Last Name: "+p.getLastName());
			System.out.println("Name: "+p.getName());
			System.out.println("Email: "+p.getEmail());
			System.out.println("Address: "+p.getaddress());
			
			
		}
	}
	
	public void getByIdUser(int id){
		UserDTO userResult = getJerseyClient().resource(getBaseUrl() + "/user/"+id).get(UserDTO.class);
		System.out.println("User Name: "+ userResult.getUserName());
		System.out.println("Password: "+ userResult.getPass());
		System.out.println("Rol: "+ userResult.getRolId());
		System.out.println("Last Name: "+ userResult.getLastName());
		System.out.println("Name: "+ userResult.getName());
		System.out.println("Email: "+ userResult.getEmail());
		System.out.println("Address: "+ userResult.getaddress());
		
	}
	
	public void getByPropertyUser(String textToFind){
		UserResult patResult = getJerseyClient().resource(getBaseUrl() + "/user/search/"+textToFind).get(UserResult.class);
		for (UserDTO c : patResult.getUsers()) {
			System.out.println("User Name: "+c.getUserName());
			System.out.println("Password: "+c.getPass());
			System.out.println("Rol: "+c.getRolId());
			System.out.println("Last Name: "+c.getLastName());
			System.out.println("Name: "+c.getName());
			System.out.println("Email: "+c.getEmail());
			System.out.println("Address: "+c.getaddress());
			
		}
		
	}
	
}
