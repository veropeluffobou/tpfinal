package com.mycompany.web.servlets;

import java.io.IOException;

import com.mycompany.web.models.AccionesTicket;
import com.mycompany.web.models.Ticket;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/verticket")
public class VerTicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id  = Integer.parseInt(req.getParameter("idticket"));

        Ticket registro = AccionesTicket.verTicket(id);

        req.setAttribute("t", registro);

        RequestDispatcher respuesta = req.getRequestDispatcher("infoticket.jsp");
        respuesta.forward(req, resp);
    }
}
