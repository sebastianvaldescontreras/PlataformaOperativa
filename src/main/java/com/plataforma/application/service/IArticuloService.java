package com.plataforma.application.service;

import com.plataforma.application.vo.articulo.ArticuloVo;
import java.util.List;

public interface IArticuloService{
    List<ArticuloVo> getArticulo(Long id);
    List<ArticuloVo> getAllArticulo();
    Long postArticulo(ArticuloVo articuloVo);
    Long putArticulo(ArticuloVo articuloVo);
    Long deleteArticulo(Long id);
}
