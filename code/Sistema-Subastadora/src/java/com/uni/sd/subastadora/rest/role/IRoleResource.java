package com.uni.sd.subastadora.rest.role;

import com.uni.sd.subastadora.dto.bid.BidResult;
import com.uni.sd.subastadora.dto.role.RoleDTO;
import com.uni.sd.subastadora.dto.role.RoleResult;
import com.uni.sd.subastadora.rest.base.IBaseResource;

public interface IRoleResource extends IBaseResource<RoleDTO> {
	public RoleResult getAll();
	public RoleResult find(String textToFind, int maxItems, int page);
	public RoleResult find(String textToFind);
}
