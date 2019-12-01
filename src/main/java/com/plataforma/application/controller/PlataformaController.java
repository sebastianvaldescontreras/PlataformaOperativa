package com.plataforma.application.controller;

import com.plataforma.application.service.IPlataformaService;
import com.plataforma.application.vo.plataforma.PlataformaRequestVo;
import com.plataforma.application.vo.plataforma.PlataformaResponseVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("plataforma")
@Api(tags = "Metodos de Plataforma", description = "Corresponde a Sangucheria, Verdureria, Carniceria. ")
public class PlataformaController{
    @Autowired
    private IPlataformaService plataformaService;

    @GetMapping("{id}")
    public ResponseEntity<?> getPlataforma(@PathVariable Long id){
        return new ResponseEntity<>(new PlataformaResponseVo(plataformaService.getPlataforma(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllPlataforma(){
        return new ResponseEntity<>(new PlataformaResponseVo(plataformaService.getAllPlataforma()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postPlataforma(@RequestBody PlataformaRequestVo plataformaRequestVo){
        return new ResponseEntity<>(plataformaService.postPlataforma(plataformaRequestVo.getPlataformaVo()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> putPlataforma(@RequestBody PlataformaRequestVo plataformaRequestVo){
        return new ResponseEntity<>(plataformaService.putPlataforma(plataformaRequestVo.getPlataformaVo()), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePlataforma(@PathVariable Long id){
        return new ResponseEntity<>(plataformaService.deletePlataforma(id), HttpStatus.OK);
    }
}
