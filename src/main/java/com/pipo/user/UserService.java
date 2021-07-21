package com.pipo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public UserVO getUserLogin(UserVO userVo) {
		return userMapper.getSelectUser(userVo);
	}
}
