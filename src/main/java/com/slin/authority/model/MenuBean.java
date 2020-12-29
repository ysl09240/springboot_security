package com.slin.authority.model;


import java.util.List;

public class MenuBean {

  private long menuId;
  private String name;
  private String url;
  private String permission;
  private long pid;

  private List<RoleBean> roles;

  public long getMenuId() {
    return menuId;
  }

  public void setMenuId(long menuId) {
    this.menuId = menuId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }

  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }

  public List<RoleBean> getRoles() {
    return roles;
  }

  public void setRoles(List<RoleBean> roles) {
    this.roles = roles;
  }
}
