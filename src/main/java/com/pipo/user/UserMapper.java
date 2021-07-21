package com.pipo.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	public UserVO getSelectUser(UserVO userVo);
}
