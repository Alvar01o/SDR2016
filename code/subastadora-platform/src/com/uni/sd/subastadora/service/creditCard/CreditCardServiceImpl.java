package com.uni.sd.subastadora.service.creditCard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;







import com.uni.sd.subastadora.dao.creditCard.CreditCardDaoImpl;
import com.uni.sd.subastadora.dao.creditCard.ICreditCardDao;
import com.uni.sd.subastadora.dao.user.IUserDao;
import com.uni.sd.subastadora.domain.creditCard.CreditCardDomain;
import com.uni.sd.subastadora.dto.creditCard.CreditCardDTO;
import com.uni.sd.subastadora.dto.creditCard.CreditCardResult;
import com.uni.sd.subastadora.service.base.BaseServiceImpl;
import com.uni.sd.subastadora.service.creditCard.ICreditCardService;

@Service
public class CreditCardServiceImpl extends BaseServiceImpl<CreditCardDTO, CreditCardDomain, CreditCardDaoImpl, CreditCardResult>
		implements ICreditCardService {
	@Autowired
	private ICreditCardDao creditCardDao;

	@Autowired
	private IUserDao userDao;

	
	@Override
	@Transactional
	public CreditCardDTO save(CreditCardDTO dto) {
		final CreditCardDomain domain = convertDtoToDomain(dto);
		final CreditCardDomain creditCardDomain = creditCardDao.save(domain);
		return convertDomainToDto(creditCardDomain);
	}

	@Override
	@Transactional
	public CreditCardDTO getById(Integer id) {
		final CreditCardDomain domain = creditCardDao.getById(id);
		final CreditCardDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public CreditCardResult getAll() {
		final List<CreditCardDTO> creditCards = new ArrayList<>();
		for (CreditCardDomain domain : creditCardDao.findAll()) {
			final CreditCardDTO dto = convertDomainToDto(domain);
			creditCards.add(dto);
		}
		final CreditCardResult creditCardResult = new CreditCardResult();
		creditCardResult.setCreditCards(creditCards);
		return creditCardResult;
	}


	@Override
	protected CreditCardDTO convertDomainToDto(CreditCardDomain domain) {
		final CreditCardDTO dto = new CreditCardDTO();
		dto.setId(domain.getId());
		dto.setCardNumber(domain.getCardNumber());
		dto.setExpiration(domain.getExpiration());
		dto.setUserId(domain.getUser().getId());
		
		return dto;
	}

	@Override
	protected CreditCardDomain convertDtoToDomain(CreditCardDTO dto) {
		final CreditCardDomain domain = new CreditCardDomain();
		domain.setId(dto.getId());
		domain.setUser(userDao.getById(dto.getUserId()));
		domain.setCardNumber(dto.getCardNumber());
		domain.setExpiration(dto.getExpiration());
		
		return domain;
	}

	@Override
	@Transactional
	public CreditCardResult find(String textToFind){
		final List<CreditCardDTO> creditCards = new ArrayList<>();
		for (CreditCardDomain domain : creditCardDao.find(textToFind)) {
			final CreditCardDTO dto = convertDomainToDto(domain);
			creditCards.add(dto);
		}
		final CreditCardResult creditCardResult = new CreditCardResult();
		creditCardResult.setCreditCards(creditCards);
		return creditCardResult;
	}

}

