package com.plataforma.infrastructure.service;

import com.plataforma.application.vo.categoria.CategoriaVo;
import java.util.List;

public interface ICategoriaIService {
    List<CategoriaVo> getCategoria(Long id);
    List<CategoriaVo> getAllCategoria();
    Long postCategoria(CategoriaVo categoriaVo);
    Long putCategoria(CategoriaVo categoriaVo);
    Long deleteCategoria(Long id);
}
