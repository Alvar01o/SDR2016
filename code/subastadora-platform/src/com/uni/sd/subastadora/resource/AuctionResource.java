package com.uni.sd.subastadora.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uni.sd.subastadora.dto.auction.AuctionDTO;
import com.uni.sd.subastadora.dto.auction.AuctionResult;
import com.uni.sd.subastadora.service.auction.IAuctionService;

@Path("/auction")
@Component
public class AuctionResource {
	@Autowired
	private IAuctionService auctionService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public AuctionDTO getById(@PathParam("id") Integer auctionId) {
		return auctionService.getById(auctionId);
	}

	@GET
	@Produces("application/xml")
	public AuctionResult getAll() {
		return auctionService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public AuctionResult search(@PathParam("textToFind") String textToFind) {
		return auctionService.find(textToFind);
	}

	@POST
	public AuctionDTO save(AuctionDTO auction) {
		return auctionService.save(auction);
	}
}
