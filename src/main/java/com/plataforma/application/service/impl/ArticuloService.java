package com.plataforma.application.service.impl;

import com.plataforma.application.service.IArticuloService;
import com.plataforma.application.vo.articulo.ArticuloVo;
import com.plataforma.infrastructure.service.IArticuloIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticuloService implements IArticuloService{

    @Autowired
    private IArticuloIService articuloIService;

    @Override
    public List<ArticuloVo> getArticulo(Long id) {
        return articuloIService.getArticulo(id);
    }

    @Override
    public List<ArticuloVo> getAllArticulo() {
        return articuloIService.getAllArticulo();
    }

    @Override
    public Long postArticulo(ArticuloVo articuloVo) {
        return articuloIService.postArticulo(articuloVo);
    }

    @Override
    public Long putArticulo(ArticuloVo articuloVo) {
        return articuloIService.putArticulo(articuloVo);
    }

    @Override
    public Long deleteArticulo(Long id) {
        return articuloIService.deleteArticulo(id);
    }
}
