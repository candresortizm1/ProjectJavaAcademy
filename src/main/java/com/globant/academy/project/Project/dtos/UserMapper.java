package com.globant.academy.project.Project.dtos;

import com.globant.academy.project.Project.entities.AppUser;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public static UserDTO modelToDTO(AppUser user){
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .build();
        return userDTO;
    }
}
