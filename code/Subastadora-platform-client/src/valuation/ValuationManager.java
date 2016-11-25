package valuation;


import base.AbstractBaseManager;

import com.uni.sd.subastadora.dto.user.UserDTO;
import com.uni.sd.subastadora.dto.user.UserResult;
import com.uni.sd.subastadora.dto.valuation.ValuationDTO;
import com.uni.sd.subastadora.dto.valuation.ValuationResult;
import com.uni.sd.subastadora.dto.role.RoleDTO;
import com.uni.sd.subastadora.dto.role.RoleResult;

public class ValuationManager extends AbstractBaseManager {
	public ValuationManager() {
		super();
		
	}
	
public void addValuation(Integer score, Integer voterId, Integer auctioneerId, Integer auctionId) {
		
		ValuationDTO valuationDTO = new ValuationDTO();
		valuationDTO.setScore(score);
		valuationDTO.setVoterId(voterId);
		valuationDTO.setAuctioneerId(auctioneerId);
		valuationDTO.setAuctionId(auctionId);
		
		
		
		getJerseyClient().resource(getBaseUrl() + "/valuation").entity(valuationDTO).post(ValuationDTO.class);
	}
	
	
	public void getAllValuations() {
		ValuationResult valuationResult = getJerseyClient().resource(getBaseUrl() + "/valuation").get(ValuationResult.class);
		for (ValuationDTO p : valuationResult.getValuations()) {
			System.out.println("Score: "+p.getScore());
			System.out.println("Voter: "+p.getVoterId());
			System.out.println("Auctioneer: "+p.getAuctioneerId());
			System.out.println("Auction: "+p.getAuctionId());
			
			
		}
	}
	
	public void getByIdValuation(int id){
		ValuationDTO valuationResult = getJerseyClient().resource(getBaseUrl() + "/valuation/"+id).get(ValuationDTO.class);
		
		System.out.println("Score: "+ valuationResult.getScore());
		System.out.println("Voter: "+ valuationResult.getVoterId());
		System.out.println("Auctioneer: "+ valuationResult.getAuctioneerId());
		System.out.println("Auction: "+ valuationResult.getAuctionId());
		
	}
	
	public void getByPropertyValuation(String textToFind){
		ValuationResult patResult = getJerseyClient().resource(getBaseUrl() + "/valuation/search/"+textToFind).get(ValuationResult.class);
		for (ValuationDTO c : patResult.getValuations()) {
			System.out.println("Score: "+ c.getScore());
			System.out.println("Voter: "+ c.getVoterId());
			System.out.println("Auctioneer: "+ c.getAuctioneerId());
			System.out.println("Auction: "+ c.getAuctionId());
			
		}
		
	}
	
}
