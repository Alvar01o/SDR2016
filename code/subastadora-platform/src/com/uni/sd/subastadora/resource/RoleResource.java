package com.uni.sd.subastadora.resource;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uni.sd.subastadora.dto.role.RoleDTO;
import com.uni.sd.subastadora.dto.role.RoleResult;
import com.uni.sd.subastadora.service.role.IRoleService;
import com.uni.sd.subastadora.service.role.RoleServiceImpl;

@Path("/role")
@Component
public class RoleResource {
	@Autowired
	private IRoleService roleService=new RoleServiceImpl();

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public RoleDTO getById(@PathParam("id") Integer roleId) {
		return roleService.getById(roleId);
	}

	@GET
	@Produces("application/xml")
	public RoleResult getAll() {
		return roleService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public RoleResult search(@PathParam("textToFind") String textToFind) {
		return roleService.find(textToFind);
	}

	@POST
	public RoleDTO save(RoleDTO role) {
		return roleService.save(role);
	}
}
