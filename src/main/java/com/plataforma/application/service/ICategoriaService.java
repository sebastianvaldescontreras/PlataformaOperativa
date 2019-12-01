package com.plataforma.application.service;

import com.plataforma.application.vo.categoria.CategoriaVo;
import java.util.List;

public interface ICategoriaService{
    List<CategoriaVo> getCategoria(Long id);
    List<CategoriaVo> getAllCategoria();
    Long postCategoria(CategoriaVo categoriaVo);
    Long putCategoria(CategoriaVo categoriaVo);
    Long deleteCategoria(Long id);
}
