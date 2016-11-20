package com.uni.sd.subastadora.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uni.sd.subastadora.dto.location.country.CountryDTO;
import com.uni.sd.subastadora.dto.location.country.CountryResult;
import com.uni.sd.subastadora.service.country.ICountryService;

@Path("/country")
@Component
public class CountryResource {
	@Autowired
	private ICountryService countryService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public CountryDTO getById(@PathParam("id") Integer countryId) {
		return countryService.getById(countryId);
	}

	@GET
	@Produces("application/xml")
	public CountryResult getAll() {
		return countryService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public CountryResult search(@PathParam("textToFind") String textToFind) {
		return countryService.find(textToFind);
	}

	@POST
	public CountryDTO save(CountryDTO country) {
		return countryService.save(country);
	}
}
