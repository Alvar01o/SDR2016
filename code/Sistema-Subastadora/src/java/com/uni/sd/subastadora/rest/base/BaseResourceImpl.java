package com.uni.sd.subastadora.rest.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dto.base.BaseDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Repository

public abstract class BaseResourceImpl<DTO extends BaseDTO> implements IBaseResource<DTO> {
	private final String _resourcePath;
	private final Class<DTO> _dtoClass;
	private final WebResource _webResource;


	protected static final String CACHE_REGION = "subastadora-client-web-cache";
	private static final String BASE_URL = "http://localhost:8080/subastadora-platform/rest";
	
	@Autowired
	@Qualifier("grailsCacheManager")
	private CacheManager _cacheManager;
	
	@Autowired

	public BaseResourceImpl(Class<DTO> dtoClass, String resourcePath) {
		_dtoClass = dtoClass;
		_resourcePath = BASE_URL + resourcePath;

		final Client jerseyClient = Client.create();

		_webResource = jerseyClient.resource(_resourcePath);
	}

	protected WebResource getWebResource() {
		return _webResource;
	}

	protected Class<DTO> getDtoClass() {
		return _dtoClass;
	}
	protected CacheManager getCacheManager() {
		return _cacheManager;
	}

	
	
	@Override
	public DTO save(DTO dto) {
		return getWebResource().entity(dto).post(getDtoClass());
	}

	@Override
	public DTO getById(Integer id) {
		return getWebResource().path("/" + id).get(getDtoClass());
	}
	
	public WebResource findWR(String textToFind, int maxItems, int page) {
		if (null == textToFind){
			
			return getWebResource().path("/search/" + maxItems + "/" + page);
		}else{
			
			return getWebResource().path("/search/" + maxItems + "/" + page + "/" + textToFind);
		}
	}

}
