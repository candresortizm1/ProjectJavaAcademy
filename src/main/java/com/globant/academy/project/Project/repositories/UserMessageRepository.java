package com.globant.academy.project.Project.repositories;

import com.globant.academy.project.Project.entities.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMessageRepository extends JpaRepository<UserMessage,Long> {
}
