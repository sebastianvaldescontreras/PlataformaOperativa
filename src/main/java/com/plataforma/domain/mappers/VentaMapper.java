package com.plataforma.domain.mappers;

import com.plataforma.domain.entities.Venta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaMapper implements RowMapper<Venta>{
    @Override
    public Venta mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Venta venta = new Venta();

        venta.setId(rs.getLong("id"));
        venta.setIdUsuario(rs.getLong("idUsuario"));
        venta.setIdComprobante(rs.getLong("idComprobante"));
        venta.setImpuesto(rs.getLong("impuesto"));
        venta.setTotal(rs.getLong("total"));
        venta.setEstado(rs.getBoolean("estado"));
        venta.setFechaActualizacion(rs.getTimestamp("fechaActualizacion").toLocalDateTime());
        venta.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());

        return venta;
    }
}
