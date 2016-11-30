package com.uni.sd.subastadora.service.valuation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.sd.subastadora.beans.valuation.ValuationB;
import com.uni.sd.subastadora.dto.valuation.ValuationDTO;
import com.uni.sd.subastadora.dto.valuation.ValuationResult;
import com.uni.sd.subastadora.rest.valuation.IValuationResource;
import com.uni.sd.subastadora.rest.valuation.ValuationResourceImpl;
import com.uni.sd.subastadora.services.base.BaseServiceImpl;
import com.uni.sd.subastadora.service.auction.IAuctionService;
import com.uni.sd.subastadora.service.user.IUserService;

@Service("valuationService")
public class ValuationServiceImpl extends BaseServiceImpl<ValuationB, ValuationDTO>
		implements IValuationService {
	@Autowired
	private IAuctionService auctionService;
	@Autowired
	private IUserService auctioneerService;
	@Autowired
	private IUserService voterService;
	@Autowired
	private IValuationResource _valuationResource=new ValuationResourceImpl();
	
	
	public ValuationServiceImpl() {
	}

	@Override
	public ValuationB save(ValuationB bean) {
		final ValuationDTO dto = convertBeanToDto(bean);
		final ValuationDTO valuationDTO = _valuationResource.save(dto);
		return convertDtoToBean(valuationDTO);
	}

	@Override
	public List<ValuationB> getAll() {
		final ValuationResult result = _valuationResource.getAll();
		final List<ValuationDTO> cList = null == result.getValuations() ? new ArrayList<ValuationDTO>()
				: result.getValuations();
		final List<ValuationB> valuations = new ArrayList<ValuationB>();

		for (ValuationDTO dto : cList) {
			final ValuationB valuationB = convertDtoToBean(dto);
			valuations.add(valuationB);
		}
		return valuations;
	}

	@Override
	public ValuationB getById(Integer id) {
		final ValuationDTO dto = _valuationResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected ValuationB convertDtoToBean(ValuationDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("score", String.valueOf(dto.getScore()));

		final ValuationB valuationB = new ValuationB(params);
		valuationB.setAuction(auctionService.getById(dto.getAuctionId()));
		//valuationB.setAuctioneer(auctioneerService.getById(dto.getAuctioneerId()));
		//valuationB.setVoter(voterService.getById(dto.getVoterId()));
		
		return valuationB;
	}

	@Override
	protected ValuationDTO convertBeanToDto(ValuationB bean) {
		final ValuationDTO dto = new ValuationDTO();
		dto.setId(bean.getId());
		dto.setScore(bean.getScore());
		dto.setAuctionId(bean.getAuction().getId());
		dto.setAuctioneerId(bean.getAuctioneer().getId());
		dto.setVoterId(bean.getVoter().getId());


		return dto;
	}
	
	@Override						
	public List<ValuationB> find(String textToFind) {		//int maxItems, int page
		final ValuationResult result = _valuationResource.find(textToFind);
		final List<ValuationDTO> rList = null == result.getValuations() ? new ArrayList<ValuationDTO>()
				: result.getValuations();

		final List<ValuationB> bids = new ArrayList<ValuationB>();
		for (ValuationDTO dto : rList) {
			final ValuationB bean = convertDtoToBean(dto);
			bids.add(bean);
		}
		return bids;
	}

}
