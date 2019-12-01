package com.plataforma.infrastructure.repository;

import com.plataforma.domain.entities.Producto;

import java.util.List;

public interface IProductoRepository{
    List<Producto> selectProducto(Long id);
    List<Producto> selectAllProducto();
    Long insertProducto(Producto producto);
    Long updateProducto(Producto producto);
    Long deleteProducto(Long id);
}
