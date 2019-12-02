package com.plataforma.application.controller;

import com.plataforma.application.service.impl.VentaProductoService;
import com.plataforma.application.service.impl.VentaService;
import com.plataforma.application.vo.venta.VentaRequestVo;
import com.plataforma.application.vo.venta.VentaResponseVo;
import com.plataforma.application.vo.ventaproducto.VentaProductoRequestVo;
import com.plataforma.application.vo.ventaproducto.VentaProductoResponseVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ventaProducto")
@Api(tags = "Metodos de Venta Producto", description = "Enlace entre Venta por Producto")
public class VentaProductoController{
    @Autowired
    private VentaProductoService ventaProductoService;

    @GetMapping("{id}")
    public ResponseEntity<?> getVenta(@PathVariable Long id){
        return new ResponseEntity<>(new VentaProductoResponseVo(ventaProductoService.getVentaProducto(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllVenta(){
        return new ResponseEntity<>(new VentaProductoResponseVo(ventaProductoService.getAllVentaProducto()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postVenta(@RequestBody VentaProductoRequestVo ventaProductoRequestVo){
        return new ResponseEntity<>(ventaProductoService.postVentaProducto(ventaProductoRequestVo.getVentaProductoVo()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> putVenta(@RequestBody VentaProductoRequestVo ventaProductoRequestVo){
        return new ResponseEntity<>(ventaProductoService.putVentaProducto(ventaProductoRequestVo.getVentaProductoVo()), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteVenta(@PathVariable Long id){
        return new ResponseEntity<>(ventaProductoService.deleteVentaProducto(id), HttpStatus.OK);
    }
}
