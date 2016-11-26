package com.uni.sd.subastadora.resource;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uni.sd.subastadora.dto.typeBid.TypeBidDTO;
import com.uni.sd.subastadora.dto.typeBid.TypeBidResult;
import com.uni.sd.subastadora.service.typeBid.ITypeBidService;
import com.uni.sd.subastadora.service.typeBid.TypeBidServiceImpl;

@Path("/typeBid")
@Component
public class TypeBidResource {
	@Autowired
	private ITypeBidService typeBidService=new TypeBidServiceImpl();

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public TypeBidDTO getById(@PathParam("id") Integer typeBidId) {
		return typeBidService.getById(typeBidId);
	}

	@GET
	@Produces("application/xml")
	public TypeBidResult getAll() {
		return typeBidService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public TypeBidResult search(@PathParam("textToFind") String textToFind) {
		return typeBidService.find(textToFind);
	}

	@POST
	public TypeBidDTO save(TypeBidDTO typeBid) {
		return typeBidService.save(typeBid);
	}
}
