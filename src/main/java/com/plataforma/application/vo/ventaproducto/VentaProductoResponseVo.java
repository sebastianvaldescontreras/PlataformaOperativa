package com.plataforma.application.vo.ventaproducto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class VentaProductoResponseVo{
    @JsonProperty("data")
    private List<VentaProductoVo> ventaProductoVoList;
}
