package com.plataforma.infrastructure.repository;

import com.plataforma.domain.entities.ArticuloProducto;

import java.util.List;

public interface IArticuloProductoRepository {
    List<ArticuloProducto> selectArticuloProducto(Long id);
    List<ArticuloProducto> selectAllArticuloProducto();
    Long insertArticuloProducto(ArticuloProducto articuloProducto);
    Long updateArticuloProducto(ArticuloProducto articuloProducto);
    Long deleteArticuloProducto(Long id);
}
