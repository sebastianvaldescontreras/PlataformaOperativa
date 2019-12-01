package com.plataforma.application.vo.producto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoRequestVo{
    @JsonProperty("params")
    private ProductoVo productoVo;
}
