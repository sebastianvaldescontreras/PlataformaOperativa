package com.plataforma.infrastructure.service.impl;

import com.plataforma.application.vo.rol.RolVo;
import com.plataforma.domain.entities.Rol;
import com.plataforma.infrastructure.repository.IRolRepository;
import com.plataforma.infrastructure.service.IRolIService;
import com.plataforma.infrastructurecross.util.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RolIService implements IRolIService {
    @Autowired
    private IRolRepository rolRepository;

    @Override
    public List<RolVo> getRol(Long id){
        List<Rol> rolList = rolRepository.selectRol(id);
        return ObjectMapper.mapAll(rolList, RolVo.class);
    }

    @Override
    public List<RolVo> getAllRol() {
        List<Rol> rolList = rolRepository.selectAllRol();
        return ObjectMapper.mapAll(rolList, RolVo.class);
    }

    @Override
    public Long postRol(RolVo rolVo){
        ModelMapper modelMapper = new ModelMapper();
        Rol rol  = (Rol) modelMapper.map(rolVo, (Class)Rol.class);
        rol.setFechaCreacion(LocalDateTime.now());
        rol.setFechaActualizacion(LocalDateTime.now());
        return rolRepository.insertRol(rol);
    }

    @Override
    public Long putRol(RolVo rolVo){
        ModelMapper modelMapper = new ModelMapper();
        Rol rol = (Rol) modelMapper.map(rolVo, (Class)Rol.class);
        rol.setFechaActualizacion(LocalDateTime.now());
        return rolRepository.updateRol(rol);
    }

    @Override
    public Long deleteRol(Long id) {
        return rolRepository.deleteRol(id);
    }
}
