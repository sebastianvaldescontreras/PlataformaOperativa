package com.plataforma.application.service;

import com.plataforma.application.vo.rol.RolVo;
import java.util.List;

public interface IRolService{
    List<RolVo> getRol(Long id);
    List<RolVo> getAllRol();
    Long postRol(RolVo rolVo);
    Long putRol(RolVo rolVo);
    Long deleteRol(Long id);
}
