package com.uni.sd.subastadora.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uni.sd.subastadora.dto.announcement.AnnouncementDTO;
import com.uni.sd.subastadora.dto.announcement.AnnouncementResult;
import com.uni.sd.subastadora.service.announcement.IAnnouncementService;

@Path("/announcement")
@Component
public class AnnouncementResource {
	@Autowired
	private IAnnouncementService announcementService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public AnnouncementDTO getById(@PathParam("id") Integer announcementId) {
		return announcementService.getById(announcementId);
	}

	@GET
	@Produces("application/xml")
	public AnnouncementResult getAll() {
		return announcementService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public AnnouncementResult search(@PathParam("textToFind") String textToFind) {
		return announcementService.find(textToFind);
	}

	@POST
	public AnnouncementDTO save(AnnouncementDTO announcement) {
		return announcementService.save(announcement);
	}
}
