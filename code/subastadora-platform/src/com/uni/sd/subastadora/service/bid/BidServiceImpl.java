package com.uni.sd.subastadora.service.bid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.sd.subastadora.dao.auction.IAuctionDao;
import com.uni.sd.subastadora.dao.bid.BidDaoImpl;
import com.uni.sd.subastadora.dao.bid.IBidDao;
import com.uni.sd.subastadora.dao.typeBid.ITypeBidDao;
import com.uni.sd.subastadora.dao.user.*;
import com.uni.sd.subastadora.domain.bid.BidDomain;
import com.uni.sd.subastadora.dto.bid.BidDTO;
import com.uni.sd.subastadora.dto.bid.BidResult;
import com.uni.sd.subastadora.service.base.BaseServiceImpl;

@Service
public class BidServiceImpl extends BaseServiceImpl<BidDTO, BidDomain, BidDaoImpl, BidResult>
		implements IBidService {
	@Autowired
	private IBidDao bidDao;

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IAuctionDao auctionDao;
	
	@Autowired
	private ITypeBidDao typeBidDao;

	@Override
	@Transactional
	public BidDTO save(BidDTO dto) {
		final BidDomain domain = convertDtoToDomain(dto);
		final BidDomain bidDomain = bidDao.save(domain);
		return convertDomainToDto(bidDomain);
	}

	@Override
	@Transactional
	public BidDTO getById(Integer id) {
		final BidDomain domain = bidDao.getById(id);
		final BidDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public BidResult getAll() {
		final List<BidDTO> bids = new ArrayList<>();
		for (BidDomain domain : bidDao.findAll()) {
			final BidDTO dto = convertDomainToDto(domain);
			bids.add(dto);
		}
		final BidResult bidResult = new BidResult();
		bidResult.setBids(bids);
		return bidResult;
	}

	@Override
	@Transactional
	public BidResult find(String textToFind) {
		final List<BidDTO> bids = new ArrayList<>();
		for (BidDomain domain : bidDao.find(textToFind)) {
			final BidDTO dto = convertDomainToDto(domain);
			bids.add(dto);
		}
		final BidResult bidResult = new BidResult();
		bidResult.setBids(bids);
		return bidResult;
	}

	@Override
	protected BidDTO convertDomainToDto(BidDomain domain) {
		final BidDTO dto = new BidDTO();
		dto.setId(domain.getId());
		dto.setAmount(domain.getAmount());;
		dto.setUserId(domain.getUser().getId());
		dto.setAuctionId(domain.getAuction().getId());
		dto.setTypeBidId(domain.getTypeBid().getId());
		return dto;
	}

	@Override
	protected BidDomain convertDtoToDomain(BidDTO dto) {
		final BidDomain domain = new BidDomain();
		domain.setId(dto.getId());
		domain.setAmount(dto.getAmount());;
		domain.setUser(userDao.getById(dto.getUserId()));
		domain.setAuction(auctionDao.getById(dto.getAuctionId()));
		domain.setTypeBid(typeBidDao.getById(dto.getTypeBidId()));
		return domain;
	}

}
