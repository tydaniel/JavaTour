package net.tydaniel.libsysmybaits.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import net.tydaniel.libsysmybaits.mapper.UserMapper;
import net.tydaniel.libsysmybaits.model.User;
import net.tydaniel.libsysmybaits.services.IUserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	@Autowired
    private UserMapper userMapper;

	@Override
	public List<User> selectAllUsers() {		
		List<User> userList = userMapper.selectAllUsers();
		return userList;
	}

	@Override
	public void insertByObj(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User selectUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateByObj(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePwdByUserId(Long userId, String md5Hex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		
	}

	


}
