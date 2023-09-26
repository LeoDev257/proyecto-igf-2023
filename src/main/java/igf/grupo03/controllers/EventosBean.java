/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igf.grupo03.controllers;

import igf.grupo03.entities.Evento;
import igf.grupo03.repository.EventoRepository;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Leo
 */
@Named
@ViewScoped
public class EventosBean implements Serializable{
    
    @Inject
    EventoRepository eventoRepository;
    
    private List<Evento> eventos = new ArrayList<>();
    
    public void init(){
        eventos = eventoRepository.get(null, null);
        System.out.println(eventos);
    }

    public EventoRepository getEventoRepository() {
        return eventoRepository;
    }

    public void setEventoRepository(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    public String formatDate(LocalDate time){
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return time.format(dtFormatter);
    }
    
    public String formatHour(LocalTime time){
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("HH:mm a");
        return time.format(dtFormatter);
    }
    
}
