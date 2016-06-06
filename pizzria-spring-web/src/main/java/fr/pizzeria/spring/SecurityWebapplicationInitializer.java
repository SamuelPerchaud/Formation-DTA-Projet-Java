package fr.pizzeria.spring;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebapplicationInitializer extends AbstractSecurityWebApplicationInitializer {

	public SecurityWebapplicationInitializer() {
		super(SecurityConfig.class);
	}

}
