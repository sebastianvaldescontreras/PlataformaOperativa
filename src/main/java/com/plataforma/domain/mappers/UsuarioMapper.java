package com.plataforma.domain.mappers;

import com.plataforma.domain.entities.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<Usuario>{
    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Usuario usuario = new Usuario();

        usuario.setId(rs.getLong("id"));
        usuario.setIdrol(rs.getLong("idrol"));
        usuario.setTipoDocumento(rs.getString("tipoDocumento"));
        usuario.setNumeroDocumento(rs.getString("numeroDocumento"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setApellido(rs.getString("apellido"));
        usuario.setDireccion(rs.getString("direccion"));
        usuario.setTelefono(rs.getString("telefono"));
        usuario.setEmail(rs.getString("email"));
        usuario.setClave(rs.getString("clave"));
        usuario.setEstado(rs.getBoolean("estado"));
        usuario.setFechaActualizacion(rs.getTimestamp("fechaActualizacion").toLocalDateTime());
        usuario.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());

        return usuario;
    }
}
