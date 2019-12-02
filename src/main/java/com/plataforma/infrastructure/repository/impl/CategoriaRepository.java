package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.Categoria;
import com.plataforma.domain.mappers.CategoriaMapper;
import com.plataforma.infrastructure.repository.ICategoriaRepository;
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
public class CategoriaRepository implements ICategoriaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${selectCategoria}")
    private String select;

    @Value("${selectAllCategoria}")
    private String selectAll;

    @Value("${insertCategoria}")
    private String insert;

    @Value("${updateCategoria}")
    private String update;

    @Value("${deleteCategoria}")
    private String delete;

    @Override
    public List<Categoria> selectCategoria(Long id) {
        final RowMapper<Categoria> mapper = new CategoriaMapper();
        try{
            return (List<Categoria>) jdbcTemplate.query(select, (RowMapper) mapper, id);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de categoria en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public List<Categoria> selectAllCategoria() {
        final RowMapper<Categoria> mapper = new CategoriaMapper();
        try{
            return (List<Categoria>) jdbcTemplate.query(selectAll, (RowMapper) mapper);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de categoria en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public Long insertCategoria(Categoria categoria) {
        try{
            return (long) jdbcTemplate.update(insert,
                    categoria.getNombre(),
                    categoria.getDescripcion(),
                    categoria.getEstado(),
                    categoria.getFechaActualizacion(),
                    categoria.getFechaCreacion());
        }catch(Exception e){
            log.error("No fue posible insertar registro de categoria en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long updateCategoria(Categoria categoria) {
        try{
            return (long) jdbcTemplate.update(update,
                    categoria.getNombre(),
                    categoria.getDescripcion(),
                    categoria.getEstado(),
                    categoria.getFechaActualizacion(),
                    categoria.getId());
        }catch(Exception e){
            log.error("No fue posible actualizar registro de categoria en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long deleteCategoria(Long id) {
        try{
            return (long) jdbcTemplate.update(delete, id);
        }catch(Exception e){
            log.error("No fue posible eliminar registro de categoria en Base de Datos. " + e);
        }
        return 0L;
    }
}
