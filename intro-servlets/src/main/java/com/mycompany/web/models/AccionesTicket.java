package com.mycompany.web.models;
import com.mycompany.web.models.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccionesTicket {
    //insertar registro
    public static int registrarTicket(Ticket t){
        int estado = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver"); //OJO!!!EN CADA CONECCION DEBEREMOS CARGAR LA CLASE PRIMERO PARA PODER IDENTIFICAR AL DRIVER Y CONECTARNOS A LA BBDD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/conferencias","root","");
    
            String query = "INSERT INTO ticket(nombre,apellido,correo,cantidad,categoria) VALUES (?,?,?,?,?)";
    
            
            String nombre = t.getNombre();
            String apellido = t.getApellido();
            String correo = t.getCorreo();
            String cantidad = t.getCantidad();
            String categoria = t.getCategoria();
    
            PreparedStatement pst = conexion.prepareStatement(query);
            
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, correo);
            pst.setString(4, cantidad);
            pst.setString(5, categoria);
    
            estado = pst.executeUpdate();
    
            conexion.close();
    
    
        } catch (Exception e){
            System.out.println(e);
            System.out.println("uppsss algo salio mal");
        }
    
        return estado;

    }

    //actualizar registro

public static int actualizarTicket(Ticket t){
    int estado = 0;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/conferencias","root","");

        String query = "UPDATE ticket SET nombre=?,apellido=?,correo=?,cantidad=?,categoria=? WHERE id_ticket=?";

        int id = t.getId();
        String nombre = t.getNombre();
        String apellido = t.getApellido();
        String correo = t.getCorreo();
        String cantidad = t.getCantidad();
        String categoria = t.getCategoria();

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setString(1, nombre);
        pst.setString(2, apellido);
        pst.setString(3, correo);
        pst.setString(4, cantidad);
        pst.setString(5, categoria);
        pst.setInt(6, id);

        estado = pst.executeUpdate();

        conexion.close();


    } catch (Exception e){
        System.out.println("uppsss algo salio mal");
    }

    return estado;
}

//consultar registro por id

public static Ticket verTicket(int idAConsultar){
    Ticket ticketADevolver = new Ticket();

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/conferencias","root","");

        String query = "SELECT * FROM ticket WHERE id_ticket=?";

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setInt(1, idAConsultar);

        ResultSet consultaTicket = pst.executeQuery();

        if (consultaTicket.next()){
            ticketADevolver.setId( consultaTicket.getInt(1));
            ticketADevolver.setNombre( consultaTicket.getString(2));
            ticketADevolver.setApellido( consultaTicket.getString(3));
            ticketADevolver.setCorreo( consultaTicket.getString(4));
            ticketADevolver.setCantidad( consultaTicket.getString(5));
            ticketADevolver.setCategoria( consultaTicket.getString(6));
            conexion.close();
        }
    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salio mal");
    }

    return ticketADevolver;
} 

//consultar todos los registros de una tabla

public static List<Ticket> verTodosTickets(){
    List<Ticket> listaTicketsADevolver = new ArrayList<Ticket>();
    

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/conferencias","root","");

        String query = "SELECT * FROM ticket";

        PreparedStatement pst = conexion.prepareStatement(query);

        ResultSet consultaTicket = pst.executeQuery();

        while (consultaTicket.next()){
            Ticket ticketADevolver = new Ticket(); //EN CADA VUELTA NECESITAREMOS INSTANCIAR UN NUEVO OBJETO
            ticketADevolver.setId( consultaTicket.getInt(1));
            ticketADevolver.setNombre( consultaTicket.getString(2));
            ticketADevolver.setApellido( consultaTicket.getString(3));
            ticketADevolver.setCorreo( consultaTicket.getString(4));
            ticketADevolver.setCantidad( consultaTicket.getString(5));
            ticketADevolver.setCategoria( consultaTicket.getString(6));
            listaTicketsADevolver.add(ticketADevolver);
        }
        conexion.close();
    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salio mal");
    }

    return listaTicketsADevolver;
} 

    
}