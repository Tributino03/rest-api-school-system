package com.tributino.apirest.controller;

import com.tributino.apirest.dto.StudantDTO;
import com.tributino.apirest.dto.TeacherDTO;
import com.tributino.apirest.model.ClassStudant;
import com.tributino.apirest.model.School;
import com.tributino.apirest.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{cpf}/students")
    public List<StudantDTO> findStudantsByTeacherId(String cpf){
        return teacherService.findStudantsByTeacherId(cpf);
    }

    @GetMapping("/{cpf}/classStudants")
    public ClassStudant findClassByTeacherId(String cpf){
        return teacherService.findClassByTeacherId(cpf);
    }

    @GetMapping("/{cpf}/school")
    public School findSchoolByTeacherId(String cpf){
        return teacherService.findSchoolByTeacherId(cpf);
    }

    @PutMapping
    public TeacherDTO update(String cpf, TeacherDTO dto){
        return teacherService.update(cpf, dto);
    }

    @DeleteMapping
    public TeacherDTO delete(String cpf){
        return teacherService.delete(cpf);
    }

    @GetMapping("{cpf}")
    public TeacherDTO findById(String cpf) {
        return teacherService.findById(cpf);
    }

    @PostMapping
    public TeacherDTO create(TeacherDTO teacherDTO){
        return teacherService.create(teacherDTO);
    }
}
