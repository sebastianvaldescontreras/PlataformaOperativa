package com.plataforma.domain.mappers;

import com.plataforma.domain.entities.Rol;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RolMapper implements RowMapper<Rol>{
    @Override
    public Rol mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Rol rol = new Rol();

        rol.setId(rs.getLong("id"));
        rol.setNombre(rs.getString("nombre"));
        rol.setDescripcion(rs.getString("descripcion"));
        rol.setEstado(rs.getBoolean("estado"));
        rol.setFechaActualizacion(rs.getTimestamp("fechaActualizacion").toLocalDateTime());
        rol.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());

        return rol;
    }
}
