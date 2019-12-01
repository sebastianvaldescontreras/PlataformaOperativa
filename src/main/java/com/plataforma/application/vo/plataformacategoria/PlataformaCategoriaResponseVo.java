package com.plataforma.application.vo.plataformacategoria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PlataformaCategoriaResponseVo{
    @JsonProperty("data")
    private List<PlataformaCategoriaVo> plataformaCategoriaVoList;
}
