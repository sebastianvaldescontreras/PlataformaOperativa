package com.plataforma.application.vo.plataforma;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlataformaRequestVo{
    @JsonProperty("params")
    private PlataformaVo plataformaVo;
}
