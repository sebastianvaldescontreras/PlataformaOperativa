package com.plataforma.application.controller;

import com.plataforma.application.service.impl.VentaService;
import com.plataforma.application.vo.venta.VentaRequestVo;
import com.plataforma.application.vo.venta.VentaResponseVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("venta")
@Api(tags = "Metodos de Venta", description = "Todos los datos de la Venta. ")
public class VentaController{
    @Autowired
    private VentaService ventaService;

    @GetMapping("{id}")
    public ResponseEntity<?> getVenta(@PathVariable Long id){
        return new ResponseEntity<>(new VentaResponseVo(ventaService.getVenta(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllVenta(){
        return new ResponseEntity<>(new VentaResponseVo(ventaService.getAllVenta()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postVenta(@RequestBody VentaRequestVo ventaRequestVo){
        return new ResponseEntity<>(ventaService.postVenta(ventaRequestVo.getVentaVo()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> putVenta(@RequestBody VentaRequestVo ventaRequestVo){
        return new ResponseEntity<>(ventaService.putVenta(ventaRequestVo.getVentaVo()), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteVenta(@PathVariable Long id){
        return new ResponseEntity<>(ventaService.deleteVenta(id), HttpStatus.OK);
    }
}
