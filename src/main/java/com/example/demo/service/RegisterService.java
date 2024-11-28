package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.RegisterBean;
import com.example.demo.repository.RegisterRepository;

@Service
public class RegisterService {

	@Autowired
	private RegisterRepository registerRepository;
	
	public boolean registerUser(RegisterBean user) {
		// 資料驗證（簡單檢查空值）
		if(user.getUserEmail() == null || user.getUserEmail().isEmpty() ||
				user.getUserEmail() == null || user.getUserEmail().isEmpty() ||
				user.getUserPassword() == null || user.getUserPassword().isEmpty() ||
				user.getUserName() == null || user.getUserName().isEmpty() ||
				user.getUserTel() == null || user.getUserTel().isEmpty() ||
				user.getUserIdNumber() == null || user.getUserIdNumber().isEmpty() ||
				user.getUserBirthday() ==null || user.getUserBirthday().isEmpty()) {
				System.out.println("資料有空值，無法註冊。");
				return false;
		}
				
		// 使用 save() 方法將註冊資料儲存到資料庫
		registerRepository.save(user);
		return true;
				
				
	}
	









}