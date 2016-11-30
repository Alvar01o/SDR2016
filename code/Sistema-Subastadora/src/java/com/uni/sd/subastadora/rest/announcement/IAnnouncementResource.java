package com.uni.sd.subastadora.rest.announcement;

import com.uni.sd.subastadora.dto.announcement.AnnouncementDTO;
import com.uni.sd.subastadora.dto.announcement.AnnouncementResult;
import com.uni.sd.subastadora.rest.base.IBaseResource;

public interface IAnnouncementResource extends IBaseResource<AnnouncementDTO> {

	public AnnouncementResult getAll();
	public AnnouncementResult find(String textToFind);

}
