package com.plataforma.application.vo.venta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaRequestVo{
    @JsonProperty("params")
    private VentaVo ventaVo;
}
