package com.plataforma.application.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ventaProducto")
@Api(tags = "Metodos de Venta Producto", description = "Enlace entre Venta por Producto")
public class VentaProductoController{
}
