package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.MatkulMapper;
import com.example.dao.UserMapper;
import com.example.model.MataKuliahModel;
import com.example.model.UserModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceDatabase implements UserService{

	@Autowired
    private UserMapper userMapper;

	@Override
	public UserModel selectUser(String usernameUser) {
		// TODO Auto-generated method stub
		return userMapper.selectUser(usernameUser);
	}
}
