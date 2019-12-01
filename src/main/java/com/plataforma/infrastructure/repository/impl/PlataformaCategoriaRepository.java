package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.PlataformaCategoria;
import com.plataforma.domain.mappers.PlataformaCategoriaMapper;
import com.plataforma.infrastructure.repository.IPlataformaCategoriaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class PlataformaCategoriaRepository implements IPlataformaCategoriaRepository{
    @Value("${plataformacategoria.select}")
    private String select;

    @Value("${plataformacategoria.selectAll}")
    private String selectAll;

    @Value("${plataformacategoria.insert}")
    private String insert;

    @Value("${plataformacategoria.update}")
    private String update;

    @Value("${plataformacategoria.delete}")
    private String delete;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PlataformaCategoria> selectPlataformaCategoria(Long id) {
        final RowMapper<PlataformaCategoria> mapper = new PlataformaCategoriaMapper();
        try{
            return (List<PlataformaCategoria>) jdbcTemplate.query(select, (RowMapper) mapper, id);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de plataformacategoria en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public List<PlataformaCategoria> selectAllPlataformaCategoria() {
        final RowMapper<PlataformaCategoria> mapper = new PlataformaCategoriaMapper();
        try{
            return (List<PlataformaCategoria>) jdbcTemplate.query(selectAll, (RowMapper) mapper);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de plataformacategoria en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public Long insertPlataformaCategoria(PlataformaCategoria plataformaCategoria) {
        try{
            return (long) jdbcTemplate.update(insert,
                    plataformaCategoria.getIdPlataforma(),
                    plataformaCategoria.getIdCategoria(),
                    plataformaCategoria.getEstado(),
                    plataformaCategoria.getFechaActualizacion(),
                    plataformaCategoria.getFechaCreacion());
        }catch(Exception e){
            log.error("No fue posible insertar registro de plataformacategoria en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long updatePlataformaCategoria(PlataformaCategoria plataformaCategoria) {
        try{
            return (long) jdbcTemplate.update(update,
                    plataformaCategoria.getIdPlataforma(),
                    plataformaCategoria.getIdCategoria(),
                    plataformaCategoria.getEstado(),
                    plataformaCategoria.getFechaActualizacion(),
                    plataformaCategoria.getId());
        }catch(Exception e){
            log.error("No fue posible actualizar registro de plataformacategoria en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long deletePlataformaCategoria(Long id) {
        try{
            return (long) jdbcTemplate.update(delete, id);
        }catch(Exception e){
            log.error("No fue posible eliminar registro de plataformacategoria en Base de Datos. " + e);
        }
        return 0L;
    }
}
