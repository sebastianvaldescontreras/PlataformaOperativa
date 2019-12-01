package com.plataforma.application.vo.rol;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RolResponseVo{
    @JsonProperty("data")
    private List<RolVo> rolVoList;
}
