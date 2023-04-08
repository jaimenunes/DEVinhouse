package com.loja.produtos.repository.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "perfil")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Perfil implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Override
    public String getAuthority() {
        return nome;
    }
}
