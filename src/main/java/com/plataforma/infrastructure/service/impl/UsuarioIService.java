package com.plataforma.infrastructure.service.impl;

import com.plataforma.application.vo.usuario.UsuarioVo;
import com.plataforma.domain.entities.Usuario;
import com.plataforma.infrastructure.repository.IUsuarioRepository;
import com.plataforma.infrastructure.service.IUsuarioIService;
import com.plataforma.infrastructurecross.util.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioIService implements IUsuarioIService{
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioVo> getUsuario(Long id){
        List<Usuario> usuarioList = usuarioRepository.selectUsuario(id);
        return ObjectMapper.mapAll(usuarioList, UsuarioVo.class);
    }

    @Override
    public List<UsuarioVo> getAllUsuario() {
        List<Usuario> usuarioList = usuarioRepository.selectAllUsuario();
        return ObjectMapper.mapAll(usuarioList, UsuarioVo.class);
    }

    @Override
    public Long postUsuario(UsuarioVo usuarioVo){
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario  = (Usuario) modelMapper.map(usuarioVo, (Class)Usuario.class);
        usuario.setFechaCreacion(LocalDateTime.now());
        usuario.setFechaActualizacion(LocalDateTime.now());
        return usuarioRepository.insertUsuario(usuario);
    }

    @Override
    public Long putUsuario(UsuarioVo usuarioVo){
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = (Usuario) modelMapper.map(usuarioVo, (Class)Usuario.class);
        usuario.setFechaActualizacion(LocalDateTime.now());
        return usuarioRepository.updateUsuario(usuario);
    }

    @Override
    public Long deleteUsuario(Long id) {
        return usuarioRepository.deleteUsuario(id);
    }
}
