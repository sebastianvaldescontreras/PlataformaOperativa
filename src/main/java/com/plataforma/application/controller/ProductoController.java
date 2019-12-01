package com.plataforma.application.controller;

import com.plataforma.application.service.IProductoService;
import com.plataforma.application.vo.producto.ProductoRequestVo;
import com.plataforma.application.vo.producto.ProductoResponseVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producto")
@Api(tags = "Metodos de Producto", description = "Corresponde a Churrasco Italiano, Churrasco Chacarero, Churrasco Barros Luco. ")
public class ProductoController{
    @Autowired
    private IProductoService productoService;

    @GetMapping("{id}")
    public ResponseEntity<?> getProducto(@PathVariable Long id){
        return new ResponseEntity<>(new ProductoResponseVo(productoService.getProducto(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducto(){
        return new ResponseEntity<>(new ProductoResponseVo(productoService.getAllProducto()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postProducto(@RequestBody ProductoRequestVo productoRequestVo){
        return new ResponseEntity<>(productoService.postProducto(productoRequestVo.getProductoVo()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> putProducto(@RequestBody ProductoRequestVo productoRequestVo){
        return new ResponseEntity<>(productoService.putProducto(productoRequestVo.getProductoVo()), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long id){
        return new ResponseEntity<>(productoService.deleteProducto(id), HttpStatus.OK);
    }
}
