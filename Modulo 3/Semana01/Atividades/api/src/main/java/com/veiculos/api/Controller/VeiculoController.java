package com.veiculos.api.Controller;

import com.veiculos.api.Service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;
}
