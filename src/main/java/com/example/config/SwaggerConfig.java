package com.example.config;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.utils.ConfigProperties;
import com.example.validation.customError.ErrorInfo;
import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Autowired
	private ConfigProperties properties;

//	@Bean
//	public Docket api(TypeResolver typeResolver) {
//		java.util.List<ResponseMessage> lista = new ArrayList<>();
//		lista.add(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("ErrorInfo"))
//				.build());
//
//		Docket docket = new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).build();
//		docket.apiInfo(apiInfo());
//		for (RequestMethod method : RequestMethod.values()) {
//			docket.globalResponseMessage(method, lista);
//		}
//		docket.additionalModels(typeResolver.resolve(ErrorInfo.class));
//
//		return docket;
//	}

	@Bean
	public Docket api(TypeResolver typeResolver) {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(true).select().paths(paths())
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build()
				.securitySchemes(securitySchema()).securityContexts(securityContext()).pathMapping("/")
				.useDefaultResponseMessages(false);
		docket.additionalModels(typeResolver.resolve(ErrorInfo.class));
		docket.ignoredParameterTypes(Principal.class);
		docket.apiInfo(apiInfo());
		return docket;
	}

	private List<SecurityContext> securityContext() {
		final AuthorizationScope[] authorizationScopes = new AuthorizationScope[0];
		return Collections.singletonList(SecurityContext.builder()
				.securityReferences(Collections.singletonList(new SecurityReference("apiKey", authorizationScopes)))
				.forPaths(PathSelectors.regex("/.*")).build());
	}

	private List<OAuth> securitySchema() {
		return Collections.singletonList(new OAuth("apiKey", new ArrayList<>(),
				Collections.singletonList(new ResourceOwnerPasswordCredentialsGrant("/oauth/token"))));
	}

	private Predicate<String> paths() {
		return Predicates.not(PathSelectors.regex("/oauth.*[^/token].*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("My REST API", "Some custom description of API.", "API TOS", "Terms of service",
				new Contact("John Doe", "www.example.com", "myeaddress@company.com"), "License of API",
				"API license URL", Collections.emptyList());
	}

	@Value("${security.oauth2.client.clientId}")
	private String clientId;
	@Value("${security.oauth2.client.clientSecretSwagger}")
	private String clientSecret;

//	@Bean
//	public springfox.documentation.swagger.web.SecurityConfiguration securityInfo() {
//		return new springfox.documentation.swagger.web.SecurityConfiguration(clientId, clientSecret, "", "", "", ApiKeyVehicle.HEADER, "", " ");
//	}
	@Bean
	public springfox.documentation.swagger.web.SecurityConfiguration securityInfo() {

		return SecurityConfigurationBuilder.builder().clientId(clientId)
				.clientSecret(clientSecret).realm(null).appName("Tempalte").scopeSeparator(",")
				.additionalQueryStringParams(null).useBasicAuthenticationWithAccessCodeGrant(false).build();
	}
	
	
//	@Bean
//	public springfox.documentation.swagger.web.SecurityConfiguration securityInfo() {
//		Client client = properties.getSecurity().getoAuth2().getClient();
//		return SecurityConfigurationBuilder.builder().clientId(client.getClientId())
//				.clientSecret(client.getClientSecretSwagger()).realm(null).appName("Tempalte").scopeSeparator(",")
//				.additionalQueryStringParams(null).useBasicAuthenticationWithAccessCodeGrant(false).build();
//	}

}