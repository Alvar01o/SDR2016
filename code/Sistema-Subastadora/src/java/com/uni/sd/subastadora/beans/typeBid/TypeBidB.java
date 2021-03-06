package com.uni.sd.subastadora.beans.typeBid;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.uni.sd.subastadora.beans.base.BaseBean;

public class TypeBidB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _name;

	public TypeBidB(Map<String, String> params) {
		super(params);
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
	}

}
