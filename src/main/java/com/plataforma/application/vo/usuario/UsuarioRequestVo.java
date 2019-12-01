package com.plataforma.application.vo.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequestVo{
    @JsonProperty("params")
    private UsuarioVo usuarioVo;
}
