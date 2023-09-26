/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igf.grupo01.controllers;

import igf.grupo01.entities.Usuario;
import igf.grupo01.services.UsuarioService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Objects;

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
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if(Objects.isNull(this.username) || this.username.isBlank()){
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Debe ingresar un usuario"));
            return "";
        }
        if(Objects.isNull(this.password) || this.password.isBlank()){
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Debe ingresar una contraseña"));
            return "";
        }
        Usuario user = this.usuarioService.getUserById(this.username);
        if(Objects.isNull(user)){
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", String.format("No se encuentra el usuario %s", this.username)));
            return "";
        }
        if(!Objects.equals(user.getPassword(), this.password)){
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", String.format("Contraseña incorrecta para el usuario %s", this.username)));
            return "";
        }
        HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(true);
        session.setAttribute("user", user);
        return "login-success";     
    }
}
