package Sistema


import org.springframework.beans.factory.annotation.Autowired;

import com.uni.sd.subastadora.service.auction.AuctionServiceImpl
import com.uni.sd.subastadora.service.auction.IAuctionService
import com.uni.sd.subastadora.service.role.IRoleService;


class InicioController {
	def IAuctionService auctionService=new AuctionServiceImpl()
	
	
		static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
		def index() {
			def auctions = auctionService.getAll()
		[auctionInstanceList: auctions, auctionInstanceTotal: auctions.size()]
		}
	
}