package br.com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/minhaServlet")
public class MinhaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        req.getSession().setAttribute("nome", "Guilherme Moreira");

        PrintWriter out = resp.getWriter();
        out.println("<h1>Dado gravado com sucesso!</h1>");

        resp.sendRedirect("/programacao-web-I-jee/consultaServlet");
    }
}
