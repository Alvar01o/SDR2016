package com.uni.sd.subastadora.service.auction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.sd.subastadora.dao.auction.AuctionDaoImp;
import com.uni.sd.subastadora.dao.auction.IAuctionDao;
import com.uni.sd.subastadora.dao.product.IProductDao;
import com.uni.sd.subastadora.dao.user.*;
import com.uni.sd.subastadora.domain.auction.AuctionDomain;
import com.uni.sd.subastadora.dto.auction.AuctionDTO;
import com.uni.sd.subastadora.dto.auction.AuctionResult;
import com.uni.sd.subastadora.service.base.BaseServiceImpl;

@Service
public class AuctionServiceImpl extends BaseServiceImpl<AuctionDTO, AuctionDomain, AuctionDaoImp, AuctionResult>
		implements IAuctionService {
	@Autowired
	private IAuctionDao auctionDao;

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IProductDao productDao;

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
		final List<AuctionDTO> auctions = new ArrayList<>();
		for (AuctionDomain domain : auctionDao.findAll()) {
			final AuctionDTO dto = convertDomainToDto(domain);
			auctions.add(dto);
		}
		final AuctionResult auctionResult = new AuctionResult();
		auctionResult.setAuctions(auctions);
		return auctionResult;
	}

	@Override
	@Transactional
	public AuctionResult find(String textToFind) {
		final List<AuctionDTO> auctions = new ArrayList<>();
		for (AuctionDomain domain : auctionDao.find(textToFind)) {
			final AuctionDTO dto = convertDomainToDto(domain);
			auctions.add(dto);
		}
		final AuctionResult auctionResult = new AuctionResult();
		auctionResult.setAuctions(auctions);
		return auctionResult;
	}

	@Override
	protected AuctionDTO convertDomainToDto(AuctionDomain domain) {
		final AuctionDTO dto = new AuctionDTO();
		dto.setId(domain.getId());
		dto.setTime(domain.getTime());
		dto.setWinnerId(domain.getWinner().getId());
		dto.setProductId(domain.getProduct().getId());
		return dto;
	}

	@Override
	protected AuctionDomain convertDtoToDomain(AuctionDTO dto) {
		final AuctionDomain domain = new AuctionDomain();
		domain.setId(dto.getId());
		domain.setTime(dto.getTime());
		domain.setProduct(productDao.getById(dto.getProductId()));
		try {
			if (null != dto.getWinnerId()) domain.setWinner(userDao.getById(dto.getWinnerId()) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return domain;
	}

}
