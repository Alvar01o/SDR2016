package com.uni.sd.subastadora.service.typeBid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.sd.subastadora.beans.typeBid.TypeBidB;
import com.uni.sd.subastadora.dto.typeBid.TypeBidDTO;
import com.uni.sd.subastadora.dto.typeBid.TypeBidResult;
import com.uni.sd.subastadora.rest.typeBid.ITypeBidResource;
import com.uni.sd.subastadora.rest.typeBid.TypeBidResourceImpl;
import com.uni.sd.subastadora.services.base.BaseServiceImpl;
import com.uni.sd.subastadora.service.user.IUserService;

@Service("typeBidService")
public class TypeBidServiceImpl extends BaseServiceImpl<TypeBidB, TypeBidDTO>
		implements ITypeBidService {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ITypeBidResource _typeBidResource=new TypeBidResourceImpl();
	
	
	public TypeBidServiceImpl() {
	}

	@Override
	public	TypeBidB save(TypeBidB bean) {
		final TypeBidDTO dto = convertBeanToDto(bean);
		final TypeBidDTO productDTO = _typeBidResource.save(dto);
		return convertDtoToBean(productDTO);
	}

	@Override
	public List<TypeBidB> getAll() {
		final TypeBidResult result = _typeBidResource.getAll();
		final List<TypeBidDTO> cList = null == result.getTypeBids() ? new ArrayList<TypeBidDTO>()
				: result.getTypeBids();
		final List<TypeBidB> typeBids = new ArrayList<TypeBidB>();

		for (TypeBidDTO dto : cList) {
			final TypeBidB typeBidB = convertDtoToBean(dto);
			typeBids.add(typeBidB);
		}
		return typeBids;
	}

	@Override
	public TypeBidB getById(Integer id) {
		final TypeBidDTO dto = _typeBidResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected TypeBidB convertDtoToBean(TypeBidDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
	
		
		final TypeBidB productB = new TypeBidB(params);
		//productB.setUser(userService.getById(dto.getUserId()));
		
		return productB;
	}

	@Override
	protected TypeBidDTO convertBeanToDto(TypeBidB bean) {
		final TypeBidDTO dto = new TypeBidDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
	

		return dto;
	}
	
	@Override
	public List<TypeBidB> find (String textToFind, int maxItems, int page) {
		final TypeBidResult result = _typeBidResource.find(textToFind, maxItems, page);
		final List<TypeBidDTO> rList = null == result.getTypeBids() ? new ArrayList<TypeBidDTO>()
				: result.getTypeBids();

		final List<TypeBidB> typeBids = new ArrayList<TypeBidB>();
		for (TypeBidDTO dto : rList) {
			final TypeBidB bean = convertDtoToBean(dto);
			typeBids.add(bean);
		}
		return typeBids;
	}

	
	@Override						
	public List<TypeBidB> find(String textToFind) {		//int maxItems, int page
		final TypeBidResult result = _typeBidResource.find(textToFind);
		final List<TypeBidDTO> rList = null == result.getTypeBids() ? new ArrayList<TypeBidDTO>()
				: result.getTypeBids();

		final List<TypeBidB> bids = new ArrayList<TypeBidB>();
		for (TypeBidDTO dto : rList) {
			final TypeBidB bean = convertDtoToBean(dto);
			bids.add(bean);
		}
		return bids;
	}

	

}
