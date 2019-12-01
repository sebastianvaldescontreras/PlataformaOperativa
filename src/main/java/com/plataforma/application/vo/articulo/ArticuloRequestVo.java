package com.plataforma.application.vo.articulo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticuloRequestVo{
    @JsonProperty("params")
    private ArticuloVo articuloVo;
}
