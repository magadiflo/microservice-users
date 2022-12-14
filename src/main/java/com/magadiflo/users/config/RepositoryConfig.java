package com.magadiflo.users.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.magadiflo.commons.users.models.entity.User;
import com.magadiflo.commons.users.models.entity.Role;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		config.exposeIdsFor(User.class, Role.class); //Hacemos que los id de las clases User y Role se puedan ver en la respuesta JSON
	}

}
