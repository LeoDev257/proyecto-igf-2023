/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igf.grupo03.repository;

import igf.grupo03.entities.Evento;
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
public class EventoRepository implements DAORepository<Evento> {

    private static Logger LOG = Logger.getLogger(EventoRepository.class);
    
    @Override
    public void persist(Evento entity) {
        Session session = FACTORY.openSession();
        Transaction t = session.beginTransaction();
        try{
            session.persist(entity);
            LOG.info(LoggerUtils.log("Evento guardado satisfactoriamente: [%s] ", entity.getId()));
        }catch(Exception e){
            LOG.error(LoggerUtils.log("Error al guardar evento: [%s] - Error: [%s]", entity.getId(), e.getMessage()));
        }finally {
            t.commit();
            session.close();
        }
    }

    @Override
    public void update(Evento entity) {
        Session session = FACTORY.openSession();
        Transaction t = session.beginTransaction();
        try{
            session.merge(entity);
            LOG.info(LoggerUtils.log("Evento actualizado satisfactoriamente: [%s] ", entity.getId()));
        }catch(Exception e){
            LOG.error(LoggerUtils.log("Error al actualizar evento: [%s] - Error: [%s]", entity.getId(), e.getMessage()));
        }finally {
            t.commit();
            session.close();
        }
    }

    @Override
    public void delete(Evento entity) {
        Session session = FACTORY.openSession();
        Transaction t = session.beginTransaction();
        try{
            Evento evento = getById(entity.getId());
            if(Objects.nonNull(evento)){
                session.remove(evento);
            }
            LOG.info(LoggerUtils.log("Evento eliminado satisfactoriamente: [%s] ", entity.getId()));
        }catch(Exception e){
            LOG.error(LoggerUtils.log("Error al eliminar evento: [%s] - Error: [%s]", entity.getId(), e.getMessage()));
        }finally {
            t.commit();
            session.close();
        }
    }

    @Override
    public Evento getById(Object id) {
        Session session = FACTORY.openSession();
        Transaction t = session.beginTransaction();
        StringBuilder jpql = new StringBuilder();
        List<Evento> results = new ArrayList<>();
        try{
            Map<String, Object> map = new HashMap<>();
            map.put("username", id);
            results = this.get("u.id = :id", map);
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
    public List<Evento> get(String query, Map<String, Object> params) {
        Session session = FACTORY.openSession();
        Transaction t = session.beginTransaction();
        StringBuilder jpql = new StringBuilder();
        List<Evento> resultados = new ArrayList<>();
        try{
            jpql.append("SELECT u FROM Evento u where 1 = 1");
            if(Objects.nonNull(query) && Objects.nonNull(params)){
                jpql.append(String.format(" AND %s", query));
            }
            Query q = session.createQuery(jpql.toString(), Evento.class);
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
