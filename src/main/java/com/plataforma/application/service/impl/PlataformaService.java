package com.plataforma.application.service.impl;

import com.plataforma.application.service.IPlataformaService;
import com.plataforma.application.vo.plataforma.PlataformaVo;
import com.plataforma.infrastructure.service.IPlataformaIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlataformaService implements IPlataformaService{
    @Autowired
    private IPlataformaIService plataformaIService;

    @Override
    public List<PlataformaVo> getPlataforma(Long id){
        return plataformaIService.getPlataforma(id);
    }

    @Override
    public List<PlataformaVo> getAllPlataforma() {
        return plataformaIService.getAllPlataforma();
    }

    @Override
    public Long postPlataforma(PlataformaVo plataformaVo){
        return plataformaIService.postPlataforma(plataformaVo);
    }

    @Override
    public Long putPlataforma(PlataformaVo plataformaVo){
        return plataformaIService.putPlataforma(plataformaVo);
    }

    @Override
    public Long deletePlataforma(Long id) {
        return plataformaIService.deletePlataforma(id);
    }
}
