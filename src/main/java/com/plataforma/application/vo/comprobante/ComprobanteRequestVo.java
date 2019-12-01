package com.plataforma.application.vo.comprobante;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComprobanteRequestVo {
    @JsonProperty("params")
    private ComprobanteVo comprobanteVo;
}
