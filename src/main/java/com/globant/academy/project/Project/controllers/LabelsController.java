package com.globant.academy.project.Project.controllers;

import com.globant.academy.project.Project.entities.Label;
import com.globant.academy.project.Project.services.LabelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/{userId}/labels")
public class LabelsController {

    private LabelService labelService;

    /*@PostMapping
    public String createLabel(@PathVariable String userId, @RequestBody Label label){
        labelService.createLabel(userId, label);
        return "Label created";
    }

    @GetMapping
    public String getLabels(@PathVariable String userId, @RequestBody Label label){
        labelService.createLabel(userId, label);
        return "Label created";
    }*/

}
