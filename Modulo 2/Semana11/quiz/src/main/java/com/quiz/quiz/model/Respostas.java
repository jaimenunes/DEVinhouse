package com.quiz.quiz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "repostas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Respostas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String texto;
    @Column(name = "id_pergunta")
    private long idPergunta;
}
