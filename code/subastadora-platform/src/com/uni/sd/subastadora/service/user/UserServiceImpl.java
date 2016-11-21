package com.uni.sd.subastadora.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uni.sd.subastadora.dao.user.UserDaoImpl;
import com.uni.sd.subastadora.dao.user.IUserDao;
import com.uni.sd.subastadora.domain.user.UserDomain;
import com.uni.sd.subastadora.dto.user.UserDTO;
import com.uni.sd.subastadora.dto.user.UserResult;
import com.uni.sd.subastadora.service.base.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDomain, UserDaoImpl, UserResult>
		implements IUserService {
	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		final UserDomain domain = convertDtoToDomain(dto);
		final UserDomain userDomain = userDao.save(domain);
		return convertDomainToDto(userDomain);
	}

	@Override
	@Transactional
	public UserDTO getById(Integer id) {
		final UserDomain domain = userDao.getById(id);
		final UserDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public UserResult getAll() {
		final List<UserDTO> countries = new ArrayList<>();
		for (UserDomain domain : userDao.findAll()) {
			final UserDTO dto = convertDomainToDto(domain);
			countries.add(dto);
		}
		final UserResult userResult = new UserResult();
		userResult.setCountries(countries);
		return userResult;
	}

	@Override
	@Transactional
	public UserResult find(String textToFind) {
		final List<UserDTO> countries = new ArrayList<>();
		for (UserDomain domain : userDao.find(textToFind)) {
			final UserDTO dto = convertDomainToDto(domain);
			countries.add(dto);
		}
		final UserResult userResult = new UserResult();
		userResult.setCountries(countries);
		return userResult;
	}

	@Override
	protected UserDTO convertDomainToDto(UserDomain domain) {
		final UserDTO dto = new UserDTO();
		dto.setId(domain.getId());
		dto.setName(domain.getName());
		dto.setLastName(domain.getLastName());
		dto.setEmail(domain.getEmail());
		dto.setUserName(domain.getUserName());
		dto.setAddress(domain.getaddress());
		return dto;
	}

	@Override
	protected UserDomain convertDtoToDomain(UserDTO dto) {
		final UserDomain domain = new UserDomain();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		domain.setLastName(dto.getLastName());
		domain.setEmail(dto.getEmail());
		domain.setUserName(dto.getUserName());
		domain.setAddress(dto.getaddress());
		return domain;
	}

}
