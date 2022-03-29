package com.globant.academy.project.Project.dtos;

import com.globant.academy.project.Project.entities.AppMessage;
import com.globant.academy.project.Project.entities.AppUser;
import com.globant.academy.project.Project.entities.Label;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelMapper {

    public static LabelDTO modelToDTO(Label label){
        LabelDTO labelDTO = LabelDTO.builder()
                .id(label.getId())
                .label(label.getLabel())
                .build();
        return labelDTO;
    }

    public static List<LabelDTO> listModelToDTO(List<Label> labels){
        List<LabelDTO> labelDTOS = (List<LabelDTO>) labels.stream().map(element -> {
            return modelToDTO(element);
        }).toList();
        return labelDTOS;
    }
}
