package com.uni.sd.subastadora.service.announcement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.sd.subastadora.dao.announcement.AnnouncementDaoImpl;
import com.uni.sd.subastadora.dao.announcement.IAnnouncementDao;
import com.uni.sd.subastadora.domain.announcement.AnnouncementDomain;
import com.uni.sd.subastadora.dto.announcement.AnnouncementDTO;
import com.uni.sd.subastadora.dto.announcement.AnnouncementResult;
import com.uni.sd.subastadora.service.base.BaseServiceImpl;

@Service
public class AnnouncementServiceImpl extends BaseServiceImpl<AnnouncementDTO, AnnouncementDomain, AnnouncementDaoImpl, AnnouncementResult>
		implements IAnnouncementService {
	@Autowired
	private IAnnouncementDao announcementDao;

	@Override
	@Transactional
	public AnnouncementDTO save(AnnouncementDTO dto) {
		final AnnouncementDomain domain = convertDtoToDomain(dto);
		final AnnouncementDomain productDomain = announcementDao.save(domain);
		return convertDomainToDto(productDomain);
	}

	@Override
	@Transactional
	public AnnouncementDTO getById(Integer id) {
		final AnnouncementDomain domain = announcementDao.getById(id);
		final AnnouncementDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public AnnouncementResult getAll() {
		final List<AnnouncementDTO> products = new ArrayList<>();
		for (AnnouncementDomain domain : announcementDao.findAll()) {
			final AnnouncementDTO dto = convertDomainToDto(domain);
			products.add(dto);
		}
		final AnnouncementResult productResult = new AnnouncementResult();
		productResult.setAnnouncements(products);
		return productResult;
	}

	@Override
	@Transactional
	public AnnouncementResult find(String textToFind) {
		final List<AnnouncementDTO> products = new ArrayList<>();
		for (AnnouncementDomain domain : announcementDao.find(textToFind)) {
			final AnnouncementDTO dto = convertDomainToDto(domain);
			products.add(dto);
		}
		final AnnouncementResult announcementResult = new AnnouncementResult();
		announcementResult.setAnnouncements(products);
		return announcementResult;
	}

	@Override
	protected AnnouncementDTO convertDomainToDto(AnnouncementDomain domain) {
		final AnnouncementDTO dto = new AnnouncementDTO();
		dto.setId(domain.getId());
		return dto;
	}

	@Override
	protected AnnouncementDomain convertDtoToDomain(AnnouncementDTO dto) {
		final AnnouncementDomain domain = new AnnouncementDomain();
		domain.setId(dto.getId());
		
		return domain;
	}

}
