package com.mycompany.web.models;
import java.io.Serializable;

public class Ticket implements Serializable{
    private int id;
    private String nombre, apellido,correo,cantidad,categoria;

    public Ticket(){

    }

    public int getId(){
        return id;
    }

    public void setId(int nuevoId){
        this.id = nuevoId;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nuevoNombre){
        this.nombre = nuevoNombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String nuevoApellido){
        this.apellido = nuevoApellido;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String nuevoCorreo){
        this.correo = nuevoCorreo;
    }
    
    public String getCantidad(){
        return cantidad;
    }

    public void setCantidad(String nuevoCantidad){
        this.cantidad = nuevoCantidad;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setCategoria(String nuevoCategoria){
        this.categoria = nuevoCategoria;
    }   

}