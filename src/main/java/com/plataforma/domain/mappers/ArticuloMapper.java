package com.plataforma.domain.mappers;

import com.plataforma.domain.entities.Articulo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticuloMapper implements RowMapper<Articulo> {
    @Override
    public Articulo mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Articulo articulo = new Articulo();

        articulo.setId(rs.getLong("id"));
        articulo.setIdCategoria(rs.getLong("idCategoria"));
        articulo.setCodigo(rs.getString("codigo"));
        articulo.setNombre(rs.getString("nombre"));
        articulo.setPrecio(rs.getLong("precio"));
        articulo.setStock(rs.getLong("stock"));
        articulo.setDescripcion(rs.getString("descripcion"));
        articulo.setImagen(rs.getString("imagen"));
        articulo.setEstado(rs.getBoolean("estado"));
        articulo.setFechaActualizacion(rs.getTimestamp("fechaActualizacion").toLocalDateTime());
        articulo.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());

        return articulo;
    }
}
