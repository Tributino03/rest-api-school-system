package com.tributino.apirest.controller;

import com.tributino.apirest.dto.ClassStudantDTO;
import com.tributino.apirest.dto.SchoolDTO;
import com.tributino.apirest.dto.StudantDTO;
import com.tributino.apirest.dto.TeacherDTO;
import com.tributino.apirest.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("{codInep}/students")
    public List<StudantDTO> findStudantsBySchoolId(String codInep){
        return schoolService.findStudantsBySchoolId(codInep);
    }

    @GetMapping("{codInep}/teachers")
    public List<TeacherDTO> findTeacherBySchoolId(String codInep){
        return schoolService.findTeacherBySchoolId(codInep);
    }

    @GetMapping("{codInep}/classStudants")
    public List<ClassStudantDTO> findClassBySchoolId(String codInep){
        return schoolService.findClassBySchoolId(codInep);
    }

    @GetMapping("{codInep}")
    public SchoolDTO FindById(String codInep){
        return schoolService.FindById(codInep);
    }

    @PostMapping
    public SchoolDTO create(SchoolDTO schoolDTO){
        return schoolService.create(schoolDTO);
    }
}
