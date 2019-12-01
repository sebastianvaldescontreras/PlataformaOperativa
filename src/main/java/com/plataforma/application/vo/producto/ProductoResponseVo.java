package com.plataforma.application.vo.producto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductoResponseVo{
    @JsonProperty("data")
    private List<ProductoVo> plataformaCategoriaVoList;
}
