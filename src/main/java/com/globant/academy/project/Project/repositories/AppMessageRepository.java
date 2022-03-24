package com.globant.academy.project.Project.repositories;

import com.globant.academy.project.Project.entities.AppMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppMessageRepository extends JpaRepository<AppMessage,Long> {
}
