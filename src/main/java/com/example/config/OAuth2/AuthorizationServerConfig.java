//package com.example.config.OAuth2;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//
//import com.example.utils.ConfigProperties;
//import com.example.utils.ConfigProperties.Security.OAuth2.Client;
//import com.example.utils.ConfigProperties.Security.OAuth2.Jwt;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//	@Autowired
//	private ConfigProperties properties;
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@SuppressWarnings("deprecation")
//	@Bean
//	public JwtAccessTokenConverter accessTokenConverter() {
//		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//		converter.setSigningKey(properties.getSecurity().getoAuth2().getJwt().getKeyValue());
//		return converter;
//	}
//
//	@SuppressWarnings("deprecation")
//	@Bean
//	public TokenStore tokenStore() {
//		return new JwtTokenStore(accessTokenConverter());
//	}
//
//	@SuppressWarnings("deprecation")
//	public void cofigure(ClientDetailsServiceConfigurer configurer) throws Exception {
//		Client client = properties.getSecurity().getoAuth2().getClient();
//		Jwt jwt = properties.getSecurity().getoAuth2().getJwt();
//
//		configurer.inMemory().withClient(client.getClientId()).secret(client.getClientSecret())
//				.scopes(client.getScope().replaceAll("\\s*", "").split(","))
//				.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//				.accessTokenValiditySeconds(jwt.getAccesTokenValiditySeconds())
//				.refreshTokenValiditySeconds(jwt.getRefreshTokenValiditySeconds());
//
//	}
//
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager)
//				.accessTokenConverter(accessTokenConverter()).userDetailsService(userDetailsService);
//	}
//}
