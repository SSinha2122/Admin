package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Integer> {

	List<UserRole> findByApplicationId(Integer applicationId);

	List<UserRole> findByRoleCode(Integer roleCode);

	List<UserRole> findUserByUserName(String userName);
	
}
