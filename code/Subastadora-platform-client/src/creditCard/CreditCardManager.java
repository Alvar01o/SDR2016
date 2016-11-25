package creditCard;

import java.util.Date;

import base.AbstractBaseManager;

import com.uni.sd.subastadora.dto.creditcard.CreditCardDTO;
import com.uni.sd.subastadora.dto.creditcard.CreditCardResult;

public class CreditCardManager extends AbstractBaseManager {
	public CreditCardManager() {
		
		super();
		
		
	}
	
	
	public void addCreditCard(String number, Date expiration, Integer userId) {
		
		CreditCardDTO creditCardDTO = new CreditCardDTO();
		creditCardDTO.setCardNumber(number);
		creditCardDTO.setExpiration(expiration);
		creditCardDTO.setUserId(userId);
		
		
		
		getJerseyClient().resource(getBaseUrl() + "/creditcard").entity(creditCardDTO).post(CreditCardDTO.class);
	}
	
	
	public void getAllCreditCards() {
		CreditCardResult creditCardResult = getJerseyClient().resource(getBaseUrl() + "/creditcard").get(CreditCardResult.class);
		for (CreditCardDTO p : creditCardResult.getCreditCards()) {
			System.out.println("Number: "+p.getCardNumber());
			System.out.println("Expiration: "+p.getExpiration());
			System.out.println("User: "+p.getUserId());
			
			
		}
	}
	
	public void getByIdCreditCard(int id){
		CreditCardDTO creditCardResult = getJerseyClient().resource(getBaseUrl() + "/creditcard/"+id).get(CreditCardDTO.class);
		System.out.println("Number: "+ creditCardResult.getCardNumber());
		System.out.println("Expiration: "+ creditCardResult.getExpiration());
		System.out.println("Rol: "+ creditCardResult.getUserId());
		
	}
	
	public void getByPropertyCreditCard(String textToFind){
		CreditCardResult patResult = getJerseyClient().resource(getBaseUrl() + "/creditcard/search/"+textToFind).get(CreditCardResult.class);
		for (CreditCardDTO c : patResult.getCreditCards()) {
			System.out.println("Number: "+c.getCardNumber());
			System.out.println("Expiration: "+c.getExpiration());
			System.out.println("User: "+c.getExpiration());
			
		}
		
	}
	
}
