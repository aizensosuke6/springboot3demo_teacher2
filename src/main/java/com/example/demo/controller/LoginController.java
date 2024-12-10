package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.demo.model.LoginBean;
import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    // 顯示登入頁面，重定向邏輯。
    @GetMapping("/login")
    public String showLoginPage(HttpSession session) {
    	// 檢查 session 中是否有 user 資料，表示用戶已經登入
    	if(session.getAttribute("user") != null) {
    		// 如果已經登入，重定向到首頁（或其他頁面）
    		return "redirect:/memberCenter";// 可以根據需求修改重定向的頁面
    	}
    	
    	// 如果沒有登入，顯示登入頁面
    	return "login";  // 返回login.html頁面
    }

	
 // 用戶登入處理
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestParam String userEmail, @RequestParam String userPassword, HttpSession session) {
        // 驗證登入
        LoginBean user = loginService.authenticate(userEmail, userPassword);

        if (user != null) {
        	// 登入成功，將用戶信息放入 session
            session.setAttribute("user", user);
            return ResponseEntity.ok("success");  // 登入成功
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("failure");  // 登入失敗
        }
    }
    
 // 顯示會員中心頁面
    @GetMapping("/memberCenter")
    public String showMemberCenterPage() {
        return "MemberCenter";  // 返回 MemberCenter.html 頁面
    }
    
 // 獲取用戶資訊
    @GetMapping("/getUserInfo")
    @ResponseBody
    public ResponseEntity<String> getUserInfo(HttpSession session) {
        LoginBean user = (LoginBean) session.getAttribute("user");
        if (user != null) {
            return ResponseEntity.ok("{\"success\": true, \"username\": \"" + user.getUserName() + "\", \"userEmail\": \"" + user.getUserEmail() + "\"}");
        } else {
            return ResponseEntity.ok("{\"success\": false}");
        }
    }
    
    //登出
    @GetMapping("/logout")
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



    
