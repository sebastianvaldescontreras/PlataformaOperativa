package com.plataforma.application.service.impl;

import com.plataforma.application.service.IUsuarioService;
import com.plataforma.application.vo.rol.RolVo;
import com.plataforma.application.vo.usuario.UsuarioVo;
import com.plataforma.infrastructure.service.IRolIService;
import com.plataforma.infrastructure.service.IUsuarioIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private IUsuarioIService usuarioIService;

    @Override
    public List<UsuarioVo> getUsuario(Long id){
        return usuarioIService.getUsuario(id);
    }

    @Override
    public List<UsuarioVo> getAllUsuario() {
        return usuarioIService.getAllUsuario();
    }

    @Override
    public Long postUsuario(UsuarioVo usuarioVo){
        return usuarioIService.postUsuario(usuarioVo);
    }

    @Override
    public Long putUsuario(UsuarioVo usuarioVo){
        return usuarioIService.putUsuario(usuarioVo);
    }

    @Override
    public Long deleteUsuario(Long id) {
        return usuarioIService.deleteUsuario(id);
    }
}
