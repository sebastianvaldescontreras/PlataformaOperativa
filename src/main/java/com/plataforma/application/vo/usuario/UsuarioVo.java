package com.plataforma.application.vo.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioVo{
    private Long id;
    private Long idrol;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private String clave;
    private Boolean estado;
    private String fechaActualizacion;
    private String fechaCreacion;
}
