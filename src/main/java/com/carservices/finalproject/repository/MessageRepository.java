package com.carservices.finalproject.repository;

import com.carservices.finalproject.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Messages,Long> {
}
