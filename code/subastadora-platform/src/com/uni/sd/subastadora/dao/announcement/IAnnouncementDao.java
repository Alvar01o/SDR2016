package com.uni.sd.subastadora.dao.announcement;

import java.util.List;

import com.uni.sd.subastadora.dao.base.IBaseDao;
import com.uni.sd.subastadora.domain.announcement.AnnouncementDomain;

public interface IAnnouncementDao extends IBaseDao<AnnouncementDomain> {

	public List<AnnouncementDomain>find(String textToFind);
}
