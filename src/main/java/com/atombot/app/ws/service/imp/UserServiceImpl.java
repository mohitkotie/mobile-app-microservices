package com.atombot.app.ws.service.imp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atombot.app.ws.UserRepository;
import com.atombot.app.ws.io.entity.UserEntity;
import com.atombot.app.ws.service.UserService;
import com.atombot.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto user) {

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		userEntity.setEncryptedPassword("test");
		userEntity.setUserId("testUserId");
		UserEntity storedUserEntity = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserEntity, returnValue);

		return returnValue;
	}

}
