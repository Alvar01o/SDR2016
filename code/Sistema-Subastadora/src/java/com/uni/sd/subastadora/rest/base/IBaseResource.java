package com.uni.sd.subastadora.rest.base;

import com.uni.sd.subastadora.dto.base.BaseDTO;

public interface IBaseResource<DTO extends BaseDTO> {

	public DTO save(DTO dto);

	public DTO getById(Integer id);

}
