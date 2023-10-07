/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igf.grupo01.controllers;

import igf.grupo01.entities.Evento;
import igf.grupo01.repository.EventoRepository;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DialogFrameworkOptions;

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
    
    public String agregarNuevoEvento(){
        DialogFrameworkOptions options = DialogFrameworkOptions.builder()
            .resizable(false)
            .draggable(false)
            .modal(false)
            .build();
        //PrimeFaces.current().dialog().openDynamic("agregarEvento", options, null);
        //return "agregar-nuevo-evento"
        return "agregarEvento";
    }
    
}
