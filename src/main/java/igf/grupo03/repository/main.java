/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igf.grupo03.repository;

import igf.grupo03.entities.Evento;
import igf.grupo03.entities.Usuario;
import jakarta.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Leo
 */
public class main {
    
    
    public static void main(String... args) {
        EventoRepository eventoRepository = new EventoRepository();
//        for (int i = 2; i < 9; i++) {
//            Evento e = new Evento();
//            e.setId(Long.valueOf(i));
//            e.setEstado(10);
//            e.setNombre("Evento " + e.getId());
//            e.setDescripcion("Descripcion de evento " + e.getId());
//            e.setFecha(LocalDate.now().plusDays(e.getId()));
//            e.setHorainicio(LocalTime.now());
//            e.setHorafin(LocalTime.now().plusHours(e.getId()));
//            eventoRepository.update(e);
//        }

//        Usuario u = new Usuario();
//        u.setUsername("admin");
//        u.setPassword("admin");
//        u.setFechacrea(LocalDateTime.now().minusDays(4));
//        u.setTipo(10);
//        new UsuarioRepository().update(u);
    }
}
