package com.exam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//	List<UserDetails> users= new ArrayList<>();
//	}
	
	@Autowired
	private UserDetailsService detailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(detailsService);
		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance() );
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		
		.antMatchers("/").permitAll()
		
		
		.antMatchers("/user")
		.hasAuthority("user")
		
		.antMatchers("/admin") //antMatchers means page
		.hasAuthority("admin") //hasAuthority means role
		.anyRequest().authenticated()
		//.and()
		//.httpBasic()
		.and()
		.formLogin()
		.loginPage("/login")
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logout-page").permitAll();
	}

}
