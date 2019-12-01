package com.plataforma.domain.mappers;

import com.plataforma.domain.entities.Producto;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoMapper implements RowMapper<Producto>{
    @Override
    public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Producto producto = new Producto();

        producto.setId(rs.getLong("id"));
        producto.setCodigo(rs.getString("codigo"));
        producto.setNombre(rs.getString("nombre"));
        producto.setDescripcion(rs.getString("descripcion"));
        producto.setPrecio(rs.getLong("precio"));
        producto.setEstado(rs.getBoolean("estado"));
        producto.setFechaActualizacion(rs.getTimestamp("fechaActualizacion").toLocalDateTime());
        producto.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());

        return producto;
    }
}
