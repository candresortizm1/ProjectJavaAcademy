package com.globant.academy.project.Project.repositories;

import com.globant.academy.project.Project.entities.AppMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppMessageRepository extends JpaRepository<AppMessage,Integer> {
    List<AppMessage> findAllBySenderId(Integer id);
}
