/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DTO.DTOConsulta_Oferta;
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
import modelo.Oferta;

/**
 *
 * @author fabia
 */
@WebServlet(name = "ModerarConsultas", urlPatterns = {"/ModerarConsultas"})
public class ModerarConsultas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModerarConsultas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModerarConsultas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/
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
            ArrayList<DTOConsulta_Oferta> lista = gestor.getObtenerConsulta_Ofertas();
            request.setAttribute("consultas", lista);
            
            RequestDispatcher rd = request.getRequestDispatcher("/listadoConsultas.jsp");
            rd.forward(request, response);
        } else if (modo.equals("alta")) {
            int id_consulta_oferta = Integer.parseInt(request.getParameter("id"));
            
            DTOConsulta_Oferta consulta = gestor.getObtenerConsulta_OfertasPorId(id_consulta_oferta);
            if (consulta.getRespuesta_consulta_vecino() == null) {
                consulta.setRespuesta_consulta_vecino("");
            }
            request.setAttribute("modeloConsulta", consulta);
            RequestDispatcher rd = request.getRequestDispatcher("/AltaRespuesta.jsp");
            rd.forward(request, response);
            
        } else if (modo.equals("eliminar")) {
            int id_consulta_oferta = Integer.parseInt(request.getParameter("id"));
            gestor.moderarConsulta(id_consulta_oferta);
            
            ArrayList<DTOConsulta_Oferta> lista = gestor.getObtenerConsulta_Ofertas();
            request.setAttribute("consultas", lista);
            
            RequestDispatcher rd = request.getRequestDispatcher("/listadoConsultas.jsp");
            rd.forward(request, response);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Gestor_BD gestor = new Gestor_BD();
        
        String id_consulta_oferta = (String) request.getParameter("id_consulta_oferta");
        String respuesta_consulta_vecino = (String) request.getParameter("respuesta_consulta_vecino");
        
        DTOConsulta_Oferta nuevaRespuesta = new DTOConsulta_Oferta(respuesta_consulta_vecino);
        
        nuevaRespuesta.setId_consulta_oferta(Integer.parseInt(id_consulta_oferta));
        gestor.agregarRespuesta(nuevaRespuesta);
        
        ArrayList<DTOConsulta_Oferta> lista = gestor.getObtenerConsulta_Ofertas();
        request.setAttribute("consultas", lista);
        
        RequestDispatcher rd = request.getRequestDispatcher("/listadoConsultas.jsp");
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
