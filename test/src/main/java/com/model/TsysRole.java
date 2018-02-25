package com.model;

import java.util.Date;

public class TsysRole {
    private Long id;

    private Integer isDel;

    private String menuAuth;

    private String roleDesc;

    private String roleName;

    private Date updateTime;

    private String actionAuth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getMenuAuth() {
        return menuAuth;
    }

    public void setMenuAuth(String menuAuth) {
        this.menuAuth = menuAuth == null ? null : menuAuth.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getActionAuth() {
        return actionAuth;
    }

    public void setActionAuth(String actionAuth) {
        this.actionAuth = actionAuth == null ? null : actionAuth.trim();
    }
}