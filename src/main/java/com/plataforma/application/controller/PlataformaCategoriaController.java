package com.plataforma.application.controller;

import com.plataforma.application.service.IPlataformaCategoriaService;
import com.plataforma.application.vo.plataformacategoria.PlataformaCategoriaRequestVo;
import com.plataforma.application.vo.plataformacategoria.PlataformaCategoriaResponseVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("plataformaCategoria")
@Api(tags = "Metodos de Plataforma Categoria", description = "Enlace entre Plataforma y Categoria Ej: Sangucheria tiene verduras, frutas, bebidas...")
public class PlataformaCategoriaController{
    @Autowired
    private IPlataformaCategoriaService plataformaCategoriaService;

    @GetMapping("{id}")
    public ResponseEntity<?> getArticuloProducto(@PathVariable Long id){
        return new ResponseEntity<>(new PlataformaCategoriaResponseVo(plataformaCategoriaService.getPlataformaCategoria(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllArticuloProducto(){
        return new ResponseEntity<>(new PlataformaCategoriaResponseVo(plataformaCategoriaService.getAllPlataformaCategoria()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postArticuloProducto(@RequestBody PlataformaCategoriaRequestVo plataformaCategoriaRequestVo){
        return new ResponseEntity<>(plataformaCategoriaService.postPlataformaCategoria(plataformaCategoriaRequestVo.getPlataformaCategoriaVo()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> putArticuloProducto(@RequestBody PlataformaCategoriaRequestVo plataformaCategoriaRequestVo){
        return new ResponseEntity<>(plataformaCategoriaService.putPlataformaCategoria(plataformaCategoriaRequestVo.getPlataformaCategoriaVo()), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteArticuloProducto(@PathVariable Long id){
        return new ResponseEntity<>(plataformaCategoriaService.deletePlataformaCategoria(id), HttpStatus.OK);
    }
}
