package com.plataforma.application.service.impl;

import com.plataforma.application.service.IPlataformaCategoriaService;
import com.plataforma.application.vo.plataformacategoria.PlataformaCategoriaVo;
import com.plataforma.infrastructure.service.IPlataformaCategoriaIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlataformaCategoriaService implements IPlataformaCategoriaService {
    @Autowired
    private IPlataformaCategoriaIService plataformaCategoriaIService;

    @Override
    public List<PlataformaCategoriaVo> getPlataformaCategoria(Long id) {
        return plataformaCategoriaIService.getPlataformaCategoria(id);
    }

    @Override
    public List<PlataformaCategoriaVo> getAllPlataformaCategoria() {
        return plataformaCategoriaIService.getAllPlataformaCategoria();
    }

    @Override
    public Long postPlataformaCategoria(PlataformaCategoriaVo plataformaCategoriaVo) {
        return plataformaCategoriaIService.postPlataformaCategoria(plataformaCategoriaVo);
    }

    @Override
    public Long putPlataformaCategoria(PlataformaCategoriaVo plataformaCategoriaVo) {
        return plataformaCategoriaIService.putPlataformaCategoria(plataformaCategoriaVo);
    }

    @Override
    public Long deletePlataformaCategoria(Long id) {
        return plataformaCategoriaIService.deletePlataformaCategoria(id);
    }
}
