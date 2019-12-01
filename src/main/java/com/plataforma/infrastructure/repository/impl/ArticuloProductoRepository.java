package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.ArticuloProducto;
import com.plataforma.domain.mappers.ArticuloProductoMapper;
import com.plataforma.infrastructure.repository.IArticuloProductoRepository;
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
public class ArticuloProductoRepository implements IArticuloProductoRepository {
    @Value("${articuloproducto.select}")
    private String select;

    @Value("${articuloproducto.selectAll}")
    private String selectAll;

    @Value("${articuloproducto.insert}")
    private String insert;

    @Value("${articuloproducto.update}")
    private String update;

    @Value("${articuloproducto.delete}")
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
            return (long) jdbcTemplate.update(insert,
                    articuloProducto.getIdArticulo(),
                    articuloProducto.getIdProducto(),
                    articuloProducto.getEstado(),
                    articuloProducto.getFechaActualizacion(),
                    articuloProducto.getFechaCreacion());
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
