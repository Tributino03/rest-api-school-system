package com.tributino.apirest.model;

import jakarta.persistence.*;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_classStudant")
public class ClassStudant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String grade;

    @OneToMany(mappedBy = "classStudant")
    private List<Studant> studantsClass;

    @OneToOne
    @JoinColumn(name = "teacher_cpf")
    private Teacher teacher;

    @OneToOne
    @JoinColumn(name = "school_codInep")
    private School school;
}
