package com.plataforma.infrastructure.repository;

import com.plataforma.domain.entities.Categoria;

import java.util.List;

public interface ICategoriaRepository{
    List<Categoria> selectCategoria(Long id);
    List<Categoria> selectAllCategoria();
    Long insertCategoria(Categoria categoria);
    Long updateCategoria(Categoria categoria);
    Long deleteCategoria(Long id);
}
