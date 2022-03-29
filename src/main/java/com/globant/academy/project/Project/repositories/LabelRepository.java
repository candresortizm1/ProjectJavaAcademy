package com.globant.academy.project.Project.repositories;

import com.globant.academy.project.Project.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label,Integer> {
}
