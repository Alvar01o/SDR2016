import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import announcement.AnnouncementManager;
import auction.AuctionManager;
import bid.BidManager;
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
		bidManager();
		
		
	}
	
	public static void userManager(){
		System.out.println("\n\n Users \n");
		UserManager s = new UserManager();
		s.addUser("usuario1", "cualquier cosa","nombre1", "cualquier cosa", "donde sea", "correo1",1);
		s.addUser("usuario2", "lalala", "nombre2", "lalala","donde sea", "correo2",2);
		s.addUser("usuario3", "cualquier cosa", "nombre3", "cualquier cosa","donde sea", "correo3",3);
		s.addUser("usuario4", "lalala", "nombre4", "lalala","donde sea", "correo4",1);
		s.addUser("usuario5", "cualquier cosa", "nombre5", "cualquier cosa","donde sea", "correo5",2);
		s.addUser("usuario6", "lalala", "nombre6", "lalala","usuario6", "correo6",3);
		s.getAllUsers();
		
	}
	
	public static void productManager(){
		System.out.println("\n\n Products \n");
		ProductManager s = new ProductManager();
		
		s.addProduct("computadora", "acer", CategoryEnum.LIBROS, 300000, "ni idea", 1);
		s.addProduct("audiculares", "sony", CategoryEnum.MUSICAS, 120000, "ni idea", 2);
		s.addProduct("zapatos", "acer", CategoryEnum.PELICULAS, 400000, "ni idea", 1);
		s.addProduct("libro", "cuento de adas", CategoryEnum.LIBROS, 180000, "ni idea", 2);
		s.addProduct("novela", "best seller", CategoryEnum.LIBROS, 200000, "ni idea", 1);
		s.addProduct("cd", "sony", CategoryEnum.MUSICAS, 120000, "ni idea", 2);
		s.addProduct("zapatos", "acer", CategoryEnum.PELICULAS, 300000, "ni idea", 1);
		s.addProduct("cuaderno", "sony", CategoryEnum.LIBROS, 520000, "ni idea", 2);
		s.getAllProducts();
		
	}
	
	public static void auctionManager() throws ParseException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		System.out.println("\n\n Auctions \n");
		AuctionManager s = new AuctionManager();
		s.addAuction(1, 1, formatter.parse("31-08-1982 10:20:56"));
		s.addAuction(2, 2, formatter.parse("31-08-1982 10:20:56"));
		s.addAuction(3, 1, formatter.parse("31-08-1982 10:20:56"));
		s.addAuction(4, 2, formatter.parse("31-08-1982 10:20:56"));
		s.addAuction(5, 1, formatter.parse("31-08-1982 10:20:56"));
		s.addAuction(6, 2, formatter.parse("31-08-1982 10:20:56"));
		s.addAuction(7, 1, formatter.parse("31-08-1982 10:20:56"));
		s.addAuction(8, 2, formatter.parse("31-08-1982 10:20:56"));
		s.addAuction(2, 1, formatter.parse("31-08-1982 10:20:56"));
		s.addAuction(4, 2, formatter.parse("31-08-1982 10:20:56"));
		
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
	
	
	public static void bidManager(){

		System.out.println("\n\n Bids \n");
		BidManager s = new BidManager();
		s.addBid(1000, 1, 2, 1);
		s.addBid(2000, 2, 1, 2);
		s.getAllBids();

		
	}
	
	public static void announcementManager(){
		System.out.println("\n\n Announcements \n");
		AnnouncementManager s = new AnnouncementManager();
		s.addAnnouncement(1,2);
		s.addAnnouncement(2,1);
		s.getAllAnnouncements();
		
	}

}
