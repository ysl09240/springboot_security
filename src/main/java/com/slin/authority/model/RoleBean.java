package com.slin.authority.model;


public class RoleBean {

  private long id;
  private String roleName;
  private String roleEnName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleEnName() {
    return roleEnName;
  }

  public void setRoleEnName(String roleEnName) {
    this.roleEnName = roleEnName;
  }
}
