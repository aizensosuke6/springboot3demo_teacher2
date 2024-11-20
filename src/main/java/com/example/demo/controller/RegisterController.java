package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.RegisterBean;

import com.example.demo.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	// 顯示註冊頁面
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";  // 返回register.html頁面
    }
	
	@PostMapping("/register")
	public String register(	@RequestParam String userAC,
							@RequestParam String password,		
							@RequestParam String username,		
							@RequestParam String userphone,		
							@RequestParam String idCard,		
							@RequestParam String userbirthday) {
	RegisterBean user = new RegisterBean();
	user.setUserAC(userAC);
	user.setPassword(password);
	user.setUsername(username);
	user.setUserphone(userphone);
	user.setIdCard(idCard);
	user.setUserbirthday(userbirthday);
	
	boolean success = registerService.registerUser(user);
	if(success) {
		return "redirect:/login";// 註冊成功後重定向到登入頁面
	}else {
		return "register";// 若註冊失敗，返回註冊頁面
	}
	}
}
