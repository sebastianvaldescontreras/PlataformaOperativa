package com.plataforma.application.vo.categoria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaRequestVo {
    @JsonProperty("params")
    private CategoriaVo categoriaVo;
}
