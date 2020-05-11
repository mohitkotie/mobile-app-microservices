package com.atombot.app.ws.service.imp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atombot.app.ws.UserRepository;
import com.atombot.app.ws.io.entity.UserEntity;
import com.atombot.app.ws.service.UserService;
import com.atombot.app.ws.shared.dto.UserDto;
import com.atombot.app.ws.shared.dto.Utils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
    Utils utils;
	@Override
	public UserDto createUser(UserDto user) {

		UserEntity storedUserDetails = userRepository.findByEmail(user.getEmail());

		if (storedUserDetails != null)
			throw new RuntimeException("Record Already Exits");

		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		String publicUserId = utils.generatedUserId(30);
		userEntity.setEncryptedPassword("test");
		userEntity.setUserId(publicUserId);
		UserEntity storedUserEntity = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserEntity, returnValue);

		return returnValue;
	}

}
