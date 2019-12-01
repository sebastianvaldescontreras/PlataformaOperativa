package com.plataforma.infrastructure.repository;

import com.plataforma.domain.entities.Plataforma;
import java.util.List;

public interface IPlataformaRepository{
    List<Plataforma> selectPlataforma(Long id);
    List<Plataforma> selectAllPlataforma();
    Long insertPlataforma(Plataforma plataforma);
    Long updatePlataforma(Plataforma plataforma);
    Long deletePlataforma(Long id);
}
