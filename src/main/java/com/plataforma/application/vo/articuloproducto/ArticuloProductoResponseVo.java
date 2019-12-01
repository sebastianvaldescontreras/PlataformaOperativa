package com.plataforma.application.vo.articuloproducto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ArticuloProductoResponseVo {
    @JsonProperty("data")
    private List<ArticuloProductoVo> articuloProductoVoVoList;
}
