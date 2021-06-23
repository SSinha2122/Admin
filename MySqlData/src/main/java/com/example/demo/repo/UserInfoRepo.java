package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserInfo;
import com.example.demo.vo.UserInfoVO1;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {

	UserInfo findByEmailId(String emailId);

	UserInfo getUserByUserName(String userName);
	
	UserInfoVO1 findUserByUserName(String userName);
    
}
