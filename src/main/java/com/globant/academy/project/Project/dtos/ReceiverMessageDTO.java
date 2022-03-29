package com.globant.academy.project.Project.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReceiverMessageDTO {
    private int type;
    private UserDTO user;
}
