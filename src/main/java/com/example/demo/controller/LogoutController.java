package com.example.demo.controller;


import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpSession;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController{
	@GetMapping
	public String logout(HttpServletRequest request) {
		// 獲取當前 session，false 表示如果 session 不存在則不創建新的 session
		HttpSession session = request.getSession(false);
		if (session != null) {
            // 使 session 無效，這樣就登出了
            session.invalidate();
        }
		// 重定向到登入頁面
        return "redirect:/login"; // 重定向到登入頁面
	}
}
