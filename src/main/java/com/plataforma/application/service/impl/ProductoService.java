package com.plataforma.application.service.impl;

import com.plataforma.application.service.IProductoService;
import com.plataforma.application.vo.producto.ProductoVo;
import com.plataforma.infrastructure.service.IProductoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoIService productoIService;

    @Override
    public List<ProductoVo> getProducto(Long id){
        return productoIService.getProducto(id);
    }

    @Override
    public List<ProductoVo> getAllProducto() {
        return productoIService.getAllProducto();
    }

    @Override
    public Long postProducto(ProductoVo productoVo){
        return productoIService.postProducto(productoVo);
    }

    @Override
    public Long putProducto(ProductoVo productoVo){
        return productoIService.putProducto(productoVo);
    }

    @Override
    public Long deleteProducto(Long id) {
        return productoIService.deleteProducto(id);
    }
}
