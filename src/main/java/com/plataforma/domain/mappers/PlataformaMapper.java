package com.plataforma.domain.mappers;

import com.plataforma.domain.entities.Plataforma;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlataformaMapper implements RowMapper<Plataforma>{
    @Override
    public Plataforma mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Plataforma plataforma = new Plataforma();

        plataforma.setId(rs.getLong("id"));
        plataforma.setNombre(rs.getString("nombre"));
        plataforma.setDescripcion(rs.getString("descripcion"));
        plataforma.setEstado(rs.getBoolean("estado"));
        plataforma.setFechaActualizacion(rs.getTimestamp("fechaActualizacion").toLocalDateTime());
        plataforma.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());

        return plataforma;
    }
}
