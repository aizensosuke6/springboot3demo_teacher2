package com.example.demo.model;

public class ResetPasswordRequest {
    private String token;
    private String newPassword;
    

	// Getter 和 Setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    
    
	
}
