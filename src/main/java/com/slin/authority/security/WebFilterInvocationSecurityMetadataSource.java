package com.slin.authority.security;

import com.slin.authority.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 权限资源获取方式
 *
 * @author yangsonglin
 * @create 2018-11-13 13:36
 **/
@Component
public class WebFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    private IUserService userService;
    private static Map<String,String> urlRoleMap = new HashMap<String,String>(){{
        put("/user","ADMIN,DBA");
        put("/user/list","ADMIN,DBA");
        put("/user/rolelist","ADMIN,DBA");
        put("/store","USER");
    }};
    public WebFilterInvocationSecurityMetadataSource(){
        if(urlRoleMap!=null){

        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
//        String httpMethod = fi.getRequest().getMethod();


        for(Map.Entry<String,String> entry:urlRoleMap.entrySet()){
            if(antPathMatcher.match(entry.getKey(),url)){
                return SecurityConfig.createList(entry.getValue().split(","));
            }
        }
        //没有匹配到,默认是要登录才能访问
//        return SecurityConfig.createList("ROLE_USER");
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
