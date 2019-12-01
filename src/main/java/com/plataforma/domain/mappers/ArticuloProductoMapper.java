package com.plataforma.domain.mappers;

import com.plataforma.domain.entities.ArticuloProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticuloProductoMapper implements RowMapper<ArticuloProducto> {
    @Override
    public ArticuloProducto mapRow(ResultSet rs, int rowNum) throws SQLException {
        final ArticuloProducto articuloProducto = new ArticuloProducto();

        articuloProducto.setId(rs.getLong("id"));
        articuloProducto.setIdArticulo(rs.getLong("idArticulo"));
        articuloProducto.setIdProducto(rs.getLong("idProducto"));
        articuloProducto.setEstado(rs.getBoolean("estado"));
        articuloProducto.setFechaActualizacion(rs.getTimestamp("fechaActualizacion").toLocalDateTime());
        articuloProducto.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());

        return articuloProducto;
    }
}
