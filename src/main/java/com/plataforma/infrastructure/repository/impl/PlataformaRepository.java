package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.Plataforma;
import com.plataforma.domain.mappers.PlataformaMapper;
import com.plataforma.infrastructure.repository.IPlataformaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.RowMapper;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class PlataformaRepository implements IPlataformaRepository {

    @Value("${plataforma.select}")
    private String select;

    @Value("${plataforma.selectAll}")
    private String selectAll;

    @Value("${plataforma.insert}")
    private String insert;

    @Value("${plataforma.update}")
    private String update;

    @Value("${plataforma.delete}")
    private String delete;

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
            return (long) jdbcTemplate.update(insert,
                    plataforma.getNombre(),
                    plataforma.getDescripcion(),
                    plataforma.getEstado(),
                    plataforma.getFechaActualizacion(),
                    plataforma.getFechaCreacion());
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
