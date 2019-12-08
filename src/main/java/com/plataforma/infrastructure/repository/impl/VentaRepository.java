package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.Venta;
import com.plataforma.domain.mappers.VentaMapper;
import com.plataforma.infrastructure.repository.IVentaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
@Slf4j
@PropertySource("classpath:query.yml")
public class VentaRepository implements IVentaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${selectVenta}")
    private String select;

    @Value("${selectAllVenta}")
    private String selectAll;

    @Value("${insertVenta}")
    private String insert;

    @Value("${updateVenta}")
    private String update;

    @Value("${deleteVenta}")
    private String delete;

    @Override
    public List<Venta> selectVenta(Long id) {
        final RowMapper<Venta> mapper = new VentaMapper();
        try{
            return (List<Venta>) jdbcTemplate.query(select, (RowMapper) mapper, id);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de venta en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public List<Venta> selectAllVenta() {
        final RowMapper<Venta> mapper = new VentaMapper();
        try{
            return (List<Venta>) jdbcTemplate.query(selectAll, (RowMapper) mapper);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de venta en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public Long insertVenta(Venta venta) {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                        PreparedStatement ps = connection.prepareStatement(insert, new String[] {"id"});
                        ps.setLong(1, venta.getIdUsuario());
                        ps.setLong(2, venta.getIdComprobante());
                        ps.setLong(3, venta.getImpuesto());
                        ps.setLong(4, venta.getTotal());
                        ps.setBoolean(5, venta.getEstado());
                        ps.setTimestamp(6, Timestamp.valueOf(venta.getFechaActualizacion()));
                        ps.setTimestamp(7, Timestamp.valueOf(venta.getFechaCreacion()));
                        return ps;
                    },
                    keyHolder);
            return keyHolder.getKey().longValue();
        }catch(Exception e){
            log.error("No fue posible insertar registro de venta en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long updateVenta(Venta venta) {
        try{
            return (long) jdbcTemplate.update(update,
                    venta.getIdUsuario(),
                    venta.getIdComprobante(),
                    venta.getImpuesto(),
                    venta.getTotal(),
                    venta.getEstado(),
                    venta.getFechaActualizacion(),
                    venta.getId());
        }catch(Exception e){
            log.error("No fue posible actualizar registro de usuario en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long deleteVenta(Long id) {
        try{
            return (long) jdbcTemplate.update(delete, id);
        }catch(Exception e){
            log.error("No fue posible eliminar registro de venta en Base de Datos. " + e);
        }
        return 0L;
    }
}
