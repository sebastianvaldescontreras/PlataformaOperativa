package com.plataforma.application.vo.categoria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoriaResponseVo{
    @JsonProperty("data")
    private List<CategoriaVo> categoriaVoList;
}
