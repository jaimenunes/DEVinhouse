package com.minimarket.miniMarket.service;

import com.minimarket.miniMarket.model.Categoria;
import com.minimarket.miniMarket.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public void salvar(Categoria categoria) {
        this.categoriaRepository.save(categoria);
    }
}
