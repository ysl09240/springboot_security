package com.slin.authority.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.DefaultWebInvocationPrivilegeEvaluator;

/**
 * 权限配置类
 *
 * @author yangsonglin
 * @create 2018-11-13 13:29
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Autowired
    AuthUserDetailsService authUserDetailsService;

    @Autowired
    MyAccessDeniedHandler myAccessDeniedHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                //其他地址的访问均需验证权限
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")  //指定登录页是"/login"
                .defaultSuccessUrl("/main")  //登录成功后默认跳转到"list"
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")  //退出登录后的默认url是"/home"
                .permitAll()
                .and().csrf().disable()
                .exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);

//        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);

    }

    /**
     * 添加 UserDetailsService， 实现自定义登录校验
     */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(authUserDetailsService).passwordEncoder(new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
//                return Md5Util.MD5(String.valueOf(rawPassword));
                return String.valueOf(rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                return encodedPassword.equals(Md5Util.MD5(String.valueOf(rawPassword)));
                return encodedPassword.equals(String.valueOf(rawPassword));
            }});
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //指定拦截器（解决springSecurity 中为什么 sec:authorize-url 不起作用问题）并解决静态资源被拦截的问题
        web.privilegeEvaluator(new DefaultWebInvocationPrivilegeEvaluator(myFilterSecurityInterceptor)).ignoring().antMatchers("/css/**","/js/**");
    }


}
