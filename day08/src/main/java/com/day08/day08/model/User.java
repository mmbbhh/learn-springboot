package com.day08.day08.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean locked;
    private List<Role> roles;

    @Override
    //获取当前角色具有的信息
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    //获取当前角色密码
    public String getPassword() {
        return password;
    }

    @Override
    //获取当前角色用户名
    public String getUsername() {
        return username;
    }

    @Override
    //判断当前角色是否过期
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    //判断当前角色是否锁定
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    //判断当前角色密码是否过期
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    //判断当前用户是否可用
    public boolean isEnabled() {
        return enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
