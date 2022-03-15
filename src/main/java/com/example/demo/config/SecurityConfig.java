package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.models.Role;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	//UserDetailsService отвечает за аутентификацию(ДЛЯ того чтоб создать кастомных пользователей)
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub
		return new InMemoryUserDetailsManager(User.builder().username("admin").
				password(passwordEncoder().encode("admin"))
				.authorities(Role.ADMIN.getAuthorities()).build(),
				User.builder().username("user")
				.password(passwordEncoder().encode("user"))
				.authorities(Role.USER.getAuthorities()).build());
	}
	
	@Bean
	protected PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(12);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable()
		.authorizeRequests().antMatchers("/").permitAll()
		.anyRequest().authenticated().and().formLogin().loginPage("/auth/login").permitAll().defaultSuccessUrl("/auth/success")
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout","POST")).invalidateHttpSession(true).
		clearAuthentication(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/auth/login");
	}


}
