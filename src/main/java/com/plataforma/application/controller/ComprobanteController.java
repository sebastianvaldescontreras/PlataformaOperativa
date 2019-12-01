package com.plataforma.application.controller;

import com.plataforma.application.service.IComprobanteService;
import com.plataforma.application.vo.comprobante.ComprobanteRequestVo;
import com.plataforma.application.vo.comprobante.ComprobanteResponseVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comprobante")
@Api(tags = "Metodos de Comprobante", description = "Manipulacion de Datos de Comprobante")
public class ComprobanteController {
    @Autowired
    private IComprobanteService comprobanteService;

    @GetMapping("{id}")
    public ResponseEntity<?> getComprobante(@PathVariable Long id){
        return new ResponseEntity<>(new ComprobanteResponseVo(comprobanteService.getComprobante(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllComprobante(){
        return new ResponseEntity<>(new ComprobanteResponseVo(comprobanteService.getAllComprobante()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postComprobante(@RequestBody ComprobanteRequestVo comprobanteRequestVo){
        return new ResponseEntity<>(comprobanteService.postComprobante(comprobanteRequestVo.getComprobanteVo()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> putComprobante(@RequestBody ComprobanteRequestVo comprobanteRequestVo){
        return new ResponseEntity<>(comprobanteService.putComprobante(comprobanteRequestVo.getComprobanteVo()), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteComprobante(@PathVariable Long id){
        return new ResponseEntity<>(comprobanteService.deleteComprobante(id), HttpStatus.OK);
    }
}
