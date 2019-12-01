package com.plataforma.domain.mappers;

import com.plataforma.domain.entities.PlataformaCategoria;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PlataformaCategoriaMapper implements RowMapper<PlataformaCategoria> {
    @Override
    public PlataformaCategoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        final PlataformaCategoria plataformaCategoria = new PlataformaCategoria();

        plataformaCategoria.setId(rs.getLong("id"));
        plataformaCategoria.setIdPlataforma(rs.getLong("idPlataforma"));
        plataformaCategoria.setIdCategoria(rs.getLong("idCategoria"));
        plataformaCategoria.setEstado(rs.getBoolean("estado"));
        plataformaCategoria.setFechaActualizacion(rs.getTimestamp("fechaActualizacion").toLocalDateTime());
        plataformaCategoria.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());

        return plataformaCategoria;
    }
}
