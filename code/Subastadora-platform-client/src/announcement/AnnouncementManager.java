package announcement;





import java.sql.Time;
import java.util.Date;

import base.AbstractBaseManager;

import com.uni.sd.subastadora.dto.announcement.AnnouncementDTO;
import com.uni.sd.subastadora.dto.announcement.AnnouncementResult;
import com.uni.sd.subastadora.dto.role.RoleDTO;
import com.uni.sd.subastadora.dto.role.RoleResult;

public class AnnouncementManager extends AbstractBaseManager {
	public AnnouncementManager() {
		
		super();
	
		
	}
	
	
	
	public void addAnnouncement(Integer product, Integer user) {
		
		AnnouncementDTO announcementDTO = new AnnouncementDTO();
		announcementDTO.setProductId(product);
		announcementDTO.setUserId(user);
		
		
		
		getJerseyClient().resource(getBaseUrl() + "/announcement").entity(announcementDTO).post(AnnouncementDTO.class);
	}
	
	
	public void getAllAnnouncements() {
		AnnouncementResult announcementResult = getJerseyClient().resource(getBaseUrl() + "/announcement").get(AnnouncementResult.class);
		for (AnnouncementDTO p : announcementResult.getAnnouncements()) {
			System.out.println("Product: "+p.getProductId());
			System.out.println("User: "+p.getUserId());
			
			
		}
	}
	
	public void getByIdAnnouncement(int id){
		AnnouncementDTO announcementResult = getJerseyClient().resource(getBaseUrl() + "/announcement/"+id).get(AnnouncementDTO.class);
		System.out.println("Product: "+ announcementResult.getProductId());
		System.out.println("User: "+ announcementResult.getUserId());
		
	}
	
	public void getByPropertyAnnouncement(String textToFind){
		AnnouncementResult patResult = getJerseyClient().resource(getBaseUrl() + "/announcement/search/"+textToFind).get(AnnouncementResult.class);
		for (AnnouncementDTO c : patResult.getAnnouncements()) {
			System.out.println("Product: "+c.getProductId());
			System.out.println("User: "+c.getUserId());
			
			
		}
		
	}
	
}
