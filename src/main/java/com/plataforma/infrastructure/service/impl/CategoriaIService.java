package com.plataforma.infrastructure.service.impl;

import com.plataforma.application.vo.categoria.CategoriaVo;
import com.plataforma.domain.entities.Categoria;
import com.plataforma.infrastructure.repository.ICategoriaRepository;
import com.plataforma.infrastructure.service.ICategoriaIService;
import com.plataforma.infrastructurecross.util.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoriaIService implements ICategoriaIService{
    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaVo> getCategoria(Long id){
        List<Categoria> categoriaList = categoriaRepository.selectCategoria(id);
        return ObjectMapper.mapAll(categoriaList, CategoriaVo.class);
    }

    @Override
    public List<CategoriaVo> getAllCategoria() {
        List<Categoria> categoriaList = categoriaRepository.selectAllCategoria();
        return ObjectMapper.mapAll(categoriaList, CategoriaVo.class);
    }

    @Override
    public Long postCategoria(CategoriaVo categoriaVo){
        ModelMapper modelMapper = new ModelMapper();
        Categoria articulo  = (Categoria) modelMapper.map(categoriaVo, (Class) Categoria.class);
        articulo.setFechaCreacion(LocalDateTime.now());
        articulo.setFechaActualizacion(LocalDateTime.now());
        return categoriaRepository.insertCategoria(articulo);
    }

    @Override
    public Long putCategoria(CategoriaVo categoriaVo){
        ModelMapper modelMapper = new ModelMapper();
        Categoria categoria  = (Categoria) modelMapper.map(categoriaVo, (Class)Categoria.class);
        categoria.setFechaActualizacion(LocalDateTime.now());
        return categoriaRepository.updateCategoria(categoria);
    }

    @Override
    public Long deleteCategoria(Long id) {
        return categoriaRepository.deleteCategoria(id);
    }
}
