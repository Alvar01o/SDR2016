package com.uni.sd.subastadora.dto.announcement;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uni.sd.subastadora.dto.base.BaseResult;

@XmlRootElement(name = "announcementResult")
public class AnnouncementResult extends BaseResult<AnnouncementDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<AnnouncementDTO> getAnnouncements() {
		return getList();
	}

	public void setAnnouncements(List<AnnouncementDTO> dtos) {
		super.setList(dtos);
	}
}
