package com.plataforma.infrastructure.repository;

import com.plataforma.domain.entities.Articulo;
import java.util.List;

public interface IArticuloRepository{
    List<Articulo> selectArticulo(Long id);
    List<Articulo> selectAllArticulo();
    Long insertArticulo(Articulo articulo);
    Long updateArticulo(Articulo articulo);
    Long deleteArticulo(Long id);
}
