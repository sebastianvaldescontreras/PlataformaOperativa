package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.VentaProducto;
import com.plataforma.domain.mappers.VentaProductoMapper;
import com.plataforma.infrastructure.repository.IVentaProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
@Slf4j
@PropertySource("classpath:query.yml")
public class VentaProductoRepository implements IVentaProductoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${selectVentaProducto}")
    private String select;

    @Value("${selectAllVentaProducto}")
    private String selectAll;

    @Value("${insertVentaProducto}")
    private String insert;

    @Value("${updateVentaProducto}")
    private String update;

    @Value("${deleteVentaProducto}")
    private String delete;

    @Override
    public List<VentaProducto> selectVentaProducto(Long id) {
        final RowMapper<VentaProducto> mapper = new VentaProductoMapper();
        try{
            return (List<VentaProducto>) jdbcTemplate.query(select, (RowMapper) mapper, id);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de ventaproducto en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public List<VentaProducto> selectAllVentaProducto() {
        final RowMapper<VentaProducto> mapper = new VentaProductoMapper();
        try{
            return (List<VentaProducto>) jdbcTemplate.query(selectAll, (RowMapper) mapper);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de ventaproducto en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public Long insertVentaProducto(VentaProducto ventaProducto) {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                        PreparedStatement ps = connection.prepareStatement(insert, new String[] {"id"});
                        ps.setLong(1, ventaProducto.getIdProducto());
                        ps.setLong(2, ventaProducto.getIdVenta());
                        ps.setLong(3, ventaProducto.getCantidad());
                        ps.setLong(4, ventaProducto.getPrecio());
                        ps.setLong(5, ventaProducto.getDescuento());
                        ps.setBoolean(6, ventaProducto.getEstado());
                        ps.setTimestamp(7, Timestamp.valueOf(ventaProducto.getFechaActualizacion()));
                        ps.setTimestamp(8, Timestamp.valueOf(ventaProducto.getFechaCreacion()));

                        return ps;
                    },
                    keyHolder);
            return keyHolder.getKey().longValue();
        }catch(Exception e){
            log.error("No fue posible insertar registro de ventaproducto en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long updateVentaProducto(VentaProducto ventaProducto) {
        try{
            return (long) jdbcTemplate.update(update,
                    ventaProducto.getIdProducto(),
                    ventaProducto.getIdVenta(),
                    ventaProducto.getCantidad(),
                    ventaProducto.getPrecio(),
                    ventaProducto.getDescuento(),
                    ventaProducto.getEstado(),
                    ventaProducto.getFechaActualizacion(),
                    ventaProducto.getId());
        }catch(Exception e){
            log.error("No fue posible actualizar registro de ventaproducto en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long deleteVentaProducto(Long id) {
        try{
            return (long) jdbcTemplate.update(delete, id);
        }catch(Exception e){
            log.error("No fue posible eliminar registro de ventaproducto en Base de Datos. " + e);
        }
        return 0L;
    }
}
