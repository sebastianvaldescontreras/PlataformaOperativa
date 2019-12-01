package com.plataforma.application.vo.comprobante;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ComprobanteResponseVo{
    @JsonProperty("data")
    private List<ComprobanteVo> comprobanteVoList;
}
