package com.loja.produtos.controller.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoAtualizarDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private double preco;
}
