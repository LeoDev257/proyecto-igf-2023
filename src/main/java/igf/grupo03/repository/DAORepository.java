/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igf.grupo03.repository;

import java.util.List;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Leo
 * @param <T>
 */
public interface DAORepository<T> {
    final static StandardServiceRegistry SSR = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    final static Metadata META = new MetadataSources(SSR).getMetadataBuilder().build();
    final static SessionFactory FACTORY = META.getSessionFactoryBuilder().build();

    void persist(T entity);
    void update(T entity);
    void delete(T entity);
    T getById(Object id);
    List<T> get(String query, Map<String, Object> params);
}
