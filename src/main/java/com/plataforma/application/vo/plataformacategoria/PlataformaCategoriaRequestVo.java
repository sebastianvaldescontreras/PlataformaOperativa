package com.plataforma.application.vo.plataformacategoria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlataformaCategoriaRequestVo{
    @JsonProperty("params")
    private PlataformaCategoriaVo plataformaCategoriaVo;
}
