package com.uni.sd.subastadora.rest.announcement;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.announcement.AnnouncementDTO;
import com.uni.sd.subastadora.dto.announcement.AnnouncementResult;
import com.uni.sd.subastadora.rest.base.BaseResourceImpl;

@Repository("announcementResource")
public class AnnouncementResourceImpl extends BaseResourceImpl<AnnouncementDTO> implements
		IAnnouncementResource {

	public AnnouncementResourceImpl() {
		super(AnnouncementDTO.class, "/announcement");
	}

	@Override
	@CacheEvict(value = CACHE_REGION, key = "'announcements'")
	@CachePut(value = CACHE_REGION, key = "'announcement_' + #announcement.id", condition = "#announcement.id!=null")
	public AnnouncementDTO save(AnnouncementDTO announcement) {
		AnnouncementDTO newDto = super.save(announcement);
		if (null == announcement.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"announcement_" + newDto.getId(), newDto);
		}
		return newDto;
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'announcement_' + #id")
	public AnnouncementDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'announcements'")
	public AnnouncementResult getAll() {
		
		final AnnouncementResult result = getWebResource().get(AnnouncementResult.class);
		return result;
	}

	@Override
	public AnnouncementResult find(String textToFind, int maxItems, int page) {
		
		final AnnouncementResult result = findWR(textToFind, maxItems, page).get(
				AnnouncementResult.class);
		return result;
	}
	

	public AnnouncementResult find(String textToFind) {
		
		final AnnouncementResult result = getWebResource().path("/search/" + textToFind).get(AnnouncementResult.class);
		return result;
	}

}
