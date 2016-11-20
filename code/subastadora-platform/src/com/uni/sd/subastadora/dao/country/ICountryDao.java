package com.uni.sd.subastadora.dao.country;

import java.util.List;

import com.uni.sd.subastadora.dao.base.IBaseDao;
import com.uni.sd.subastadora.domain.location.country.CountryDomain;

public interface ICountryDao extends IBaseDao<CountryDomain> {

	public List<CountryDomain>find(String textToFind);
}
