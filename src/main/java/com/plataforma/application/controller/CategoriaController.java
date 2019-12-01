package com.plataforma.application.controller;

import com.plataforma.application.service.ICategoriaService;
import com.plataforma.application.vo.categoria.CategoriaRequestVo;
import com.plataforma.application.vo.categoria.CategoriaResponseVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categoria")
@Api(tags = "Metodos de Categoria", description = "Corresponde a Verduras, Frutas, Hortalizas, Bebidas, etc...")
public class CategoriaController{
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("{id}")
    public ResponseEntity<?> getCategoria(@PathVariable Long id){
        return new ResponseEntity<>(new CategoriaResponseVo(categoriaService.getCategoria(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllCategoria(){
        return new ResponseEntity<>(new CategoriaResponseVo(categoriaService.getAllCategoria()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postCategoria(@RequestBody CategoriaRequestVo categoriaRequestVo){
        return new ResponseEntity<>(categoriaService.postCategoria(categoriaRequestVo.getCategoriaVo()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> putCategoria(@RequestBody CategoriaRequestVo categoriaRequestVo){
        return new ResponseEntity<>(categoriaService.putCategoria(categoriaRequestVo.getCategoriaVo()), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Long id){
        return new ResponseEntity<>(categoriaService.deleteCategoria(id), HttpStatus.OK);
    }
}
