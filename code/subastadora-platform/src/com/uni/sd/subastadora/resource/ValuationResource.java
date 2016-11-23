package com.uni.sd.subastadora.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uni.sd.subastadora.dto.valuation.ValuationDTO;
import com.uni.sd.subastadora.dto.valuation.ValuationResult;
import com.uni.sd.subastadora.service.valuation.IValuationService;

@Path("/valuation")
@Component
public class ValuationResource {
	@Autowired
	private IValuationService valuationService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public ValuationDTO getById(@PathParam("id") Integer valuationId) {
		return valuationService.getById(valuationId);
	}

	@GET
	@Produces("application/xml")
	public ValuationResult getAll() {
		return valuationService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public ValuationResult search(@PathParam("textToFind") String textToFind) {
		return valuationService.find(textToFind);
	}

	@POST
	public ValuationDTO save(ValuationDTO valuation) {
		return valuationService.save(valuation);
	}
}
