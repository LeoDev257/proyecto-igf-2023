/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igf.grupo01.services;

import igf.grupo01.entities.Evento;
import igf.grupo01.repository.EventoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Leo
 */
@ApplicationScoped
public class EventoService {
    
    @Inject
    EventoRepository eventoRepository;
    
    public boolean guardarNuevoEvento(String nombre, String descripcion, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin){
        try{
            Evento evento = new Evento();
            evento.setId(8L);
            evento.setNombre(nombre);
            evento.setDescripcion(descripcion);
            evento.setFecha(fecha);
            evento.setHorainicio(horaInicio);
            evento.setHorafin(horaFin);
            evento.setEstado(fecha.getDayOfYear() - LocalDate.now().getDayOfYear() > 90 ? 20 : 10);
            eventoRepository.persist(evento);
            return true;
        }catch(Exception e){
            return false;
        }

    }
    
}
