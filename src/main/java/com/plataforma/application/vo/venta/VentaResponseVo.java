package com.plataforma.application.vo.venta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class VentaResponseVo{
    @JsonProperty("data")
    private List<VentaVo> ventaVoList;
}
