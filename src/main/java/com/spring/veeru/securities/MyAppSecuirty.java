package com.spring.veeru.securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.veeru.service.MyUserDetailsService;

/**
 * @author virupaksha.kuruva
 *
 */
@EnableWebSecurity
@Configuration
public class MyAppSecuirty extends WebSecurityConfigurerAdapter{

	
	 
	@Autowired
	MyUserDetailsService userDetailsService;
	
/*	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("veeru").password(passwordEncoder().encode("veeru123"))
          .authorities("ROLE_USER");
    }*/
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
	
	 @Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
	
		 httpSecurity.authorizeRequests()
								 .antMatchers("/employee/save").hasRole("ADMIN")
								 .antMatchers("/employee/update").hasRole("ADMIN")
								 .antMatchers("/employee/delete").hasRole("ADMIN")
								 .antMatchers("/employee/get").hasAnyRole("USER","ADMIN")
								 .and().authorizeRequests().antMatchers("/h2-console/**").permitAll()
								 .and().httpBasic();
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
	}
	
	
	/* @Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/employee").permitAll()
			  .and().authorizeRequests().antMatchers("/h2-console/**").permitAll()
			  .anyRequest().authenticated()
			  .and()
	          .httpBasic();
	         // .authenticationEntryPoint(authenticationEntryPoint);

	        http.addFilterAfter(new CustomFilter(),
	          BasicAuthenticationFilter.class);

		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
	}*/
	 
	 
	 	@Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
}
