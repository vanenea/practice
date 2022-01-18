package com.chen.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 将用户设置在内存中
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void config(AuthenticationManagerBuilder auth) throws Exception {
        // 在内存中配置用户，配置多个用户调用`and()`方法
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder()) // 指定加密方式
                .withUser("admin").password(passwordEncoder().encode("123456")).authorities("r1")
                .and()
                .withUser("test").password(passwordEncoder().encode("123456")).roles("USER");
    }
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("zhangsan").password(passwordEncoder().encode("123")).authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password(passwordEncoder().encode("456")).authorities("p2").build());
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder：Spring Security 提供的加密工具，可快速实现加密加盐
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/r/r1").hasAuthority("r1") //访问 r/r1需要有r1权限
                .antMatchers("/r/**").authenticated() // 拦截 /r/** 请求
                .anyRequest().permitAll()   //除了 /r/** 其他都通过
                .and()
                .formLogin();//允许表单登录

    }
}
