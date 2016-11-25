package auction;




import java.sql.Time;
import java.util.Date;

import base.AbstractBaseManager;

import com.uni.sd.subastadora.dto.auction.AuctionDTO;
import com.uni.sd.subastadora.dto.auction.AuctionResult;
import com.uni.sd.subastadora.dto.role.RoleDTO;
import com.uni.sd.subastadora.dto.role.RoleResult;

public class AuctionManager extends AbstractBaseManager {
	public AuctionManager() {
		
		super();
	
		
	}
	
	
	
	public void addAuction(Integer product, Integer winner, Date time) {
		
		AuctionDTO auctionDTO = new AuctionDTO();
		auctionDTO.setProductId(product);
		auctionDTO.setWinnerId(winner);
		auctionDTO.setTime(time);
		
		
		
		getJerseyClient().resource(getBaseUrl() + "/auction").entity(auctionDTO).post(AuctionDTO.class);
	}
	
	
	public void getAllAuctions() {
		AuctionResult auctionResult = getJerseyClient().resource(getBaseUrl() + "/auction").get(AuctionResult.class);
		for (AuctionDTO p : auctionResult.getAuctions()) {
			System.out.println("Product: "+p.getProductId());
			System.out.println("Winner: "+p.getWinnerId());
			System.out.println("Time: "+p.getTime());
			
			
		}
	}
	
	public void getByIdAuction(int id){
		AuctionDTO auctionResult = getJerseyClient().resource(getBaseUrl() + "/auction/"+id).get(AuctionDTO.class);
		System.out.println("Product: "+auctionResult.getProductId());
		System.out.println("Winner: "+auctionResult.getWinnerId());
		System.out.println("Time: "+auctionResult.getTime());
		
	}
	
	public void getByPropertyAuction(String textToFind){
		AuctionResult patResult = getJerseyClient().resource(getBaseUrl() + "/auction/search/"+textToFind).get(AuctionResult.class);
		for (AuctionDTO c : patResult.getAuctions()) {
			System.out.println("Product: "+c.getProductId());
			System.out.println("Winner: "+c.getWinnerId());
			System.out.println("Time: "+c.getTime());
			
		}
		
	}
	
}
