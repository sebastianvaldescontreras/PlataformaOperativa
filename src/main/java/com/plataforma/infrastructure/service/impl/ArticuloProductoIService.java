package com.plataforma.infrastructure.service.impl;

import com.plataforma.application.vo.articuloproducto.ArticuloProductoVo;
import com.plataforma.domain.entities.ArticuloProducto;
import com.plataforma.infrastructure.repository.IArticuloProductoRepository;
import com.plataforma.infrastructure.service.IArticuloProductoIService;
import com.plataforma.infrastructurecross.util.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticuloProductoIService implements IArticuloProductoIService {
    @Autowired
    private IArticuloProductoRepository articuloProductoRepository;

    @Override
    public List<ArticuloProductoVo> getArticuloProducto(Long id){
        List<ArticuloProducto> articuloProductoList = articuloProductoRepository.selectArticuloProducto(id);
        return ObjectMapper.mapAll(articuloProductoList, ArticuloProductoVo.class);
    }

    @Override
    public List<ArticuloProductoVo> getAllArticuloProducto() {
        List<ArticuloProducto> articuloProductoList = articuloProductoRepository.selectAllArticuloProducto();
        return ObjectMapper.mapAll(articuloProductoList, ArticuloProductoVo.class);
    }

    @Override
    public Long postArticuloProducto(ArticuloProductoVo articuloProductoVo){
        ModelMapper modelMapper = new ModelMapper();
        ArticuloProducto articuloProducto  = (ArticuloProducto) modelMapper.map(articuloProductoVo, (Class) ArticuloProducto.class);
        articuloProducto.setFechaCreacion(LocalDateTime.now());
        articuloProducto.setFechaActualizacion(LocalDateTime.now());
        return articuloProductoRepository.insertArticuloProducto(articuloProducto);
    }

    @Override
    public Long putArticuloProducto(ArticuloProductoVo articuloProductoVo){
        ModelMapper modelMapper = new ModelMapper();
        ArticuloProducto articuloProducto  = (ArticuloProducto) modelMapper.map(articuloProductoVo, (Class)ArticuloProducto.class);
        articuloProducto.setFechaActualizacion(LocalDateTime.now());
        return articuloProductoRepository.updateArticuloProducto(articuloProducto);
    }

    @Override
    public Long deleteArticuloProducto(Long id) {
        return articuloProductoRepository.deleteArticuloProducto(id);
    }
}
