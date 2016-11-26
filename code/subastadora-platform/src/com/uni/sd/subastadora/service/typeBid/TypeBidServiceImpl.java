package com.uni.sd.subastadora.service.typeBid;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.sd.subastadora.dao.typeBid.TypeBidDaoImp;
import com.uni.sd.subastadora.dao.typeBid.ITypeBidDao;
import com.uni.sd.subastadora.domain.typeBid.TypeBidDomain;
import com.uni.sd.subastadora.dto.typeBid.TypeBidDTO;
import com.uni.sd.subastadora.dto.typeBid.TypeBidResult;
import com.uni.sd.subastadora.service.base.BaseServiceImpl;

@Service
public class TypeBidServiceImpl extends BaseServiceImpl<TypeBidDTO, TypeBidDomain, TypeBidDaoImp, TypeBidResult>
		implements ITypeBidService {
	@Autowired
	private ITypeBidDao typeBidDao=new TypeBidDaoImp();

	@Override
	@Transactional
	public TypeBidDTO save(TypeBidDTO dto) {
		final TypeBidDomain domain = convertDtoToDomain(dto);
		final TypeBidDomain typeBidDomain = typeBidDao.save(domain);
		return convertDomainToDto(typeBidDomain);
	}

	@Override
	@Transactional
	public TypeBidDTO getById(Integer id) {
		final TypeBidDomain domain = typeBidDao.getById(id);
		final TypeBidDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public TypeBidResult getAll() {
		final List<TypeBidDTO> typeBids = new ArrayList<>();
		for (TypeBidDomain domain : typeBidDao.findAll()) {
			final TypeBidDTO dto = convertDomainToDto(domain);
			typeBids.add(dto);
		}
		final TypeBidResult typeBidsResult = new TypeBidResult();
		typeBidsResult.setTypeBids(typeBids);
		return typeBidsResult;
	}

	@Override
	@Transactional
	public TypeBidResult find(String textToFind) {
		final List<TypeBidDTO> typeBids = new ArrayList<>();
		for (TypeBidDomain domain : typeBidDao.find(textToFind)) {
			final TypeBidDTO dto = convertDomainToDto(domain);
			typeBids.add(dto);
		}
		final TypeBidResult typeBidResult = new TypeBidResult();
		typeBidResult.setTypeBids(typeBids);
		return typeBidResult;
	}

	@Override
	protected TypeBidDTO convertDomainToDto(TypeBidDomain domain) {
		final TypeBidDTO dto = new TypeBidDTO();
		dto.setId(domain.getId());
		dto.setName(domain.getName());
		return dto;
	}

	@Override
	protected TypeBidDomain convertDtoToDomain(TypeBidDTO dto) {
		final TypeBidDomain domain = new TypeBidDomain();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		return domain;
	}

}

