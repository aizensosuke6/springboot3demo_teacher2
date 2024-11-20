package com.example.demo.model;

import jakarta.persistence.*;




@Entity
@Table(name = "users")
public class RegisterBean {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userAC")
    private String userAC;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "userphone")
    private String userphone;

    @Column(name = "idCard")
    private String idCard;

    @Column(name = "userbirthday")
    private String userbirthday;
    
 // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAC() {
        return userAC;  // 這裡的 getter 也應該是 userAC
    }

    public void setUserAC(String userAC) {
        this.userAC = userAC;  // 這裡的 setter 也應該是 userAC
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUserbirthday() {
        return userbirthday;
    }

    public void setUserbirthday(String userbirthday) {
        this.userbirthday = userbirthday;
    }
	
	
	
	
}