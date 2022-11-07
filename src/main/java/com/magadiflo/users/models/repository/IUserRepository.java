package com.magadiflo.users.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.magadiflo.users.models.entity.User;

public interface IUserRepository extends PagingAndSortingRepository<User, Long> {

	User findByUsername(String username);

}
