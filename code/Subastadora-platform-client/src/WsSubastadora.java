import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import auction.AuctionManager;
import product.ProductManager;
import creditCard.CreditCardManager;
import user.UserManager;
import valuation.ValuationManager;
import com.uni.sd.subastadora.util.CategoryEnum;



public class WsSubastadora {

	public static void main(String[] args) throws ParseException {
		userManager();
		productManager();
		auctionManager();
		creditCardManager();
		valuationManager();
		
		
	}
	
	public static void userManager(){
		System.out.println("\n\n Users \n");
		UserManager s = new UserManager();
		s.addUser("Liliana", "cualquier cosa", 1, false, null);
		s.addUser("Elizabeth", "lalala", 1, true, "ksjhdf");
		s.getAllUsers();
		
	}
	
	public static void productManager(){
		System.out.println("\n\n Products \n");
		ProductManager s = new ProductManager();
		
		s.addProduct("computadora", "acer", null, 3000000, "ni idea", 1);
		s.addProduct("audiculares", "sony", null, 120000, "ni idea", 1);
		s.getAllProducts();
		
	}
	
	public static void auctionManager() throws ParseException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		System.out.println("\n\n Auctions \n");
		AuctionManager s = new AuctionManager();
		s.addAuction(1, 1, formatter.parse("31-08-1982 10:20:56"));
		s.addAuction(2, 2, formatter.parse("31-08-1982 10:20:56"));
		s.getAllAuctions();
		
	}
	
	public static void creditCardManager() throws ParseException{
		System.out.println("\n\n CreditCards \n");
		CreditCardManager s = new CreditCardManager();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		s.addCreditCard("4322-232-3243-432", formatter.parse("10-11-16"), 1);
		s.addCreditCard("8600-326-902-763", formatter.parse("10-11-16"), 1);
		s.getAllCreditCards();
		
	}
	
	public static void valuationManager(){
		System.out.println("\n\n Valuation \n");
		ValuationManager s = new ValuationManager();
		s.addValuation(200, 1, 2, 1);
		s.addValuation(500, 2, 1, 2);
		s.getAllValuations();
		
	}
}
