package com.plataforma.application.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("venta")
@Api(tags = "Metodos de Venta", description = "Todos los datos de la Venta. ")
public class VentaController {
}
