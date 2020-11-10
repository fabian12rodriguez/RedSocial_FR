/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DTO.DTOComentario_Comercio;
import controlador.Gestor_BD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Comercio;

/**
 *
 * @author fabia
 */
@WebServlet(name = "NuevoComentario", urlPatterns = {"/AComentario"})
public class ServletComentario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletComentario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletComentario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gestor_BD gestor = new Gestor_BD();

        String modo = request.getParameter("modo");
        if (modo == null || modo.isEmpty()) {

            int id_comercio = Integer.parseInt(request.getParameter("id_comercio"));

            ArrayList<DTOComentario_Comercio> lista = gestor.getObtenerComentarioPorComercio(id_comercio);
            request.setAttribute("comentarios", lista);

            request.setAttribute("prueba", id_comercio);

            RequestDispatcher rd = request.getRequestDispatcher("/pantallaComentarios.jsp");
            rd.forward(request, response);

        } else if (modo.equals("alta")) {
            request.setAttribute("accion", "Alta");
            ArrayList<DTOComentario_Comercio> lista = gestor.getObtenerComentarios_comercios();
            request.setAttribute("comentarios", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/pantallaComentarios.jsp");
            rd.forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gestor_BD gestor = new Gestor_BD();

        int id_comercio = Integer.parseInt(request.getParameter("id_comercio"));

        String id_comentario = (String) request.getParameter("id_comentario");

        String vecino_comentario = (String) request.getParameter("vecino_comentario");
        String descripcion_comentario = (String) request.getParameter("descripcion_comentario");
        int valoracion_comercio = Integer.parseInt(request.getParameter("valoracion_comercio"));

        Comercio comercios = new Comercio();
        comercios.setId_comercio(id_comercio);

        DTOComentario_Comercio nuevoComentario = new DTOComentario_Comercio(comercios, vecino_comentario, descripcion_comentario, valoracion_comercio);

        if (id_comentario == null) {

            gestor.agregarComentario(nuevoComentario);

        }

        ArrayList<DTOComentario_Comercio> lista = gestor.getObtenerComentarioPorComercio(id_comercio);
        request.setAttribute("comentarios", lista);

        request.setAttribute("prueba", id_comercio);

        RequestDispatcher rd = request.getRequestDispatcher("/pantallaComentarios.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
