package com.uni.sd.subastadora.service.auction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.sd.subastadora.beans.auction.AuctionB;
import com.uni.sd.subastadora.dto.auction.AuctionDTO;
import com.uni.sd.subastadora.dto.auction.AuctionResult;
import com.uni.sd.subastadora.rest.auction.IAuctionResource;
import com.uni.sd.subastadora.rest.auction.AuctionResourceImpl;
import com.uni.sd.subastadora.rest.product.ProductResourceImpl;
import com.uni.sd.subastadora.rest.user.UserResourceImpl;
import com.uni.sd.subastadora.service.product.IProductService;
import com.uni.sd.subastadora.service.product.ProductServiceImpl;
import com.uni.sd.subastadora.service.user.IUserService;
import com.uni.sd.subastadora.service.user.UserServiceImpl;
import com.uni.sd.subastadora.services.base.BaseServiceImpl;

@Service("auctionService")
public class AuctionServiceImpl extends BaseServiceImpl<AuctionB, AuctionDTO>
		implements IAuctionService {
	
	@Autowired
	private IProductService productService=new ProductServiceImpl();
	@Autowired
	private IUserService userService=new UserServiceImpl();
	@Autowired
	private IAuctionResource _auctionResource=new AuctionResourceImpl();
	
	
	public AuctionServiceImpl() {
	}

	@Override
	public AuctionB save(AuctionB bean) {
		final AuctionDTO dto = convertBeanToDto(bean);
		final AuctionDTO auctionDTO = _auctionResource.save(dto);
		return convertDtoToBean(auctionDTO);
	}

	@Override
	public List<AuctionB> getAll() {
		final AuctionResult result = _auctionResource.getAll();
		final List<AuctionDTO> cList = null == result.getAuctions() ? new ArrayList<AuctionDTO>()
				: result.getAuctions();
		final List<AuctionB> auctions = new ArrayList<AuctionB>();

		for (AuctionDTO dto : cList) {
			final AuctionB auctionB = convertDtoToBean(dto);
			auctions.add(auctionB);
		}
		return auctions;
	}

	@Override
	public AuctionB getById(Integer id) {
		final AuctionDTO dto = _auctionResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected AuctionB convertDtoToBean(AuctionDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		final AuctionB auctionB = new AuctionB(params);
		auctionB.setTime(dto.getTime());
		auctionB.setProduct(productService.getById(dto.getProductId()));
		auctionB.setWinner(userService.getById(dto.getWinnerId()));
		return auctionB;
	}

	@Override
	protected AuctionDTO convertBeanToDto(AuctionB bean) {
		final AuctionDTO dto = new AuctionDTO();
		dto.setId(bean.getId());
		dto.setTime(bean.getTime());
		dto.setProductId(bean.getId());
		dto.setWinnerId(bean.getId());
		return dto;
	}
	
	@Override						
	public List<AuctionB> find(String textToFind) {		//int maxItems, int page
		final AuctionResult result = _auctionResource.find(textToFind);
		final List<AuctionDTO> rList = null == result.getAuctions() ? new ArrayList<AuctionDTO>()
				: result.getAuctions();

		final List<AuctionB> auctions = new ArrayList<AuctionB>();
		for (AuctionDTO dto : rList) {
			final AuctionB bean = convertDtoToBean(dto);
			auctions.add(bean);
		}
		return auctions;
	}

	@Override
	public List<AuctionB> find (String textToFind, int maxItems, int page) {
		final AuctionResult result = _auctionResource.find(textToFind, maxItems, page);
		final List<AuctionDTO> rList = null == result.getAuctions() ? new ArrayList<AuctionDTO>()
				: result.getAuctions();

		final List<AuctionB> auctions = new ArrayList<AuctionB>();
		for (AuctionDTO dto : rList) {
			final AuctionB bean = convertDtoToBean(dto);
			auctions.add(bean);
		}
		return auctions;
	}

}
