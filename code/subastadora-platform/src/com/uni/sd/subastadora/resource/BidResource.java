package com.uni.sd.subastadora.resource;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uni.sd.subastadora.dto.bid.BidDTO;
import com.uni.sd.subastadora.dto.bid.BidResult;
import com.uni.sd.subastadora.service.bid.IBidService;

@Path("/bid")
@Component
public class BidResource {
	@Autowired
	private IBidService bidService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public BidDTO getById(@PathParam("id") Integer bidId) {
		return bidService.getById(bidId);
	}

	@GET
	@Produces("application/xml")
	public BidResult getAll() {
		return bidService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public BidResult search(@PathParam("textToFind") String textToFind) {
		return bidService.find(textToFind);
	}

	@POST
	public BidDTO save(BidDTO bid) {
		return bidService.save(bid);
	}
}
