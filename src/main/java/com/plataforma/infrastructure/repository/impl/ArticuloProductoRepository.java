package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.ArticuloProducto;
import com.plataforma.domain.mappers.ArticuloProductoMapper;
import com.plataforma.infrastructure.repository.IArticuloProductoRepository;
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
public class ArticuloProductoRepository implements IArticuloProductoRepository {
    @Value("${selectArticuloProducto}")
    private String select;

    @Value("${selectAllArticuloProducto}")
    private String selectAll;

    @Value("${insertArticuloProducto}")
    private String insert;

    @Value("${updateArticuloProducto}")
    private String update;

    @Value("${deleteArticuloProducto}")
    private String delete;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ArticuloProducto> selectArticuloProducto(Long id) {
        final RowMapper<ArticuloProducto> mapper = new ArticuloProductoMapper();
        try{
            return (List<ArticuloProducto>) jdbcTemplate.query(select, (RowMapper) mapper, id);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de articuloproducto en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public List<ArticuloProducto> selectAllArticuloProducto() {
        final RowMapper<ArticuloProducto> mapper = new ArticuloProductoMapper();
        try{
            return (List<ArticuloProducto>) jdbcTemplate.query(selectAll, (RowMapper) mapper);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de articuloproducto en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public Long insertArticuloProducto(ArticuloProducto articuloProducto) {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                        PreparedStatement ps = connection.prepareStatement(insert, new String[] {"id"});
                        ps.setLong(1, articuloProducto.getIdArticulo());
                        ps.setLong(2, articuloProducto.getIdProducto());
                        ps.setBoolean(3, articuloProducto.getEstado());
                        ps.setTimestamp(4, Timestamp.valueOf(articuloProducto.getFechaActualizacion()));
                        ps.setTimestamp(5, Timestamp.valueOf(articuloProducto.getFechaCreacion()));
                        return ps;
                    },
                    keyHolder);
            return keyHolder.getKey().longValue();
        }catch(Exception e){
            log.error("No fue posible insertar registro de articuloproducto en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long updateArticuloProducto(ArticuloProducto articuloProducto) {
        try{
            return (long) jdbcTemplate.update(update,
                    articuloProducto.getIdArticulo(),
                    articuloProducto.getIdProducto(),
                    articuloProducto.getEstado(),
                    articuloProducto.getFechaActualizacion(),
                    articuloProducto.getId());
        }catch(Exception e){
            log.error("No fue posible actualizar registro de articuloproducto en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long deleteArticuloProducto(Long id) {
        try{
            return (long) jdbcTemplate.update(delete, id);
        }catch(Exception e){
            log.error("No fue posible eliminar registro de articuloproducto en Base de Datos. " + e);
        }
        return 0L;
    }
}
