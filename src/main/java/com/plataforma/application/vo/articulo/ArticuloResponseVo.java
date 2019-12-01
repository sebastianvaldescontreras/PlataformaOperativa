package com.plataforma.application.vo.articulo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ArticuloResponseVo{
    @JsonProperty("data")
    private List<ArticuloVo> articuloVoList;
}
