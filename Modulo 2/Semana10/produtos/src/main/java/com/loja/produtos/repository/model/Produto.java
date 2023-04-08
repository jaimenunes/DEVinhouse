package com.loja.produtos.repository.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private double preco;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
