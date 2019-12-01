package com.plataforma.infrastructure.service.impl;

import com.plataforma.application.vo.plataforma.PlataformaVo;
import com.plataforma.domain.entities.Plataforma;
import com.plataforma.infrastructure.repository.IPlataformaRepository;
import com.plataforma.infrastructure.service.IPlataformaIService;
import com.plataforma.infrastructurecross.util.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlataformaIService implements IPlataformaIService {
    @Autowired
    private IPlataformaRepository plataformaRepository;

    @Override
    public List<PlataformaVo> getPlataforma(Long id){
        List<Plataforma> plataformaList = plataformaRepository.selectPlataforma(id);
        return ObjectMapper.mapAll(plataformaList, PlataformaVo.class);
    }

    @Override
    public List<PlataformaVo> getAllPlataforma() {
        List<Plataforma> plataformaList = plataformaRepository.selectAllPlataforma();
        return ObjectMapper.mapAll(plataformaList, PlataformaVo.class);
    }

    @Override
    public Long postPlataforma(PlataformaVo plataformaVo){
        ModelMapper modelMapper = new ModelMapper();
        Plataforma plataforma  = (Plataforma) modelMapper.map(plataformaVo, (Class)Plataforma.class);
        plataforma.setFechaCreacion(LocalDateTime.now());
        plataforma.setFechaActualizacion(LocalDateTime.now());
        return plataformaRepository.insertPlataforma(plataforma);
    }

    @Override
    public Long putPlataforma(PlataformaVo plataformaVo){
        ModelMapper modelMapper = new ModelMapper();
        Plataforma plataforma  = (Plataforma) modelMapper.map(plataformaVo, (Class)Plataforma.class);
        plataforma.setFechaActualizacion(LocalDateTime.now());
        return plataformaRepository.updatePlataforma(plataforma);
    }

    @Override
    public Long deletePlataforma(Long id) {
        return plataformaRepository.deletePlataforma(id);
    }
}
