package com.plataforma.application.service.impl;

import com.plataforma.application.service.ICategoriaService;
import com.plataforma.application.vo.categoria.CategoriaVo;
import com.plataforma.infrastructure.service.ICategoriaIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private ICategoriaIService categoriaIService;

    @Override
    public List<CategoriaVo> getCategoria(Long id) {
        return categoriaIService.getCategoria(id);
    }

    @Override
    public List<CategoriaVo> getAllCategoria() {
        return categoriaIService.getAllCategoria();
    }

    @Override
    public Long postCategoria(CategoriaVo categoriaVo) {
        return categoriaIService.postCategoria(categoriaVo);
    }

    @Override
    public Long putCategoria(CategoriaVo categoriaVo) {
        return categoriaIService.putCategoria(categoriaVo);
    }

    @Override
    public Long deleteCategoria(Long id) {
        return categoriaIService.deleteCategoria(id);
    }
}
