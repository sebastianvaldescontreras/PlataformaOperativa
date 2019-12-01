package com.plataforma.application.vo.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioResponseVo{
    @JsonProperty("data")
    private List<UsuarioVo> usuarioVoList;
}
