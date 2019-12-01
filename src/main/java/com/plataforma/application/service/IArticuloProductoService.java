package com.plataforma.application.service;

import com.plataforma.application.vo.articuloproducto.ArticuloProductoVo;

import java.util.List;

public interface IArticuloProductoService{
    List<ArticuloProductoVo> getArticuloProducto(Long id);
    List<ArticuloProductoVo> getAllArticuloProducto();
    Long postArticuloProducto(ArticuloProductoVo articuloProductoVo);
    Long putArticuloProducto(ArticuloProductoVo articuloProductoVo);
    Long deleteArticuloProducto(Long id);
}
