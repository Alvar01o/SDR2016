package com.uni.sd.subastadora.service.announcement;

import com.uni.sd.subastadora.dao.announcement.AnnouncementDaoImpl;
import com.uni.sd.subastadora.domain.announcement.AnnouncementDomain;
import com.uni.sd.subastadora.dto.announcement.AnnouncementDTO;
import com.uni.sd.subastadora.dto.announcement.AnnouncementResult;
import com.uni.sd.subastadora.service.base.IBaseService;

public interface IAnnouncementService extends IBaseService<AnnouncementDTO, AnnouncementDomain, AnnouncementDaoImpl, AnnouncementResult> {

	public AnnouncementResult find(String textToFind);
}
