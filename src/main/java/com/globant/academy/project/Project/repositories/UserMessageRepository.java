package com.globant.academy.project.Project.repositories;

import com.globant.academy.project.Project.entities.ReceiverMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMessageRepository extends JpaRepository<ReceiverMessage,Integer> {
}
