package com.plataforma.application.controller;

import com.plataforma.application.service.IArticuloService;
import com.plataforma.application.vo.articulo.ArticuloRequestVo;
import com.plataforma.application.vo.articulo.ArticuloResponseVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("articulo")
@Api(tags = "Metodos de Articulo", description = "Articulo Ej: tomates, paltas, pan, etc...")
public class ArticuloController{
    @Autowired
    private IArticuloService articuloService;

    @GetMapping("{id}")
    public ResponseEntity<?> getArticulo(@PathVariable Long id){
        return new ResponseEntity<>(new ArticuloResponseVo(articuloService.getArticulo(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllArticulo(){
        return new ResponseEntity<>(new ArticuloResponseVo(articuloService.getAllArticulo()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postArticulo(@RequestBody ArticuloRequestVo articuloRequestVo){
        return new ResponseEntity<>(articuloService.postArticulo(articuloRequestVo.getArticuloVo()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> putArticulo(@RequestBody ArticuloRequestVo articuloRequestVo){
        return new ResponseEntity<>(articuloService.putArticulo(articuloRequestVo.getArticuloVo()), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteArticulo(@PathVariable Long id){
        return new ResponseEntity<>(articuloService.deleteArticulo(id), HttpStatus.OK);
    }
}
