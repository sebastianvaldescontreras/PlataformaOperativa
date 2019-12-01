package com.plataforma.infrastructure.service;

import com.plataforma.application.vo.plataforma.PlataformaVo;
import java.util.List;

public interface IPlataformaIService {
    List<PlataformaVo> getPlataforma(Long id);
    List<PlataformaVo> getAllPlataforma();
    Long postPlataforma(PlataformaVo plataformaVo);
    Long putPlataforma(PlataformaVo plataformaVo);
    Long deletePlataforma(Long id);
}
