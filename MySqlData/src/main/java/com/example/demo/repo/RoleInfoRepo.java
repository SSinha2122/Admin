package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.RoleInfo;

public interface RoleInfoRepo extends JpaRepository<RoleInfo, Integer> {

	List<RoleInfo> findByApplicationApplicationId(int appId);



	
}
