package com.uni.sd.subastadora.service.base;

import com.uni.sd.subastadora.dao.base.BaseDaoImpl;
import com.uni.sd.subastadora.domain.base.BaseDomain;
import com.uni.sd.subastadora.dto.base.BaseDTO;
import com.uni.sd.subastadora.dto.base.BaseResult;

public abstract class BaseServiceImpl<DTO extends BaseDTO, DOMAIN extends BaseDomain, DAO extends BaseDaoImpl<DOMAIN>, RESULT extends BaseResult<DTO>> implements IBaseService<DTO, DOMAIN, DAO, RESULT> {

	protected abstract DTO convertDomainToDto(DOMAIN domain);

	protected abstract DOMAIN convertDtoToDomain(DTO dto);

}
