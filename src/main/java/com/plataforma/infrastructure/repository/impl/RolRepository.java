package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.Rol;
import com.plataforma.domain.mappers.RolMapper;
import com.plataforma.infrastructure.repository.IRolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
@Slf4j
@PropertySource("classpath:query.yml")
public class RolRepository implements IRolRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${selectRol}")
    private String select;

    @Value("${selectAllRol}")
    private String selectAll;

    @Value("${insertRol}")
    private String insert;

    @Value("${updateRol}")
    private String update;

    @Value("${deleteRol}")
    private String delete;

    @Override
    public List<Rol> selectRol(Long id) {
        final RowMapper<Rol> mapper = new RolMapper();
        try{
            return (List<Rol>) jdbcTemplate.query(select, (RowMapper) mapper, id);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de rol en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public List<Rol> selectAllRol() {
        final RowMapper<Rol> mapper = new RolMapper();
        try{
            return (List<Rol>) jdbcTemplate.query(selectAll, (RowMapper) mapper);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de rol en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public Long insertRol(Rol rol) {
        try{
            return (long) jdbcTemplate.update(insert,
                    rol.getNombre(),
                    rol.getDescripcion(),
                    rol.getEstado(),
                    rol.getFechaActualizacion(),
                    rol.getFechaCreacion());
        }catch(Exception e){
            log.error("No fue posible insertar registro de rol en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long updateRol(Rol rol) {
        try{
            return (long) jdbcTemplate.update(update,
                    rol.getNombre(),
                    rol.getDescripcion(),
                    rol.getEstado(),
                    rol.getFechaActualizacion(),
                    rol.getId());
        }catch(Exception e){
            log.error("No fue posible actualizar registro de rol en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long deleteRol(Long id) {
        try{
            return (long) jdbcTemplate.update(delete, id);
        }catch(Exception e){
            log.error("No fue posible eliminar registro de rol en Base de Datos. " + e);
        }
        return 0L;
    }
}
