package igf.grupo01.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class IndexBean implements Serializable{

    private List<String> names;
    private String name;

    @PostConstruct
    public void init(){
        names = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
    
    public void agregar(){
        names.add(name);
    }
}
