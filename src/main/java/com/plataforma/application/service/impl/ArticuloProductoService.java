package com.plataforma.application.service.impl;

import com.plataforma.application.service.IArticuloProductoService;
import com.plataforma.application.vo.articuloproducto.ArticuloProductoVo;
import com.plataforma.infrastructure.service.IArticuloProductoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticuloProductoService implements IArticuloProductoService{
    @Autowired
    private IArticuloProductoIService articuloProductoIService;

    @Override
    public List<ArticuloProductoVo> getArticuloProducto(Long id) {
        return articuloProductoIService.getArticuloProducto(id);
    }

    @Override
    public List<ArticuloProductoVo> getAllArticuloProducto() {
        return articuloProductoIService.getAllArticuloProducto();
    }

    @Override
    public Long postArticuloProducto(ArticuloProductoVo articuloProductoVo) {
        return articuloProductoIService.postArticuloProducto(articuloProductoVo);
    }

    @Override
    public Long putArticuloProducto(ArticuloProductoVo articuloProductoVo) {
        return articuloProductoIService.putArticuloProducto(articuloProductoVo);
    }

    @Override
    public Long deleteArticuloProducto(Long id) {
        return articuloProductoIService.deleteArticuloProducto(id);
    }
}
