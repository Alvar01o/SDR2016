package com.uni.sd.subastadora.resource;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uni.sd.subastadora.dto.creditcard.CreditCardDTO;
import com.uni.sd.subastadora.dto.creditcard.CreditCardResult;
import com.uni.sd.subastadora.service.creditcard.ICreditCardService;

@Path("/creditcard")
@Component
public class CreditCardResource {
	@Autowired
	private ICreditCardService creditCardService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public CreditCardDTO getById(@PathParam("id") Integer creditCardId){
		return creditCardService.getById(creditCardId);

	}

	@GET
	@Produces("application/xml")
	public CreditCardResult getAll() {
		return creditCardService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public CreditCardResult search(@PathParam("textToFind") String textToFind) {
		return creditCardService.find(textToFind);
	}

	@POST
	public CreditCardDTO save(CreditCardDTO creditCard) {
		
		return creditCardService.save(creditCard);
	}
}
