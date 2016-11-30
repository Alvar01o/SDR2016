package com.uni.sd.subastadora.service.bid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.sd.subastadora.beans.bid.BidB;
import com.uni.sd.subastadora.dto.bid.BidDTO;
import com.uni.sd.subastadora.dto.bid.BidResult;
import com.uni.sd.subastadora.rest.bid.IBidResource;
import com.uni.sd.subastadora.rest.bid.BidResourceImpl;
import com.uni.sd.subastadora.service.auction.IAuctionService;
import com.uni.sd.subastadora.service.typeBid.ITypeBidService;
import com.uni.sd.subastadora.service.user.IUserService;
import com.uni.sd.subastadora.services.base.BaseServiceImpl;

@Service("bidService")
public class BidServiceImpl extends BaseServiceImpl<BidB, BidDTO>
		implements IBidService {
	
	@Autowired
	private IAuctionService auctionService;
	@Autowired
	private ITypeBidService typeBidService;
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IBidResource _bidResource=new BidResourceImpl();
	
	
	public BidServiceImpl() {
	}

	@Override
	public BidB save(BidB bean) {
		final BidDTO dto = convertBeanToDto(bean);
		final BidDTO auctionDTO = _bidResource.save(dto);
		return convertDtoToBean(auctionDTO);
	}

	@Override
	public List<BidB> getAll() {
		final BidResult result = _bidResource.getAll();
		final List<BidDTO> cList = null == result.getBids() ? new ArrayList<BidDTO>()
				: result.getBids();
		final List<BidB> bids = new ArrayList<BidB>();

		for (BidDTO dto : cList) {
			final BidB bidB = convertDtoToBean(dto);
			bids.add(bidB);
		}
		return bids;
	}

	@Override
	public BidB getById(Integer id) {
		final BidDTO dto = _bidResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected BidB convertDtoToBean(BidDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("amount" ,String.valueOf(dto.getAmount()));
		final BidB bidB = new BidB(params);
		bidB.setAuction(auctionService.getById(dto.getAuctionId()));
		bidB.setTypeBid(typeBidService.getById(dto.getTypeBidId()));
		//bidB.setUser(userService.getById(dto.getUserId()));
		
		
		return bidB;
	}

	@Override
	protected BidDTO convertBeanToDto(BidB bean) {
		final BidDTO dto = new BidDTO();
		dto.setId(bean.getId());
		dto.setAmount(bean.getAmount());
		dto.setAuctionId(bean.getAuction().getId());
		dto.setTypeBidId(bean.getTypeBid().getId());
		dto.setUserId(bean.getUser().getId());
		
		return dto;
	}
	
	@Override						
	public List<BidB> find(String textToFind) {		//int maxItems, int page
		final BidResult result = _bidResource.find(textToFind);
		final List<BidDTO> rList = null == result.getBids() ? new ArrayList<BidDTO>()
				: result.getBids();

		final List<BidB> bids = new ArrayList<BidB>();
		for (BidDTO dto : rList) {
			final BidB bean = convertDtoToBean(dto);
			bids.add(bean);
		}
		return bids;
	}

}
