package br.com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String address = req.getParameter("address");
        String contact = req.getParameter("contact");
        String pass= req.getParameter("pass");

        if (name.equals("") || id.equals("") || address.equals("") || contact.equals("") || pass.equals(""))   {
            resp.setContentType("text/html");
            resp.getWriter().println("<h3>Dados obrigatórios não preenchidos!</h3>");
        } else {
            req.setAttribute("name", name);
            req.setAttribute("id", id);
            req.setAttribute("address", address);
            req.setAttribute("contact", contact);
            req.setAttribute("pass", pass);

            RequestDispatcher rd = req.getRequestDispatcher("data.jsp");

            rd.forward(req, resp);
        }

    }
}