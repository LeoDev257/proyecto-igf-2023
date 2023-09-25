/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igf.grupo03.controllers;

import igf.grupo03.entities.Usuario;
import igf.grupo03.services.UsuarioService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;

/**
 *
 * @author Leo
 */
@Named
@RequestScoped
public class LoginBean implements Serializable{

    @Inject
    UsuarioService usuarioService;
    
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login(){
        
        Usuario user = this.usuarioService.getUserById(this.username);
        System.out.println("user ->" + user);
        if (user != null && user.getPassword().equals(this.password)) {
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("user", user);
            return "login-success";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Credenciales no válidas", "no valido"));         
            return "";
        }
    }
    
}
