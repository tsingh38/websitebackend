package com.lastrada.website.lastrada.repository;

import org.springframework.data.repository.CrudRepository;

import com.lastrada.website.lastrada.model.Credentials;
import com.lastrada.website.lastrada.model.WebsiteStatus;



public interface WebsiteStatusRepository extends CrudRepository<WebsiteStatus, Long> {
}
