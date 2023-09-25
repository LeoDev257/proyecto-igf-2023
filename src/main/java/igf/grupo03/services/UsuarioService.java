/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igf.grupo03.services;

import igf.grupo03.entities.Usuario;
import igf.grupo03.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 *
 * @author Leo
 */
@ApplicationScoped
public class UsuarioService {
    
    @Inject
    UsuarioRepository usuarioRepository;
    
    public Usuario getUserById(String username){
        return this.usuarioRepository.getById(username);
    }
}
