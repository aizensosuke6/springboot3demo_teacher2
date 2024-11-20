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
		if(user.getUserAC() == null || user.getUserAC().isEmpty() ||
				user.getUserAC() == null || user.getUserAC().isEmpty() ||
				user.getPassword() == null || user.getPassword().isEmpty() ||
				user.getUsername() == null || user.getUsername().isEmpty() ||
				user.getUserphone() == null || user.getUserphone().isEmpty() ||
				user.getIdCard() == null || user.getIdCard().isEmpty() ||
				user.getUserbirthday() ==null || user.getUserbirthday().isEmpty()) {
				System.out.println("資料有空值，無法註冊。");
				return false;
		}
				
		// 使用 save() 方法將註冊資料儲存到資料庫
		registerRepository.save(user);
		return true;
				
				
	}
	









}