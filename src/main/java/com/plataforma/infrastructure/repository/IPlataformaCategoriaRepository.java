package com.plataforma.infrastructure.repository;

import com.plataforma.domain.entities.PlataformaCategoria;

import java.util.List;

public interface IPlataformaCategoriaRepository{
    List<PlataformaCategoria> selectPlataformaCategoria(Long id);
    List<PlataformaCategoria> selectAllPlataformaCategoria();
    Long insertPlataformaCategoria(PlataformaCategoria plataformaCategoria);
    Long updatePlataformaCategoria(PlataformaCategoria plataformaCategoria);
    Long deletePlataformaCategoria(Long id);
}
