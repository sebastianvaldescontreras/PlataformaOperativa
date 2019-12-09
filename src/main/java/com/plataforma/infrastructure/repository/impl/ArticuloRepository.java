package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.Articulo;
import com.plataforma.domain.mappers.ArticuloMapper;
import com.plataforma.infrastructure.repository.IArticuloRepository;
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
public class ArticuloRepository implements IArticuloRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${selectArticulo}")
    private String select;

    @Value("${selectAllArticulo}")
    private String selectAll;

    @Value("${insertArticulo}")
    private String insert;

    @Value("${updateArticulo}")
    private String update;

    @Value("${deleteArticulo}")
    private String delete;

    @Override
    public List<Articulo> selectArticulo(Long id) {
        final RowMapper<Articulo> mapper = new ArticuloMapper();
        try{
            return (List<Articulo>) jdbcTemplate.query(select, (RowMapper) mapper, id);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de articulo en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public List<Articulo> selectAllArticulo() {
        final RowMapper<Articulo> mapper = new ArticuloMapper();
        try{
            return (List<Articulo>) jdbcTemplate.query(selectAll, (RowMapper) mapper);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de articulo en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public Long insertArticulo(Articulo articulo) {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                        PreparedStatement ps = connection.prepareStatement(insert, new String[] {"id"});
                        ps.setLong(1, articulo.getIdCategoria());
                        ps.setString(2, articulo.getCodigo());
                        ps.setString(3, articulo.getNombre());
                        ps.setLong(4, articulo.getPrecio());
                        ps.setLong(5, articulo.getStock());
                        ps.setString(6, articulo.getDescripcion());
                        ps.setString(7, articulo.getImagen());
                        ps.setBoolean(8, articulo.getEstado());
                        ps.setTimestamp(9, Timestamp.valueOf(articulo.getFechaActualizacion()));
                        ps.setTimestamp(10, Timestamp.valueOf(articulo.getFechaCreacion()));
                        return ps;
                    },
                    keyHolder);
            return keyHolder.getKey().longValue();
        }catch(Exception e){
            log.error("No fue posible insertar registro de articulo en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long updateArticulo(Articulo articulo) {
        try{
            return (long) jdbcTemplate.update(update,
                    articulo.getIdCategoria(),
                    articulo.getCodigo(),
                    articulo.getNombre(),
                    articulo.getPrecio(),
                    articulo.getStock(),
                    articulo.getDescripcion(),
                    articulo.getImagen(),
                    articulo.getEstado(),
                    articulo.getFechaActualizacion(),
                    articulo.getId());
        }catch(Exception e){
            log.error("No fue posible actualizar registro de articulo en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long deleteArticulo(Long id) {
        try{
            return (long) jdbcTemplate.update(delete, id);
        }catch(Exception e){
            log.error("No fue posible eliminar registro de articulo en Base de Datos. " + e);
        }
        return 0L;
    }
}
