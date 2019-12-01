package com.plataforma.application.vo.plataforma;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PlataformaResponseVo {
    @JsonProperty("data")
    private List<PlataformaVo> plataformaVoList;
}
