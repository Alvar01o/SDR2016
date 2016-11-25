package com.uni.sd.subastadora.service.bid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uni.sd.subastadora.dao.auction.AuctionDaoImp;
import com.uni.sd.subastadora.dao.auction.IAuctionDao;
import com.uni.sd.subastadora.dao.user.*;
import com.uni.sd.subastadora.domain.auction.AuctionDomain;
import com.uni.sd.subastadora.dto.auction.AuctionDTO;

import com.uni.sd.subastadora.dto.auction.AuctionResult;
import com.uni.sd.subastadora.service.base.BaseServiceImpl;

@Service
public class BidServiceImpl extends BaseServiceImpl<AuctionDTO, AuctionDomain, AuctionDaoImp, AuctionResult>
		implements IBidService {
	@Autowired
	private IAuctionDao auctionDao;

	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional
	public AuctionDTO save(AuctionDTO dto) {
		final AuctionDomain domain = convertDtoToDomain(dto);
		final AuctionDomain auctionDomain = auctionDao.save(domain);
		return convertDomainToDto(auctionDomain);
	}

	@Override
	@Transactional
	public AuctionDTO getById(Integer id) {
		final AuctionDomain domain = auctionDao.getById(id);
		final AuctionDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public AuctionResult getAll() {
		final List<AuctionDTO> countries = new ArrayList<>();
		for (AuctionDomain domain : auctionDao.findAll()) {
			final AuctionDTO dto = convertDomainToDto(domain);
			countries.add(dto);
		}
		final AuctionResult auctionResult = new AuctionResult();
		auctionResult.setAuctions(countries);
		return auctionResult;
	}

	@Override
	@Transactional
	public AuctionResult find(String textToFind) {
		final List<AuctionDTO> countries = new ArrayList<>();
		for (AuctionDomain domain : auctionDao.find(textToFind)) {
			final AuctionDTO dto = convertDomainToDto(domain);
			countries.add(dto);
		}
		final AuctionResult auctionResult = new AuctionResult();
		auctionResult.setAuctions(countries);
		return auctionResult;
	}

	@Override
	protected AuctionDTO convertDomainToDto(AuctionDomain domain) {
		final AuctionDTO dto = new AuctionDTO();
		dto.setId(domain.getId());
		dto.setTime(domain.getTime());
		dto.setWinnerId(domain.getWinner().getId());
		return dto;
	}

	@Override
	protected AuctionDomain convertDtoToDomain(AuctionDTO dto) {
		final AuctionDomain domain = new AuctionDomain();
		domain.setId(dto.getId());
		domain.setTime(dto.getTime());
		try {
			if (null != dto.getWinnerId()) domain.setWinner(userDao.getById(dto.getWinnerId()) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return domain;
	}

}
