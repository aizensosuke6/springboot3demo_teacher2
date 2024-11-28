package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LoginBean;

@Repository
public interface LoginRepository extends JpaRepository<LoginBean, Integer> {
	// 自定義方法，用於根據 email 和密碼查詢用戶
	LoginBean findByUserEmailAndUserPassword(String userEmail, String userPassword);
}