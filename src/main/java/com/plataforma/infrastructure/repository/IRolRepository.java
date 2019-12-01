package com.plataforma.infrastructure.repository;

import com.plataforma.domain.entities.Rol;
import java.util.List;

public interface IRolRepository{
    List<Rol> selectRol(Long id);
    List<Rol> selectAllRol();
    Long insertRol(Rol rol);
    Long updateRol(Rol rol);
    Long deleteRol(Long id);
}
