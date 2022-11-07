package com.magadiflo.users.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.magadiflo.users.models.entity.User;

/***
 * Implementando el CRUD completo de forma automática
 * ***************************************************
 * 
 * Para eso se agregó la dependencia: spring-boot-starter-data-rest
 * 
 * La idea es, que en vez de crear un controlador y su clase service, lo podemos
 * hacer con un componente de Spring, que lo que hace es exportar el CRUD
 * Repository a un EndPoint en nuestra API Rest, de forma automática, sin tener
 * que escribir ninguna línea de código del controlador, ni la clase service, es
 * decir nada de como lo trabajamos en el microservicio products.
 *
 * Anotamos con @RepositoryRestResource(path = "users") y en el path le
 * colocamos "users" que será nuestro endpoint donde estarán todos los métodos
 * del crud y otros métodos personalizados.
 * 
 * Debemos agregar el endpoint base en el Api Gateway Zuul Server para este
 * microservicio, tal como se hizo con los products y carts. Quedaría así:
 * 
 * zuul.routes.users.service-id=microservice-users
 * zuul.routes.users.path=/api/users/**
 * 
 * Finalmente, cuando querramos llamar a este endpoint sería:
 * 
 * Path definido en Zuul Server + Path del propio microservicio users
 * 
 * http://localhost:8090/api/users/users
 * 
 * Como resultado del uso de esta dependecia, y al acceder al endpoint anterior,
 * nos mostrará los resultados en un JSON con un formato del estandar HATEOAS
 * (es una restricción de la arquitectura API Rest, es decir, cuando el servidor
 * retorna el JSON, retprma información adicional del recurso, como enlaces que
 * le indican al cliente cómo navegar, como encontrar la información, es como
 * una documentación de cómo podmeos navegar por nuestra api rest, etc...
 * 
 * De forma automática, esta dependencia oculta el ID del user, pero también se
 * puede configurar para poder exponer ese id
 * 
 */

@RepositoryRestResource(path = "users")
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {

	User findByUsername(String username);

}