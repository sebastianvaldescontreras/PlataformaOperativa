package com.plataforma.application.controller;

import com.plataforma.application.service.IRolService;
import com.plataforma.application.vo.rol.RolRequestVo;
import com.plataforma.application.vo.rol.RolResponseVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rol")
@Api(tags = "Metodos de Rol", description = "Corresponde a Gerente, Jefe, Empleado, etc...")
public class RolController{
    @Autowired
    private IRolService rolService;

    @GetMapping("{id}")
    public ResponseEntity<?> getProducto(@PathVariable Long id){
        return new ResponseEntity<>(new RolResponseVo(rolService.getRol(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducto(){
        return new ResponseEntity<>(new RolResponseVo(rolService.getAllRol()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postProducto(@RequestBody RolRequestVo rolRequestVo){
        return new ResponseEntity<>(rolService.postRol(rolRequestVo.getRolVo()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> putProducto(@RequestBody RolRequestVo rolRequestVo){
        return new ResponseEntity<>(rolService.putRol(rolRequestVo.getRolVo()), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long id){
        return new ResponseEntity<>(rolService.deleteRol(id), HttpStatus.OK);
    }
}
