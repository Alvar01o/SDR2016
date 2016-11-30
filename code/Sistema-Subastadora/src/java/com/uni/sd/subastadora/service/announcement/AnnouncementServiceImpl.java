package com.uni.sd.subastadora.service.announcement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.sd.subastadora.beans.announcement.AnnouncementB;
import com.uni.sd.subastadora.dto.announcement.AnnouncementDTO;
import com.uni.sd.subastadora.dto.announcement.AnnouncementResult;
import com.uni.sd.subastadora.rest.announcement.IAnnouncementResource;
import com.uni.sd.subastadora.rest.announcement.AnnouncementResourceImpl;
import com.uni.sd.subastadora.service.product.IProductService;
import com.uni.sd.subastadora.service.user.IUserService;
import com.uni.sd.subastadora.services.base.BaseServiceImpl;

@Service("announcementService")
public class AnnouncementServiceImpl extends BaseServiceImpl<AnnouncementB, AnnouncementDTO>
		implements IAnnouncementService {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IAnnouncementResource _announcementResource=new AnnouncementResourceImpl();
	
	
	public AnnouncementServiceImpl() {
	}

	@Override
	public AnnouncementB save(AnnouncementB bean) {
		final AnnouncementDTO dto = convertBeanToDto(bean);
		final AnnouncementDTO roleDTO = _announcementResource.save(dto);
		return convertDtoToBean(roleDTO);
	}

	@Override
	public List<AnnouncementB> getAll() {
		final AnnouncementResult result = _announcementResource.getAll();
		final List<AnnouncementDTO> cList = null == result.getAnnouncements() ? new ArrayList<AnnouncementDTO>()
				: result.getAnnouncements();
		final List<AnnouncementB> announcements = new ArrayList<AnnouncementB>();

		for (AnnouncementDTO dto : cList) {
			final AnnouncementB announcementB = convertDtoToBean(dto);
			announcements.add(announcementB);
		}
		return announcements;
	}

	@Override
	public AnnouncementB getById(Integer id) {
		final AnnouncementDTO dto = _announcementResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected AnnouncementB convertDtoToBean(AnnouncementDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		final AnnouncementB announcementB = new AnnouncementB(params);
		//announcementB.setUser(userService.getById(dto.getUserId()));
		announcementB.setProduct(productService.getById(dto.getProductId()));
		return announcementB;
	}

	@Override
	protected AnnouncementDTO convertBeanToDto(AnnouncementB bean) {
		final AnnouncementDTO dto = new AnnouncementDTO();
		dto.setId(bean.getId());
		dto.setProductId(bean.getProduct().getId());
		dto.setUserId(bean.getUser().getId());
		return dto;
	}
	
	@Override						
	public List<AnnouncementB> find(String textToFind) {		//int maxItems, int page
		final AnnouncementResult result = _announcementResource.find(textToFind);
		final List<AnnouncementDTO> rList = null == result.getAnnouncements() ? new ArrayList<AnnouncementDTO>()
				: result.getAnnouncements();

		final List<AnnouncementB> announcements = new ArrayList<AnnouncementB>();
		for (AnnouncementDTO dto : rList) {
			final AnnouncementB bean = convertDtoToBean(dto);
			announcements.add(bean);
		}
		return announcements;
	}

}
