package com.plataforma.application.service;

import com.plataforma.application.vo.usuario.UsuarioVo;
import java.util.List;

public interface IUsuarioService{
    List<UsuarioVo> getUsuario(Long id);
    List<UsuarioVo> getAllUsuario();
    Long postUsuario(UsuarioVo usuarioVo);
    Long putUsuario(UsuarioVo usuarioVo);
    Long deleteUsuario(Long id);
}
