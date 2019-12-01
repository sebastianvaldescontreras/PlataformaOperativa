package com.plataforma.domain.entities;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Usuario{
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
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaCreacion;
}
