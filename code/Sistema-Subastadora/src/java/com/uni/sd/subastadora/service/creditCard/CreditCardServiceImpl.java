package com.uni.sd.subastadora.service.creditCard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.sd.subastadora.beans.creditCard.CreditCardB;
import com.uni.sd.subastadora.dto.creditCard.CreditCardDTO;
import com.uni.sd.subastadora.dto.creditCard.CreditCardResult;
import com.uni.sd.subastadora.rest.creditCard.ICreditCardResource;
import com.uni.sd.subastadora.rest.creditCard.CreditCardResourceImpl;
import com.uni.sd.subastadora.service.user.IUserService;
import com.uni.sd.subastadora.services.base.BaseServiceImpl;

@Service("creditCardService")
public class CreditCardServiceImpl extends BaseServiceImpl<CreditCardB, CreditCardDTO>
		implements ICreditCardService {
	@Autowired
	private IUserService userService;
	@Autowired
	private ICreditCardResource _creditCardResource=new CreditCardResourceImpl();
	
	
	public CreditCardServiceImpl() {
	}

	@Override
	public CreditCardB save(CreditCardB bean) {
		final CreditCardDTO dto = convertBeanToDto(bean);
		final CreditCardDTO creditCardDTO = _creditCardResource.save(dto);
		return convertDtoToBean(creditCardDTO);
	}

	@Override
	public List<CreditCardB> getAll() {
		final CreditCardResult result = _creditCardResource.getAll();
		final List<CreditCardDTO> cList = null == result.getCreditCards() ? new ArrayList<CreditCardDTO>()
				: result.getCreditCards();
		final List<CreditCardB> creditCards = new ArrayList<CreditCardB>();

		for (CreditCardDTO dto : cList) {
			final CreditCardB creditCarB = convertDtoToBean(dto);
			creditCards.add(creditCarB);
		}
		return creditCards;
	}

	@Override
	public CreditCardB getById(Integer id) {
		final CreditCardDTO dto = _creditCardResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected CreditCardB convertDtoToBean(CreditCardDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("cardNumber", dto.getCardNumber());
		
		final CreditCardB creditCardB = new CreditCardB(params);
		creditCardB.setExpiration(dto.getExpiration());
		//creditCardB.setUser(userService.getById(dto.getUserId()));
		
		return creditCardB;
	}

	@Override
	protected CreditCardDTO convertBeanToDto(CreditCardB bean) {
		final CreditCardDTO dto = new CreditCardDTO();
		dto.setId(bean.getId());
		dto.setCardNumber(bean.getCardNumber());
		dto.setExpiration(bean.getExpiration());
		dto.setUserId(bean.getUser().getId());
		return dto;
	}
	
	@Override						
	public List<CreditCardB> find(String textToFind) {		//int maxItems, int page
		final CreditCardResult result = _creditCardResource.find(textToFind);
		final List<CreditCardDTO> rList = null == result.getCreditCards() ? new ArrayList<CreditCardDTO>()
				: result.getCreditCards();

		final List<CreditCardB> creditCards = new ArrayList<CreditCardB>();
		for (CreditCardDTO dto : rList) {
			final CreditCardB bean = convertDtoToBean(dto);
			creditCards.add(bean);
		}
		return creditCards;
	}

}
