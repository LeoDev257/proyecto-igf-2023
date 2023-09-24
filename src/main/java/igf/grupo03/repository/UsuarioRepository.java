/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igf.grupo03.repository;

import igf.grupo03.entities.Usuario;
import igf.grupo03.utils.LoggerUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

/**
 *
 * @author Leo
 */
@ApplicationScoped
public class UsuarioRepository implements DAORepository<Usuario> {

    private static Logger LOG = Logger.getLogger(UsuarioRepository.class);
    
    @Override
    public void persist(Usuario entity) {
        Session session = FACTORY.openSession();
        Transaction t = session.beginTransaction();
        try{
            session.persist(entity);
            LOG.info(LoggerUtils.log("Usuario guardado satisfactoriamente: [%s] ", entity.getUsername()));
        }catch(Exception e){
            LOG.error(LoggerUtils.log("Error al guardar usuario: [%s] - Error: [%s]", entity.getUsername(), e.getMessage()));
        }finally {
            t.commit();
            session.close();
        }
    }

    @Override
    public void update(Usuario entity) {
        Session session = FACTORY.openSession();
        Transaction t = session.beginTransaction();
        try{
            session.merge(entity);
            LOG.info(LoggerUtils.log("Usuario actualizado satisfactoriamente: [%s] ", entity.getUsername()));
        }catch(Exception e){
            LOG.error(LoggerUtils.log("Error al actualizar usuario: [%s] - Error: [%s]", entity.getUsername(), e.getMessage()));
        }finally {
            t.commit();
            session.close();
        }
    }

    @Override
    public void delete(Usuario entity) {
        Session session = FACTORY.openSession();
        Transaction t = session.beginTransaction();
        try{
            Usuario usuario = getById(entity.getUsername());
            if(Objects.nonNull(usuario)){
                session.remove(usuario);
            }
            LOG.info(LoggerUtils.log("Usuario eliminado satisfactoriamente: [%s] ", entity.getUsername()));
        }catch(Exception e){
            LOG.error(LoggerUtils.log("Error al eliminar usuario: [%s] - Error: [%s]", entity.getUsername(), e.getMessage()));
        }finally {
            t.commit();
            session.close();
        }
    }

    @Override
    public Usuario getById(Object id) {
        Session session = FACTORY.openSession();
        Transaction t = session.beginTransaction();
        StringBuilder jpql = new StringBuilder();
        List<Usuario> results = new ArrayList<>();
        try{
            Map<String, Object> map = new HashMap<>();
            map.put("username", id);
            results = this.get("u.username = :username", map);
        }catch(Exception e){
            e.printStackTrace();
            LOG.error(LoggerUtils.log("Error al obtener resultados de búsqueda: [%s]", jpql.toString()));
        }finally {
            t.commit();
            session.close();
        }
        if(results.isEmpty()){
            return null;
        }
        return results.get(0);
    }

    @Override
    public List<Usuario> get(String query, Map<String, Object> params) {
        Session session = FACTORY.openSession();
        Transaction t = session.beginTransaction();
        StringBuilder jpql = new StringBuilder();
        List<Usuario> resultados = new ArrayList<>();
        try{
            jpql.append("SELECT u FROM Usuario u where 1 = 1");
            if(Objects.nonNull(query) && Objects.nonNull(params)){
                jpql.append(String.format(" AND %s", query));
            }
            Query q = session.createQuery(jpql.toString(), Usuario.class);
            if(Objects.nonNull(query) && Objects.nonNull(params)){
                params.forEach((k, v) -> {
                    q.setParameter(k, v);
                });
            }
            resultados.addAll(q.getResultList());
        }catch(Exception e){
            e.printStackTrace();
            LOG.error(LoggerUtils.log("Error al obtener resultados de búsqueda: [%s]", jpql.toString()));
        }finally {
            t.commit();
            session.close();
        }
        return resultados;
    }
    
}
