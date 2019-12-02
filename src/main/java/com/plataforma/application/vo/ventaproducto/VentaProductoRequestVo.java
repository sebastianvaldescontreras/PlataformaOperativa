package com.plataforma.application.vo.ventaproducto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaProductoRequestVo{
    @JsonProperty("params")
    private VentaProductoVo ventaProductoVo;
}
