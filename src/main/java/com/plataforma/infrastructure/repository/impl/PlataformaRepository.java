package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.Plataforma;
import com.plataforma.domain.mappers.PlataformaMapper;
import com.plataforma.infrastructure.repository.IPlataformaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
@Slf4j
@PropertySource("classpath:query.yml")
public class PlataformaRepository implements IPlataformaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${selectPlataforma}")
    private String select;

    @Value("${selectAllPlataforma}")
    private String selectAll;

    @Value("${insertPlataforma}")
    private String insert;

    @Value("${updatePlataforma}")
    private String update;

    @Value("${deletePlataforma}")
    private String delete;

    @Override
    public List<Plataforma> selectPlataforma(Long id) {
        final RowMapper<Plataforma> mapper = new PlataformaMapper();
        try{
            return (List<Plataforma>) jdbcTemplate.query(select, (RowMapper) mapper, id);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de plataforma en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public List<Plataforma> selectAllPlataforma() {
        final RowMapper<Plataforma> mapper = new PlataformaMapper();
        try{
            return (List<Plataforma>) jdbcTemplate.query(selectAll, (RowMapper) mapper);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de plataforma en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public Long insertPlataforma(Plataforma plataforma) {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                        PreparedStatement ps = connection.prepareStatement(insert, new String[] {"id"});
                        ps.setString(1, plataforma.getNombre());
                        ps.setString(2, plataforma.getDescripcion());
                        ps.setBoolean(3, plataforma.getEstado());
                        ps.setTimestamp(4, Timestamp.valueOf(plataforma.getFechaActualizacion()));
                        ps.setTimestamp(5, Timestamp.valueOf(plataforma.getFechaCreacion()));

                        return ps;
                    },
                    keyHolder);
            return keyHolder.getKey().longValue();
        }catch(Exception e){
            log.error("No fue posible insertar registro de plataforma en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long updatePlataforma(Plataforma plataforma) {
        try{
            return (long) jdbcTemplate.update(update,
                    plataforma.getNombre(),
                    plataforma.getDescripcion(),
                    plataforma.getEstado(),
                    plataforma.getFechaActualizacion(),
                    plataforma.getId());
        }catch(Exception e){
            log.error("No fue posible actualizar registro de plataforma en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long deletePlataforma(Long id) {
        try{
            return (long) jdbcTemplate.update(delete, id);
        }catch(Exception e){
            log.error("No fue posible eliminar registro de plataforma en Base de Datos. " + e);
        }
        return 0L;
    }
}
