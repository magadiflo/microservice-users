package com.magadiflo.users.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

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
 * Hasta ahora, con el endpoint anterior podremos acceder a los métodos CRUD del
 * CrudRepository. Pero, ¿que pasa si queremos acceder al método personalizado
 * que definimos en esta interfaz?, ¿cómo lo hacemos?
 * 
 * Para acceder a los métodos personalizados que definamos en esta interfaz,
 * debemos acceder al mismo endpoint anterior concatenando el /search:
 * 
 * .../search/findByUsername?username=magadiflo, donde findByUsername, es el
 * nombre del método personalizado, seguida del nombre de los parámetros y su
 * valor, quedando así:
 * 
 * http://localhost:8090/api/users/users/search/findByUsername?username=magadiflo
 * 
 * Ahora, si queremos darle otro nombre al nombre del método y a los parámetros
 * lo haríamos anotando el método personalizado con @RestResource y el @Param,
 * tal como se ve en el método findByUsername, finalmente el nuevo endpoint
 * quedaría:
 * 
 * http://localhost:8090/api/users/users/search/find-username?user=magadiflo
 */

@RepositoryRestResource(path = "users")
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {

	@RestResource(path = "find-username")
	User findByUsername(@Param(value = "user") String username);

}