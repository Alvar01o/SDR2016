package bid;

import base.AbstractBaseManager;
import com.uni.sd.subastadora.dto.bid.BidDTO;
import com.uni.sd.subastadora.dto.bid.BidResult;
import com.uni.sd.subastadora.dto.typeBid.TypeBidDTO;
import com.uni.sd.subastadora.dto.typeBid.TypeBidResult;

public class BidManager extends AbstractBaseManager {
	public BidManager() {
		
		super();
		addTypeBids();
		
	}
	
	public void addTypeBids(){
		
		TypeBidDTO typeBidDTO1 = new TypeBidDTO();
		typeBidDTO1.setName("Administrador");
		
		TypeBidDTO typeBidDTO2 = new TypeBidDTO();
		typeBidDTO2.setName("Subastador");
		
		TypeBidDTO typeBidDTO3 = new TypeBidDTO();
		typeBidDTO3.setName("Cliente");
		
		getJerseyClient().resource(getBaseUrl() + "/typeBid").entity(typeBidDTO1).post(TypeBidDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/typeBid").entity(typeBidDTO2).post(TypeBidDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/typeBid").entity(typeBidDTO3).post(TypeBidDTO.class);

		
	}
	
	public void addBid(Integer amount, Integer user, Integer auction, Integer typeBid) {
		
		BidDTO bidDTO = new BidDTO();
		bidDTO.setAmount(amount);
		bidDTO.setUserId(user);
		bidDTO.setAuctionId(auction);
		bidDTO.setTypeBidId(typeBid);
		
		
		getJerseyClient().resource(getBaseUrl() + "/bid").entity(bidDTO).post(BidDTO.class);
	}
	
	
	public void getAllBids() {
		BidResult bidResult = getJerseyClient().resource(getBaseUrl() + "/bid").get(BidResult.class);
		for (BidDTO p : bidResult.getBids()) {
			System.out.println("Amount: "+p.getAmount());
			System.out.println("User: "+p.getUserId());
			System.out.println("Auction: "+p.getAuctionId());
			System.out.println("TypeBid: "+p.getTypeBidId());
			
			
		}
	}
	
	public void getByIdBid(int id){
		BidDTO bidResult = getJerseyClient().resource(getBaseUrl() + "/bid/"+id).get(BidDTO.class);
		System.out.println("Amount: "+ bidResult.getAmount());
		System.out.println("User: "+ bidResult.getUserId());
		System.out.println("Auction: "+ bidResult.getAuctionId());
		System.out.println("TypeBid: "+ bidResult.getTypeBidId());
		
	}
	
	public void getByPropertyBid(String textToFind){
		BidResult patResult = getJerseyClient().resource(getBaseUrl() + "/bid/search/"+textToFind).get(BidResult.class);
		for (BidDTO c : patResult.getBids()) {
			System.out.println("Amount: "+c.getAmount());
			System.out.println("User: "+c.getUserId());
			System.out.println("Auction: "+c.getAuctionId());
			System.out.println("TypeBid: "+c.getTypeBidId());
			
		}
		
	}
	
}

