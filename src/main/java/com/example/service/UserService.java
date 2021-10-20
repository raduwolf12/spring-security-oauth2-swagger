package com.example.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.dto.UserDto;
import com.example.model.entity.User;
import com.example.repository.UserRepository;

/**
 * The Class UserService.
 */
@Service
public class UserService extends BaseService<UserDto, User> {

	/** The user repository. */
	@Autowired
	UserRepository userRepository;

	/** The model mapper. */
//	@Autowired
//	ModelMapper modelMapper;

//	/**
//	 * Convert to dto.
//	 *
//	 * @param user the user
//	 * @return the user dto
//	 */
//	private UserDto convertToDto(User user) {
//		UserDto userDto = modelMapper.map(user, UserDto.class);
//		return userDto;
//	}
	
	public UserDto getUserById(Long id) {
		return toDto(userRepository.findById(id).get());
	}

}
