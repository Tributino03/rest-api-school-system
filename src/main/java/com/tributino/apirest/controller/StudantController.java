package com.tributino.apirest.controller;

import com.tributino.apirest.dto.ClassStudantDTO;
import com.tributino.apirest.dto.SchoolDTO;
import com.tributino.apirest.dto.StudantDTO;
import com.tributino.apirest.dto.TeacherDTO;
import com.tributino.apirest.model.Studant;
import com.tributino.apirest.service.StudantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudantController {

    @Autowired
    private StudantService studantService;

    @GetMapping("/{ra}/classStudants")
    public ClassStudantDTO findClassByStudantId(String ra){
        return studantService.findClassByStudantId(ra);
    }

    @GetMapping("/{ra}/teachers")
    public TeacherDTO findTeacherByStudantId(String ra){
        return studantService.findTeacherByStudantId(ra);
    }

    @GetMapping("/{ra}/school")
    public SchoolDTO findSchoolByStudantId(String ra){
        return studantService.findSchoolByStudantId(ra);
    }

    @PutMapping
    public StudantDTO update(String ra, Studant studant) {
        return studantService.update(ra, studant);
    }

    @DeleteMapping
    public StudantDTO delete(String ra){
        return studantService.delete(ra);
    }

    @GetMapping("{ra}")
    public StudantDTO findById(String ra){
        return studantService.findById(ra);
    }

    @PostMapping
    public StudantDTO create(StudantDTO studantDTO){
        return studantService.create(studantDTO);
    }

}
