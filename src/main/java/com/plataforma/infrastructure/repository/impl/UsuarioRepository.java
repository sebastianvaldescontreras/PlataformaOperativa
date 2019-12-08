package com.plataforma.infrastructure.repository.impl;

import com.plataforma.domain.entities.Usuario;
import com.plataforma.domain.mappers.UsuarioMapper;
import com.plataforma.infrastructure.repository.IUsuarioRepository;
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
public class UsuarioRepository implements IUsuarioRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${selectUsuario}")
    private String select;

    @Value("${selectAllUsuario}")
    private String selectAll;

    @Value("${insertUsuario}")
    private String insert;

    @Value("${updateUsuario}")
    private String update;

    @Value("${deleteUsuario}")
    private String delete;

    @Override
    public List<Usuario> selectUsuario(Long id) {
        final RowMapper<Usuario> mapper = new UsuarioMapper();
        try{
            return (List<Usuario>) jdbcTemplate.query(select, (RowMapper) mapper, id);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de usuario en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public List<Usuario> selectAllUsuario() {
        final RowMapper<Usuario> mapper = new UsuarioMapper();
        try{
            return (List<Usuario>) jdbcTemplate.query(selectAll, (RowMapper) mapper);
        }catch(Exception e){
            log.error("No fue posible seleccionar registro de usuario en Base de Datos. " + e);
        }
        return null;
    }

    @Override
    public Long insertUsuario(Usuario usuario) {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                        PreparedStatement ps = connection.prepareStatement(insert, new String[] {"id"});
                        ps.setLong(1, usuario.getIdrol());
                        ps.setString(2, usuario.getTipoDocumento());
                        ps.setString(3, usuario.getNumeroDocumento());
                        ps.setString(4, usuario.getNombre());
                        ps.setString(5, usuario.getApellido());
                        ps.setString(6, usuario.getDireccion());
                        ps.setString(7, usuario.getTelefono());
                        ps.setString(8, usuario.getEmail());
                        ps.setString(9, usuario.getClave());
                        ps.setBoolean(10, usuario.getEstado());
                        ps.setTimestamp(11, Timestamp.valueOf(usuario.getFechaActualizacion()));
                        ps.setTimestamp(12, Timestamp.valueOf(usuario.getFechaCreacion()));
                        return ps;
                    },
                    keyHolder);
            return keyHolder.getKey().longValue();
        }catch(Exception e){
            log.error("No fue posible insertar registro de usuario en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long updateUsuario(Usuario usuario) {
        try{
            return (long) jdbcTemplate.update(update,
                    usuario.getIdrol(),
                    usuario.getTipoDocumento(),
                    usuario.getNumeroDocumento(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getDireccion(),
                    usuario.getTelefono(),
                    usuario.getEmail(),
                    usuario.getClave(),
                    usuario.getEstado(),
                    usuario.getFechaActualizacion(),
                    usuario.getId());
        }catch(Exception e){
            log.error("No fue posible actualizar registro de usuario en Base de Datos. " + e);
        }
        return 0L;
    }

    @Override
    public Long deleteUsuario(Long id) {
        try{
            return (long) jdbcTemplate.update(delete, id);
        }catch(Exception e){
            log.error("No fue posible eliminar registro de usuario en Base de Datos. " + e);
        }
        return 0L;
    }
}
