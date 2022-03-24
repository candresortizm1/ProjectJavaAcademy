package com.globant.academy.project.Project.repositories;

import com.globant.academy.project.Project.entities.MessageAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageAttachmentRepository extends JpaRepository<MessageAttachment,Long> {
}
