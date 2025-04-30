package com.tributino.APIRest.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_teacher")
public class Teacher {

    @Id
    @Size(min = 11, max = 11)
    private String cpf;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "teacher")
    private List<Studant> students;

    @OneToOne(mappedBy = "teacher")
    private ClassStudant classStudant;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne
    private Endereco endereco;
}
