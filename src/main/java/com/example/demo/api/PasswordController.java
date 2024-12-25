package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmailRequest;
import com.example.demo.model.ResetPasswordRequest;
import com.example.demo.service.PasswordResetService;

@RestController
@RequestMapping("/api/password")
public class PasswordController {
    
    @Autowired
    private PasswordResetService passwordResetService;

    // 處理用戶提交忘記密碼請求
    @PostMapping("/forgot")
    public ResponseEntity<String> forgotPassword(@RequestBody EmailRequest emailRequest) {
        boolean emailSent = passwordResetService.sendResetPasswordLink(emailRequest.getEmail());
        if (emailSent) {
            return ResponseEntity.ok("重設密碼連結已發送到您的電子郵箱！");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("該電子郵件未註冊！");
        }
    }
    
    // 處理用戶提交的新密碼請求
    @PutMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        boolean resetSuccessful = passwordResetService.resetPassword(resetPasswordRequest.getToken(), resetPasswordRequest.getNewPassword());
        if (resetSuccessful) {
            return ResponseEntity.ok("密碼重設成功！");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("無效或過期的重設令牌！");
        }
    }
}
