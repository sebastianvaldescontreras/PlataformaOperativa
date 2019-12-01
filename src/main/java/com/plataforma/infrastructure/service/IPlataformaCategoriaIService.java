package com.plataforma.infrastructure.service;

import com.plataforma.application.vo.plataformacategoria.PlataformaCategoriaVo;

import java.util.List;

public interface IPlataformaCategoriaIService{
    List<PlataformaCategoriaVo> getPlataformaCategoria(Long id);
    List<PlataformaCategoriaVo> getAllPlataformaCategoria();
    Long postPlataformaCategoria(PlataformaCategoriaVo plataformaCategoriaVo);
    Long putPlataformaCategoria(PlataformaCategoriaVo plataformaCategoriaVo);
    Long deletePlataformaCategoria(Long id);
}
