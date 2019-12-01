package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.Articulo;
import com.plataforma.domain.mappers.ArticuloMapper;
import com.plataforma.infrastructure.repository.IArticuloRepository;
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
public class ArticuloRepository implements IArticuloRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${articulo.select}")
    private String select;

    @Value("${articulo.selectAll}")
    private String selectAll;

    @Value("${articulo.insert}")
    private String insert;

    @Value("${articulo.update}")
    private String update;

    @Value("${articulo.delete}")
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
            return (long) jdbcTemplate.update(insert,
                    articulo.getIdCategoria(),
                    articulo.getCodigo(),
                    articulo.getNombre(),
                    articulo.getPrecio(),
                    articulo.getStock(),
                    articulo.getDescripcion(),
                    articulo.getImagen(),
                    articulo.getEstado(),
                    articulo.getFechaActualizacion(),
                    articulo.getFechaCreacion());
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
