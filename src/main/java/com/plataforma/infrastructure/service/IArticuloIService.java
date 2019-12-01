package com.plataforma.infrastructure.service;

import com.plataforma.application.vo.articulo.ArticuloVo;

import java.util.List;

public interface IArticuloIService {
    List<ArticuloVo> getArticulo(Long id);
    List<ArticuloVo> getAllArticulo();
    Long postArticulo(ArticuloVo articuloVo);
    Long putArticulo(ArticuloVo articuloVo);
    Long deleteArticulo(Long id);
}
