package com.plataforma.infrastructure.service.impl;

import com.plataforma.application.vo.producto.ProductoVo;
import com.plataforma.domain.entities.Producto;
import com.plataforma.infrastructure.repository.IProductoRepository;
import com.plataforma.infrastructure.service.IProductoIService;
import com.plataforma.infrastructurecross.util.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductoIService implements IProductoIService{
    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<ProductoVo> getProducto(Long id){
        List<Producto> productoList = productoRepository.selectProducto(id);
        return ObjectMapper.mapAll(productoList, ProductoVo.class);
    }

    @Override
    public List<ProductoVo> getAllProducto() {
        List<Producto> productoList = productoRepository.selectAllProducto();
        return ObjectMapper.mapAll(productoList, ProductoVo.class);
    }

    @Override
    public Long postProducto(ProductoVo productoVo){
        ModelMapper modelMapper = new ModelMapper();
        Producto producto  = (Producto) modelMapper.map(productoVo, (Class)Producto.class);
        producto.setFechaCreacion(LocalDateTime.now());
        producto.setFechaActualizacion(LocalDateTime.now());
        return productoRepository.insertProducto(producto);
    }

    @Override
    public Long putProducto(ProductoVo productoVo){
        ModelMapper modelMapper = new ModelMapper();
        Producto producto  = (Producto) modelMapper.map(productoVo, (Class)Producto.class);
        producto.setFechaActualizacion(LocalDateTime.now());
        return productoRepository.updateProducto(producto);
    }

    @Override
    public Long deleteProducto(Long id) {
        return productoRepository.deleteProducto(id);
    }
}
