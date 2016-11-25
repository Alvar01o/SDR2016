package com.uni.sd.subastadora.service.valuation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.sd.subastadora.dao.auction.AuctionDaoImp;
import com.uni.sd.subastadora.dao.auction.IAuctionDao;
import com.uni.sd.subastadora.dao.role.IRoleDao;
import com.uni.sd.subastadora.dao.user.IUserDao;
import com.uni.sd.subastadora.dao.valuation.ValuationDaoImpl;
import com.uni.sd.subastadora.dao.valuation.IValuationDao;
import com.uni.sd.subastadora.domain.valuation.ValuationDomain;
import com.uni.sd.subastadora.dto.valuation.ValuationDTO;
import com.uni.sd.subastadora.dto.valuation.ValuationResult;
import com.uni.sd.subastadora.service.base.BaseServiceImpl;

@Service
public class ValuationServiceImpl extends BaseServiceImpl<ValuationDTO, ValuationDomain, ValuationDaoImpl, ValuationResult>
		implements IValuationService {
	@Autowired
	private IValuationDao valuationDao;

	@Autowired
	private IRoleDao roleDao;
	
	@Autowired
	private IUserDao userDao;
	
	
	@Autowired
	private IAuctionDao auctionDao=new AuctionDaoImp();
	
	
	@Override
	@Transactional
	public ValuationDTO save(ValuationDTO dto) {
		final ValuationDomain domain = convertDtoToDomain(dto);
		final ValuationDomain valuationDomain = valuationDao.save(domain);
		return convertDomainToDto(valuationDomain);
	}

	@Override
	@Transactional
	public ValuationDTO getById(Integer id) {
		final ValuationDomain domain = valuationDao.getById(id);
		final ValuationDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public ValuationResult getAll() {
		final List<ValuationDTO> valuations = new ArrayList<>();
		for (ValuationDomain domain : valuationDao.findAll()) {
			final ValuationDTO dto = convertDomainToDto(domain);
			valuations.add(dto);
		}
		final ValuationResult valuationResult = new ValuationResult();
		valuationResult.setValuations(valuations);
		return valuationResult;
	}

	@Override
	@Transactional
	public ValuationResult find(String textToFind) {
		final List<ValuationDTO> valuations = new ArrayList<>();
		for (ValuationDomain domain : valuationDao.find(textToFind)) {
			final ValuationDTO dto = convertDomainToDto(domain);
			valuations.add(dto);
		}
		final ValuationResult valuationResult = new ValuationResult();
		valuationResult.setValuations(valuations);
		return valuationResult;
	}

	@Override
	protected ValuationDTO convertDomainToDto(ValuationDomain domain) {
		final ValuationDTO dto = new ValuationDTO();
		dto.setId(domain.getId());
		dto.setScore(domain.getScore());
		dto.setVoterId(domain.getVoter().getId());
		dto.setAuctioneerId(domain.getAuctioneer().getId());
		dto.setAuctionId(domain.getAuction().getId());
		return dto;
	}

	@Override
	protected ValuationDomain convertDtoToDomain(ValuationDTO dto) {
		final ValuationDomain domain = new ValuationDomain();
		domain.setId(dto.getId());
		domain.setScore(dto.getScore());
		domain.setVoter(userDao.getById(dto.getVoterId()));
		domain.setAuctioneer(userDao.getById(dto.getAuctioneerId()));
		domain.setAuction(auctionDao.getById(dto.getAuctionId()));
		return domain;
	}

}
