package com.tributino.apirest.controller;

import com.tributino.apirest.dto.ClassStudantDTO;
import com.tributino.apirest.dto.StudantDTO;
import com.tributino.apirest.dto.TeacherDTO;
import com.tributino.apirest.service.ClassStudantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/classStudants")
public class ClassStudantController {

    @Autowired
    private ClassStudantService classStudantService;

    @GetMapping("/{id}/students")
    public List<StudantDTO> findStudants(@PathVariable Long id) {
        return classStudantService.findStudantsByClassId(id);
    }

    @GetMapping("/{id}/teacher")
    public TeacherDTO findTeacher(@PathVariable Long id) {
        return classStudantService.findTeacherByClassId(id);
    }

    @PutMapping("/{id}")
    public ClassStudantDTO update(@PathVariable Long id, @RequestBody ClassStudantDTO dto) {
        return classStudantService.update(id, dto);
    }

    @GetMapping("/{id}")
    public ClassStudantDTO findById(Long id){
        return classStudantService.findById(id);
    }

    @PostMapping
    public ClassStudantDTO create(ClassStudantDTO dto){
        return classStudantService.create(dto);
    }
}
