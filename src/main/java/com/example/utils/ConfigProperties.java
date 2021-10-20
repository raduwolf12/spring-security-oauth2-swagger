package com.example.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class ConfigProperties {
	private Security security;

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public class Security {

		private OAuth2 oAuth2;

		public OAuth2 getoAuth2() {
			return oAuth2;
		}

		public void setoAuth2(OAuth2 oAuth2) {
			this.oAuth2 = oAuth2;
		}

		public class OAuth2 {
			private Client client;
			private Jwt jwt;

			public Client getClient() {
				return client;
			}

			public void setClient(Client client) {
				this.client = client;
			}

			public Jwt getJwt() {
				return jwt;
			}

			public void setJwt(Jwt jwt) {
				this.jwt = jwt;
			}

			public class Client {
				private String clientId;
				private String clientSecret;
				private String scope;
				private String clientSecretSwagger;
				private String resourceId;

				public String getClientId() {
					return clientId;
				}

				public void setClientId(String clientId) {
					this.clientId = clientId;
				}

				public String getClientSecret() {
					return clientSecret;
				}

				public void setClientSecret(String clientSecret) {
					this.clientSecret = clientSecret;
				}

				public String getScope() {
					return scope;
				}

				public void setScope(String scope) {
					this.scope = scope;
				}

				public String getClientSecretSwagger() {
					return clientSecretSwagger;
				}

				public void setClientSecretSwagger(String clientSecretSwagger) {
					this.clientSecretSwagger = clientSecretSwagger;
				}

				public String getResourceId() {
					return resourceId;
				}

				public void setResourceId(String resourceId) {
					this.resourceId = resourceId;
				}

			}

			public class Jwt {
				private String keyValue;
				private int accesTokenValiditySeconds;
				private int refreshTokenValiditySeconds;

				public String getKeyValue() {
					return keyValue;
				}

				public void setKeyValue(String keyValue) {
					this.keyValue = keyValue;
				}

				public int getAccesTokenValiditySeconds() {
					return accesTokenValiditySeconds;
				}

				public void setAccesTokenValiditySeconds(int accesTokenValiditySeconds) {
					this.accesTokenValiditySeconds = accesTokenValiditySeconds;
				}

				public int getRefreshTokenValiditySeconds() {
					return refreshTokenValiditySeconds;
				}

				public void setRefreshTokenValiditySeconds(int refreshTokenValiditySeconds) {
					this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
				}

			}

		}

	}

}