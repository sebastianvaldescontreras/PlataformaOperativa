package com.plataforma.application.controller;

import com.plataforma.application.service.IRolService;
import com.plataforma.application.service.IUsuarioService;
import com.plataforma.application.vo.rol.RolRequestVo;
import com.plataforma.application.vo.rol.RolResponseVo;
import com.plataforma.application.vo.usuario.UsuarioRequestVo;
import com.plataforma.application.vo.usuario.UsuarioResponseVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
@Api(tags = "Metodos de Usuario", description = "Todos los datos de quien usa el Sistema")
public class UsuarioController{
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Long id){
        return new ResponseEntity<>(new UsuarioResponseVo(usuarioService.getUsuario(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsuario(){
        return new ResponseEntity<>(new UsuarioResponseVo(usuarioService.getAllUsuario()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postUsuario(@RequestBody UsuarioRequestVo usuarioRequestVo){
        return new ResponseEntity<>(usuarioService.postUsuario(usuarioRequestVo.getUsuarioVo()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> putUsuario(@RequestBody UsuarioRequestVo usuarioRequestVo){
        return new ResponseEntity<>(usuarioService.putUsuario(usuarioRequestVo.getUsuarioVo()), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id){
        return new ResponseEntity<>(usuarioService.deleteUsuario(id), HttpStatus.OK);
    }
}
