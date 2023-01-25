package com.mycompany.web.servlets;

import java.io.IOException;

import com.mycompany.web.models.AccionesTicket;
import com.mycompany.web.models.Ticket;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/nuevoticket")
public class InsertarServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom, ape, cor, cant, cat;

        nom = req.getParameter("nombre");
        ape = req.getParameter("apellido");
        cor = req.getParameter("correo");
        cant = req.getParameter("cantidad");
        cat = req.getParameter("categoria");

        Ticket nuevoTicket = new Ticket();

        nuevoTicket.setNombre(nom);
        nuevoTicket.setApellido(ape);
        nuevoTicket.setCorreo(cor);
        nuevoTicket.setCantidad(cant);
        nuevoTicket.setCategoria(cat);


        int estado = AccionesTicket.registrarTicket(nuevoTicket);

        if(estado == 1){
            resp.sendRedirect("exito.jsp");
        }else {
            resp.sendRedirect("error.jsp");
        }
    }

}
