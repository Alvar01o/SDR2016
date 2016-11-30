package com.uni.sd.subastadora.rest.announcement;

import org.springframework.stereotype.Repository;

import com.sun.jersey.api.client.WebResource;
import com.uni.sd.subastadora.dto.announcement.AnnouncementDTO;
import com.uni.sd.subastadora.dto.announcement.AnnouncementResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("announcementResource")
public class AnnouncementResourceImpl extends BaseResourceImpl<AnnouncementDTO> implements IAnnouncementResource {

	public AnnouncementResourceImpl() {
		super(AnnouncementDTO.class, "/announcement");
	}

	@Override
	public AnnouncementResult getAll() {
		final AnnouncementResult result = getWebResource().get(AnnouncementResult.class);
		return result;
	}
	
	@Override
	public AnnouncementResult find(String textToFind) {
		final AnnouncementResult result = findWR(textToFind).get(AnnouncementResult.class);
		return result;
	}

}
