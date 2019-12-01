package com.plataforma.infrastructure.service.impl;

import com.plataforma.application.vo.articulo.ArticuloVo;
import com.plataforma.domain.entities.Articulo;
import com.plataforma.infrastructure.repository.IArticuloRepository;
import com.plataforma.infrastructure.service.IArticuloIService;
import com.plataforma.infrastructurecross.util.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticuloIService implements IArticuloIService {
    @Autowired
    private IArticuloRepository articuloRepository;

    @Override
    public List<ArticuloVo> getArticulo(Long id){
        List<Articulo> articuloList = articuloRepository.selectArticulo(id);
        return ObjectMapper.mapAll(articuloList, ArticuloVo.class);
    }

    @Override
    public List<ArticuloVo> getAllArticulo() {
        List<Articulo> articuloList = articuloRepository.selectAllArticulo();
        return ObjectMapper.mapAll(articuloList, ArticuloVo.class);
    }

    @Override
    public Long postArticulo(ArticuloVo articuloVo){
        ModelMapper modelMapper = new ModelMapper();
        Articulo articulo  = (Articulo) modelMapper.map(articuloVo, (Class)Articulo.class);
        articulo.setFechaCreacion(LocalDateTime.now());
        articulo.setFechaActualizacion(LocalDateTime.now());
        return articuloRepository.insertArticulo(articulo);
    }

    @Override
    public Long putArticulo(ArticuloVo plataformaVo){
        ModelMapper modelMapper = new ModelMapper();
        Articulo articulo  = (Articulo) modelMapper.map(plataformaVo, (Class)Articulo.class);
        articulo.setFechaActualizacion(LocalDateTime.now());
        return articuloRepository.updateArticulo(articulo);
    }

    @Override
    public Long deleteArticulo(Long id) {
        return articuloRepository.deleteArticulo(id);
    }
}
