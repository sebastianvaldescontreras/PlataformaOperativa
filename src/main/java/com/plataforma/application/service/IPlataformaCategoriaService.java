package com.plataforma.application.service;

import com.plataforma.application.vo.plataformacategoria.PlataformaCategoriaVo;

import java.util.List;

public interface IPlataformaCategoriaService{
    List<PlataformaCategoriaVo> getPlataformaCategoria(Long id);
    List<PlataformaCategoriaVo> getAllPlataformaCategoria();
    Long postPlataformaCategoria(PlataformaCategoriaVo articuloVo);
    Long putPlataformaCategoria(PlataformaCategoriaVo articuloVo);
    Long deletePlataformaCategoria(Long id);
}
