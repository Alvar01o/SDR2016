package com.uni.sd.subastadora.service.base;

import com.uni.sd.subastadora.dao.base.BaseDaoImpl;
import com.uni.sd.subastadora.domain.base.BaseDomain;
import com.uni.sd.subastadora.dto.base.BaseDTO;
import com.uni.sd.subastadora.dto.base.BaseResult;

public interface IBaseService<DTO extends BaseDTO, DOMAIN extends BaseDomain, DAO extends BaseDaoImpl<DOMAIN>, R extends BaseResult<DTO>> {
	public DTO save(DTO dto);

	public DTO getById(Integer id);

	public R getAll();

}
