package com.plataforma.application.vo.articuloproducto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticuloProductoRequestVo {
    @JsonProperty("params")
    private ArticuloProductoVo articuloProductoVo;
}
