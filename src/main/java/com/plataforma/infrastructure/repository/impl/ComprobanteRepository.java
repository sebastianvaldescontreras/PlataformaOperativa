package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.Comprobante;
import com.plataforma.domain.mappers.ComprobanteMapper;
import com.plataforma.infrastructure.repository.IComprobanteRepository;
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
public class ComprobanteRepository implements IComprobanteRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${selectComprobante}")
    private String select;

    @Value("${selectAllComprobante}")
    private String selectAll;

    @Value("${insertComprobante}")
    private String insert;

    @Value("${updateComprobante}")
    private String update;

    @Value("${deleteComprobante}")
    private String delete;

    @Override
    public List<Comprobante> selectComprobante(Long id) {
        final RowMapper<Comprobante> mapper = new ComprobanteMapper();
        try{
            return (List<Comprobante>) jdbcTemplate.query(select, (RowMapper) mapper, id);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de comprobante en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public List<Comprobante> selectAllComprobante() {
        final RowMapper<Comprobante> mapper = new ComprobanteMapper();
        try{
            return (List<Comprobante>) jdbcTemplate.query(selectAll, (RowMapper) mapper);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de comprobante en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public Long insertComprobante(Comprobante comprobante) {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                        PreparedStatement ps = connection.prepareStatement(insert, new String[] {"id"});
                        ps.setString(1, comprobante.getTipo());
                        ps.setString(2, comprobante.getSerie());
                        ps.setLong(3, comprobante.getNumero());
                        ps.setBoolean(4, comprobante.getEstado());
                        ps.setTimestamp(5, Timestamp.valueOf(comprobante.getFechaActualizacion()));
                        ps.setTimestamp(6, Timestamp.valueOf(comprobante.getFechaCreacion()));
                        return ps;
                    },
                    keyHolder);
            return keyHolder.getKey().longValue();
        }catch(Exception e){
            log.error("No fue posible insertar registro de comprobante en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long updateComprobante(Comprobante comprobante) {
        try{
            return (long) jdbcTemplate.update(update,
                    comprobante.getTipo(),
                    comprobante.getSerie(),
                    comprobante.getNumero(),
                    comprobante.getEstado(),
                    comprobante.getFechaActualizacion(),
                    comprobante.getId());
        }catch(Exception e){
            log.error("No fue posible actualizar registro de comprobante en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long deleteComprobante(Long id) {
        try{
            return (long) jdbcTemplate.update(delete, id);
        }catch(Exception e){
            log.error("No fue posible eliminar registro de comprobante en Base de Datos. " + e);
        }
        return 0L;
    }
}
