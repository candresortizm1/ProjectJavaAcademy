package com.globant.academy.project.Project.repositories;

import com.globant.academy.project.Project.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
}
