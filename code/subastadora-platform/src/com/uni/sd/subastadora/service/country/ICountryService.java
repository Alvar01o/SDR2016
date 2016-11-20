package com.uni.sd.subastadora.service.country;

import com.uni.sd.subastadora.dao.country.CountryDaoImpl;
import com.uni.sd.subastadora.domain.location.country.CountryDomain;
import com.uni.sd.subastadora.dto.location.country.CountryDTO;
import com.uni.sd.subastadora.dto.location.country.CountryResult;
import com.uni.sd.subastadora.service.base.IBaseService;

public interface ICountryService extends IBaseService<CountryDTO, CountryDomain, CountryDaoImpl, CountryResult> {

	public CountryResult find(String textToFind);
}
