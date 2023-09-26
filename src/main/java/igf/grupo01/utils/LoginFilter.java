/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igf.grupo01.utils;

import igf.grupo01.entities.Usuario;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Leo
 */
public class LoginFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doing filter");
        final String LOGIN_PAGE = "/loginpage/login.xhtml";       
        final String WELCOME_PAGE = "/eventos.xhtml";
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;        
        Usuario user = (Usuario) httpServletRequest.getSession().getAttribute("user");
        System.out.println(httpServletRequest.getRequestURI());
        if (user != null) {
            if (httpServletRequest.getRequestURI().endsWith(LOGIN_PAGE)) {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + WELCOME_PAGE);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            if (!httpServletRequest.getRequestURI().endsWith(LOGIN_PAGE) && 
                    !httpServletRequest.getRequestURI().contains("show.jpg") && 
                    !httpServletRequest.getRequestURI().contains("hide.jpg") &&
                    !httpServletRequest.getRequestURI().contains("styles.css") &&
                    !httpServletRequest.getRequestURI().contains("scripts.js")) {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_PAGE);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    

    
}
