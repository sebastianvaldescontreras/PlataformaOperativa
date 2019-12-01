package com.plataforma.application.controller;

import com.plataforma.application.service.IArticuloProductoService;
import com.plataforma.application.vo.articuloproducto.ArticuloProductoRequestVo;
import com.plataforma.application.vo.articuloproducto.ArticuloProductoResponseVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("articuloProducto")
@Api(tags = "Metodos de Articulo Producto", description = "Enlace entre Articulo y Producto Ej: 1 tomate, 1 Palta por Churrasco Italiano")
public class ArticuloProductoController{
    @Autowired
    private IArticuloProductoService articuloProductoService;

    @GetMapping("{id}")
    public ResponseEntity<?> getArticuloProducto(@PathVariable Long id){
        return new ResponseEntity<>(new ArticuloProductoResponseVo(articuloProductoService.getArticuloProducto(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllArticuloProducto(){
        return new ResponseEntity<>(new ArticuloProductoResponseVo(articuloProductoService.getAllArticuloProducto()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postArticuloProducto(@RequestBody ArticuloProductoRequestVo articuloProductoRequestVo){
        return new ResponseEntity<>(articuloProductoService.postArticuloProducto(articuloProductoRequestVo.getArticuloProductoVo()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> putArticuloProducto(@RequestBody ArticuloProductoRequestVo articuloProductoRequestVo){
        return new ResponseEntity<>(articuloProductoService.putArticuloProducto(articuloProductoRequestVo.getArticuloProductoVo()), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteArticuloProducto(@PathVariable Long id){
        return new ResponseEntity<>(articuloProductoService.deleteArticuloProducto(id), HttpStatus.OK);
    }
}
