package com.carservices.finalproject.repository;

import com.carservices.finalproject.model.AiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AiRepository extends JpaRepository<AiModel,Long> {

}
