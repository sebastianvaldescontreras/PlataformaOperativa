package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.Producto;
import com.plataforma.domain.mappers.ProductoMapper;
import com.plataforma.infrastructure.repository.IProductoRepository;
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
public class ProductoRepository implements IProductoRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${selectProducto}")
    private String select;

    @Value("${selectAllProducto}")
    private String selectAll;

    @Value("${insertProducto}")
    private String insert;

    @Value("${updateProducto}")
    private String update;

    @Value("${deleteProducto}")
    private String delete;

    @Override
    public List<Producto> selectProducto(Long id) {
        final RowMapper<Producto> mapper = new ProductoMapper();
        try{
            return (List<Producto>) jdbcTemplate.query(select, (RowMapper) mapper, id);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de producto en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public List<Producto> selectAllProducto() {
        final RowMapper<Producto> mapper = new ProductoMapper();
        try{
            return (List<Producto>) jdbcTemplate.query(selectAll, (RowMapper) mapper);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de producto en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public Long insertProducto(Producto producto) {
        try{
            return (long) jdbcTemplate.update(insert,
                    producto.getCodigo(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getPrecio(),
                    producto.getEstado(),
                    producto.getFechaActualizacion(),
                    producto.getFechaCreacion());
        }catch(Exception e){
            log.error("No fue posible insertar registro de producto en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long updateProducto(Producto producto) {
        try{
            return (long) jdbcTemplate.update(update,
                    producto.getCodigo(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getPrecio(),
                    producto.getEstado(),
                    producto.getFechaActualizacion(),
                    producto.getId());
        }catch(Exception e){
            log.error("No fue posible actualizar registro de producto en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long deleteProducto(Long id) {
        try{
            return (long) jdbcTemplate.update(delete, id);
        }catch(Exception e){
            log.error("No fue posible eliminar registro de producto en Base de Datos. " + e);
        }
        return 0L;
    }
}
