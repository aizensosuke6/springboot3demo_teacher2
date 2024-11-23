package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginBean;
import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    // 顯示登入頁面
    @GetMapping("/login")
    public String showLoginPage() {
    	
    	
    	return "login";  // 返回login.html頁面
    }

	
 // 用戶登入處理
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestParam String userAC, @RequestParam String password, HttpSession session) {
        // 驗證登入
        LoginBean user = loginService.authenticate(userAC, password);

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
            return ResponseEntity.ok("{\"success\": true, \"username\": \"" + user.getUsername() + "\", \"userEmail\": \"" + user.getUserAC() + "\"}");
        } else {
            return ResponseEntity.ok("{\"success\": false}");
        }
    }
}



    
