package com.lastrada.website.lastrada.repository;

import org.springframework.data.repository.CrudRepository;

import com.lastrada.website.lastrada.model.Credentials;
import com.lastrada.website.lastrada.model.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Long> {
}
