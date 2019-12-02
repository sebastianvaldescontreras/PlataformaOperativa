package com.plataforma.infrastructure.repository;

import com.plataforma.domain.entities.Usuario;
import java.util.List;

public interface IUsuarioRepository{
    List<Usuario> selectUsuario(Long id);
    List<Usuario> selectAllUsuario();
    Long insertUsuario(Usuario usuario);
    Long updateUsuario(Usuario usuario);
    Long deleteUsuario(Long id);
}
