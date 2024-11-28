package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginBean;
import com.example.demo.repository.LoginRepository;

@Service
public class LoginService {

	
	@Autowired
	private LoginRepository loginRepository;
	
	public LoginBean authenticate(String userEmail, String userPassword) {
		// 日誌輸出
	    System.out.println("Authenticating user: " + userEmail + " with password: " + userPassword);
	 // 查詢資料庫以驗證用戶
        LoginBean user = loginRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
        if (user != null) {
            // 如果找到了匹配的用戶，輸出用戶信息
            System.out.println("User found: " + user.getUserEmail());
        } else {
            // 如果沒有找到匹配的用戶，輸出錯誤信息
            System.out.println("No user found with userAC: " + userEmail);
        }
	
        return user;
	
	}
}
