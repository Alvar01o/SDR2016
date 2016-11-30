package com.uni.sd.subastadora.services.base;


import com.uni.sd.subastadora.beans.base.BaseBean;
import com.uni.sd.subastadora.dto.base.BaseDTO;

public abstract class BaseServiceImpl<BEAN extends BaseBean, DTO extends BaseDTO> implements IBaseService<BEAN, DTO> {

	public BaseServiceImpl() {

	}

	protected abstract BEAN convertDtoToBean(DTO dto);

	protected abstract DTO convertBeanToDto(BEAN bean);

}
