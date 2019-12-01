package com.plataforma.domain.mappers;

import com.plataforma.domain.entities.VentaProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaProductoMapper implements RowMapper<VentaProducto> {
    @Override
    public VentaProducto mapRow(ResultSet rs, int rowNum) throws SQLException {
        final VentaProducto ventaProducto = new VentaProducto();

        ventaProducto.setId(rs.getLong("id"));
        ventaProducto.setIdProducto(rs.getLong("idProducto"));
        ventaProducto.setIdVenta(rs.getLong("idVenta"));
        ventaProducto.setCantidad(rs.getLong("cantidad"));
        ventaProducto.setPrecio(rs.getLong("precio"));
        ventaProducto.setDescuento(rs.getLong("descuento"));
        ventaProducto.setEstado(rs.getBoolean("estado"));
        ventaProducto.setFechaActualizacion(rs.getTimestamp("fechaActualizacion").toLocalDateTime());
        ventaProducto.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());

        return ventaProducto;
    }
}
