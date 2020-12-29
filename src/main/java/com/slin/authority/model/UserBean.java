package com.slin.authority.model;

import java.util.List;

public class UserBean {

  private long userId;
  private String name;
  private String password;
  private String phone;
  private List<RoleBean> roles;

  public UserBean(){}



  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public List<RoleBean> getRoles() {
    return roles;
  }

  public void setRoles(List<RoleBean> roles) {
    this.roles = roles;
  }
}
