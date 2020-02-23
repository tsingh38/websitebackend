package com.lastrada.website.lastrada.repository;

import org.springframework.data.repository.CrudRepository;

import com.lastrada.website.lastrada.model.Credentials;



public interface CredentialsRepository extends CrudRepository<Credentials, Long> {
Credentials findByUsername(String username);
}
