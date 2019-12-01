package com.plataforma.application.service.impl;

import com.plataforma.application.service.IRolService;
import com.plataforma.application.vo.rol.RolVo;
import com.plataforma.infrastructure.service.IRolIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolService implements IRolService{
    @Autowired
    private IRolIService rolIService;

    @Override
    public List<RolVo> getRol(Long id){
        return rolIService.getRol(id);
    }

    @Override
    public List<RolVo> getAllRol() {
        return rolIService.getAllRol();
    }

    @Override
    public Long postRol(RolVo rolVo){
        return rolIService.postRol(rolVo);
    }

    @Override
    public Long putRol(RolVo rolVo){
        return rolIService.putRol(rolVo);
    }

    @Override
    public Long deleteRol(Long id) {
        return rolIService.deleteRol(id);
    }
}
