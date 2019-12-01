package com.plataforma.application.vo.rol;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolRequestVo{
    @JsonProperty("params")
    private RolVo rolVo;
}
