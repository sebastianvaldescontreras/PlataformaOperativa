package com.plataforma.application.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
@Api(tags = "Metodos de Usuario", description = "Todos los datos de quien usa el Sistema")
public class UsuarioController {
}
