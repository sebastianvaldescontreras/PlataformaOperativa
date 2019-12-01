package com.plataforma.domain.mappers;

import com.plataforma.domain.entities.Categoria;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaMapper implements RowMapper<Categoria> {
    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Categoria categoria = new Categoria();

        categoria.setId(rs.getLong("id"));
        categoria.setNombre(rs.getString("nombre"));
        categoria.setDescripcion(rs.getString("descripcion"));
        categoria.setEstado(rs.getBoolean("estado"));
        categoria.setFechaActualizacion(rs.getTimestamp("fechaActualizacion").toLocalDateTime());
        categoria.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());

        return categoria;
    }
}
