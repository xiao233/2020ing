package com.xiao.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置安全管理
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

    @Override
    protected UserDetailsService userDetailsService(){
        return nMemoryUserDetailsManager();
    }

    /**
     * 在内存中添加用户信息
     * @return
     */
    public InMemoryUserDetailsManager  nMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager( User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN", "USER", "ACTUATOR").build(),
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("user")
                        .roles("USER").build());
    }

    /**
     * 获取授权用户
     */
    public Authentication getAuthentication(){
       return  SecurityContextHolder.getContext().getAuthentication();

    }
    /**
     * 获取当前用户角色名称
     * @return
     */
    public  String getAuthenticationName(){

        return getAuthentication().getName();
    }

    /**
     * 获取当前角色组
     * @return
     */
    public List<String> getRoles(){
        List<String> roles = new ArrayList<String>();

        for (Object obj: getAuthentication().getAuthorities()) {
            GrantedAuthority g = (GrantedAuthority)obj;
            roles.add(g.getAuthority());
        }
        return roles;
    }

    /**
     * 校验当前用户是否存在此角色
     * @param role
     * @return
     */
    public boolean checkRole(String role){

        for (Object obj: getAuthentication().getAuthorities()) {
            GrantedAuthority g = (GrantedAuthority)obj;
            if(g.getAuthority().equals(role)){
                return true;
            }
        }
        return false;
    }
}
