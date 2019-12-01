package com.plataforma.application.service;

import com.plataforma.application.vo.producto.ProductoVo;
import java.util.List;

public interface IProductoService{
    List<ProductoVo> getProducto(Long id);
    List<ProductoVo> getAllProducto();
    Long postProducto(ProductoVo productoVo);
    Long putProducto(ProductoVo productoVo);
    Long deleteProducto(Long id);
}
