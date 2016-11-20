package com.uni.sd.subastadora.dao.base;

import java.util.List;

import com.uni.sd.subastadora.domain.base.BaseDomain;

public interface IBaseDao<DOMAIN extends BaseDomain> {

	public DOMAIN save(DOMAIN domain);

	public DOMAIN getById(Integer domainId);

	public List<DOMAIN> findAll();
}
