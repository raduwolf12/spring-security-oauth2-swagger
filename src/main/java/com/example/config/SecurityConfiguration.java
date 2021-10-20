//package com.example.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.example.auth.CustomAuthenticationProvider;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	
//	
//	
////	 @Override
////	    protected void configure(HttpSecurity http) throws Exception {
////	        http.authorizeRequests()
////	            .antMatchers("/").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN")
////	            .antMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR")
////	            .antMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
////	            .antMatchers("/delete/**").hasAuthority("ADMIN")
////	            .anyRequest().authenticated()
////	            .and()
////	            .formLogin().permitAll()
////	            .and()
////	            .logout().permitAll()
////	            .and()
////	            .exceptionHandling().accessDeniedPage("/403")
////	            ;
////	    }
//
//	
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	
////        http.authorizeRequests()
////        .antMatchers("/new").hasAnyAuthority("ADMIN")
////        .antMatchers("/eval").hasAnyAuthority("ADMIN", "USER")	
////        .antMatchers("/home").hasAnyAuthority("ADMIN")
////        .antMatchers("/notFound/").hasAnyAuthority()
////        .anyRequest().authenticated()
////            .and()
////            .formLogin().loginPage("/login")
////            .permitAll().successForwardUrl("/index")
////            .and()
////        //  .logout().deleteCookies("JSESSIONID", "JWT").logoutSuccessUrl("/login") .clearAuthentication(true).invalidateHttpSession(true);
////            .logout().permitAll()
////            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////            .logoutSuccessUrl("/login").invalidateHttpSession(true);
//        //  .deleteCookies("auth_code", "JSESSIONID").invalidateHttpSession(true);
//
//        //        .logout().deleteCookies("JSESSIONID", "JWT").logoutSuccessUrl("/index.html") .clearAuthentication(true).invalidateHttpSession(true
//        http.cors().and().csrf().disable();
//    }
//    
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/v2/api-docs",
//                                   "/configuration/ui",
//                                   "/swagger-resources/**",
//                                   "/configuration/security",
//                                   "/swagger-ui.html",
//                                   "/webjars/**");
//    }
//
//	@Autowired
//	private CustomAuthenticationProvider authProvider;
//
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authProvider);
//	}
//
//
//}
