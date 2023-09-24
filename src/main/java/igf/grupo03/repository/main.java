/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igf.grupo03.repository;

import igf.grupo03.entities.Evento;
import jakarta.inject.Inject;
import java.time.LocalDateTime;

/**
 *
 * @author Leo
 */
public class main {
    
    
    public static void main(String... args) {
        EventoRepository eventoRepository = new EventoRepository();
        Evento e = new Evento();
        e.setId(5L);
        e.setEstado(10);
        e.setNombre("Evento " + e.getId());
        e.setFechaInicio(LocalDateTime.now());
        e.setFechaFin(LocalDateTime.now().plusHours(6));
        eventoRepository.persist(e);
        e.setId(6L);
        e.setEstado(10);
        e.setNombre("Evento " + e.getId());
        e.setFechaInicio(LocalDateTime.now());
        e.setFechaFin(LocalDateTime.now().plusHours(4));
        eventoRepository.persist(e);
    }
}
