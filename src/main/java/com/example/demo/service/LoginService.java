package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginBean;
import com.example.demo.repository.LoginRepository;

@Service
public class LoginService {

	
	@Autowired
	private LoginRepository loginRepository;
	
	public LoginBean authenticate(String userAC, String password) {
		// 日誌輸出
	    System.out.println("Authenticating user: " + userAC + " with password: " + password);
	 // 查詢資料庫以驗證用戶
        LoginBean user = loginRepository.findByUserACAndPassword(userAC, password);
        if (user != null) {
            // 如果找到了匹配的用戶，輸出用戶信息
            System.out.println("User found: " + user.getUserAC());
        } else {
            // 如果沒有找到匹配的用戶，輸出錯誤信息
            System.out.println("No user found with userAC: " + userAC);
        }
	
        return user;
	
	}
}
