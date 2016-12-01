package com.uni.sd.subastadora.service.announcement;

import java.util.List;

import com.uni.sd.subastadora.beans.announcement.AnnouncementB;
import com.uni.sd.subastadora.dto.announcement.AnnouncementDTO;
import com.uni.sd.subastadora.services.base.IBaseService;

public interface IAnnouncementService extends IBaseService <AnnouncementB, AnnouncementDTO> {
	public List <AnnouncementB> find(String textToFind);
}
