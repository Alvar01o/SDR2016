package com.uni.sd.subastadora.services.base;

import java.util.List;

import com.uni.sd.subastadora.beans.base.BaseBean;
import com.uni.sd.subastadora.dto.base.BaseDTO;

public interface IBaseService<BEAN extends BaseBean, DTO extends BaseDTO> {
	public BEAN save(BEAN bean);

	public List<BEAN> getAll();

	public BEAN getById(Integer id);
}
