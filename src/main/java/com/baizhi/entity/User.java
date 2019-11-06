package com.baizhi.entity;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String role;//角色
    private String phone;
    private String email;
    private String ip;
    private String form;//来源
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", ip='" + ip + '\'' +
                ", form='" + form + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer id, String username, String password, String role, String phone, String email, String ip, String form, String status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.ip = ip;
        this.form = form;
        this.status = status;
    }

    public User(String username, String password, String role, String phone, String email, String ip, String form, String status) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.ip = ip;
        this.form = form;
        this.status = status;
    }
}
