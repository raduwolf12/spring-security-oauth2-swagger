package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.auth.CustomAuthenticationProvider;
import com.example.service.AuthorizationService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthorizationService userDetailsService;

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//				.authorizeRequests().antMatchers("/oauth/token").permitAll().anyRequest().authenticated().and()
//				.authorizeRequests().antMatchers(HttpMethod.GET, "/user").hasRole("ADMIN");
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
//		http.authorizeRequests().antMatchers("/oauth/token").permitAll().anyRequest().authenticated().and()
//		.authorizeRequests().antMatchers(HttpMethod.GET, "/user").hasRole("ADMIN");
		http
        .httpBasic()
            .and()
        .authorizeRequests()
            .antMatchers("/oauth/token").permitAll()
            .and()
        .authorizeRequests()
            .antMatchers("/secure/**").hasAnyRole("ADMIN")
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
				"/configuration/security", "/swagger-ui.html", "/webjars/**");
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setPasswordEncoder(bCryptPasswordEncoder());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}

//	@Autowired
//    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//        .withUser("bill").password("abc123").roles("ADMIN").and()
//        .withUser("bob").password("abc123").roles("USER");
//    }

//	@Autowired
//	private CustomAuthenticationProvider authProvider;
//
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authProvider);
//	}
	
//	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
}
