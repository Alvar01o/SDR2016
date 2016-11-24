package com.uni.sd.subastadora.dao.valuation;


import java.util.List;

import com.uni.sd.subastadora.dao.base.IBaseDao;
import com.uni.sd.subastadora.domain.valuation.ValuationDomain;

public interface IValuationDao extends IBaseDao<ValuationDomain> {

	public List<ValuationDomain>find(String textToFind);
}
