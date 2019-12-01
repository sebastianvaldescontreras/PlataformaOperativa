package com.plataforma.infrastructure.service.impl;

import com.plataforma.application.vo.plataformacategoria.PlataformaCategoriaVo;
import com.plataforma.domain.entities.PlataformaCategoria;
import com.plataforma.infrastructure.repository.IPlataformaCategoriaRepository;
import com.plataforma.infrastructure.service.IPlataformaCategoriaIService;
import com.plataforma.infrastructurecross.util.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlataformaCategoriaIService implements IPlataformaCategoriaIService{
    @Autowired
    private IPlataformaCategoriaRepository plataformaCategoriaRepository;

    @Override
    public List<PlataformaCategoriaVo> getPlataformaCategoria(Long id){
        List<PlataformaCategoria> plataformaCategoriaList = plataformaCategoriaRepository.selectPlataformaCategoria(id);
        return ObjectMapper.mapAll(plataformaCategoriaList, PlataformaCategoriaVo.class);
    }

    @Override
    public List<PlataformaCategoriaVo> getAllPlataformaCategoria() {
        List<PlataformaCategoria> plataformaCategoriaList = plataformaCategoriaRepository.selectAllPlataformaCategoria();
        return ObjectMapper.mapAll(plataformaCategoriaList, PlataformaCategoriaVo.class);
    }

    @Override
    public Long postPlataformaCategoria(PlataformaCategoriaVo plataformaCategoriaVo){
        ModelMapper modelMapper = new ModelMapper();
        PlataformaCategoria plataformaCategoria  = (PlataformaCategoria) modelMapper.map(plataformaCategoriaVo, (Class) PlataformaCategoria.class);
        plataformaCategoria.setFechaCreacion(LocalDateTime.now());
        plataformaCategoria.setFechaActualizacion(LocalDateTime.now());
        return plataformaCategoriaRepository.insertPlataformaCategoria(plataformaCategoria);
    }

    @Override
    public Long putPlataformaCategoria(PlataformaCategoriaVo plataformaCategoriaVo){
        ModelMapper modelMapper = new ModelMapper();
        PlataformaCategoria comprobante  = (PlataformaCategoria) modelMapper.map(plataformaCategoriaVo, (Class)PlataformaCategoria.class);
        comprobante.setFechaActualizacion(LocalDateTime.now());
        return plataformaCategoriaRepository.updatePlataformaCategoria(comprobante);
    }

    @Override
    public Long deletePlataformaCategoria(Long id) {
        return plataformaCategoriaRepository.deletePlataformaCategoria(id);
    }
}
