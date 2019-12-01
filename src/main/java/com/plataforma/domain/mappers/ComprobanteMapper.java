package com.plataforma.domain.mappers;

import com.plataforma.domain.entities.Comprobante;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComprobanteMapper implements RowMapper<Comprobante>{
    @Override
    public Comprobante mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Comprobante comprobante = new Comprobante();

        comprobante.setId(rs.getLong("id"));
        comprobante.setTipo(rs.getString("tipo"));
        comprobante.setSerie(rs.getString("serie"));
        comprobante.setNumero(rs.getLong("numero"));
        comprobante.setEstado(rs.getBoolean("estado"));
        comprobante.setFechaActualizacion(rs.getTimestamp("fechaActualizacion").toLocalDateTime());
        comprobante.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());

        return comprobante;
    }
}
