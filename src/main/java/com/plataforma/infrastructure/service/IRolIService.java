package com.plataforma.infrastructure.service;

import com.plataforma.application.vo.rol.RolVo;
import java.util.List;

public interface IRolIService{
    List<RolVo> getRol(Long id);
    List<RolVo> getAllRol();
    Long postRol(RolVo rolVo);
    Long putRol(RolVo rolVo);
    Long deleteRol(Long id);
}
