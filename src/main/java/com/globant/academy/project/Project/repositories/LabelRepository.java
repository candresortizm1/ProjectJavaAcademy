package com.globant.academy.project.Project.repositories;

import com.globant.academy.project.Project.entities.AppMessage;
import com.globant.academy.project.Project.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabelRepository extends JpaRepository<Label,Integer> {
    List<Label> findAllByUserId(Integer id);
}
