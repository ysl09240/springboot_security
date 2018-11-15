package com.slin.authority.model;

import java.util.List;

public class UserBean {

  private long id;
  private String name;
  private String password;
  private long age;
  private List<RoleBean> roles;

  public UserBean(){}
  public UserBean(String name,long age){
    this.name = name;
    this.age = age;
    this.password = "1111111";
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }

  public List<RoleBean> getRoles() {
    return roles;
  }

  public void setRoles(List<RoleBean> roles) {
    this.roles = roles;
  }
}
