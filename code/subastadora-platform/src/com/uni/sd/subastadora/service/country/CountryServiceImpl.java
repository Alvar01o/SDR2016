
package com.uni.sd.subastadora.service.country;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.sd.subastadora.dao.country.CountryDaoImpl;
import com.uni.sd.subastadora.dao.country.ICountryDao;
import com.uni.sd.subastadora.domain.location.country.CountryDomain;
import com.uni.sd.subastadora.dto.location.country.CountryDTO;
import com.uni.sd.subastadora.dto.location.country.CountryResult;

import com.uni.sd.subastadora.service.base.BaseServiceImpl;

@Service
public class CountryServiceImpl extends BaseServiceImpl<CountryDTO, CountryDomain, CountryDaoImpl, CountryResult> implements ICountryService {
	@Autowired
	private ICountryDao countryDao;

	@Override
	@Transactional
	public CountryDTO save(CountryDTO dto) {
		final CountryDomain domain = convertDtoToDomain(dto);
		final CountryDomain countryDomain = countryDao.save(domain);
		return convertDomainToDto(countryDomain);
	}

	@Override
	@Transactional
	public CountryDTO getById(Integer id){
		final CountryDomain domain = countryDao.getById(id);
		final CountryDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public CountryResult getAll() {
		final List<CountryDTO> countries = new ArrayList<>();
		for (CountryDomain domain : countryDao.findAll()) {
			final CountryDTO dto = convertDomainToDto(domain);
			countries.add(dto);
		}
		final CountryResult countryResult = new CountryResult();
		countryResult.setCountries(countries);
		return countryResult;
	}

	@Override
	protected CountryDTO convertDomainToDto(CountryDomain domain) {
		final CountryDTO dto = new CountryDTO();
		dto.setId(domain.getId());
		dto.setName(domain.getName());
		return dto;
	}

	@Override
	protected CountryDomain convertDtoToDomain(CountryDTO dto) {
		final CountryDomain domain = new CountryDomain();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		return domain;
	}

	@Override
	public CountryResult find(String textToFind){
		// TODO Auto-generated method stub
		return null;
	}

}
