/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DTO.DTOArticulo;
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
import DTO.DTOConsulta_Oferta;
import modelo.Comercio;
import modelo.Oferta;

/**
 *
 * @author fabia
 */
@WebServlet(name = "NuevoConsulta", urlPatterns = {"/ABConsultas"})
public class ServletConsultas extends HttpServlet {

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
            out.println("<title>Servlet ServletConsultas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletConsultas at " + request.getContextPath() + "</h1>");
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
            int id_comercio = Integer.parseInt(request.getParameter("id_comercio"));

            ArrayList<DTOConsulta_Oferta> lista = gestor.getObtenerConsulta_Ofertas();
            request.setAttribute("consultas", lista);

            request.setAttribute("prueba", id_comercio);

            RequestDispatcher rd = request.getRequestDispatcher("/listadoConsultas.jsp");
            rd.forward(request, response);
        } else if (modo.equals("alta")) {

            request.setAttribute("accion", "Alta");
            ArrayList<Oferta> lista = gestor.getObtenerOfertas();
            request.setAttribute("ofertas", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/ABMComercios?modo=home");
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

        int id_oferta = Integer.parseInt(request.getParameter("id_oferta"));
        String id_consulta_oferta = (String) request.getParameter("id_consulta_oferta");
        String vecino_comentario = (String) request.getParameter("vecino_comentario");
        String descripcion_consulta_oferta = (String) request.getParameter("descripcion_consulta_oferta");

        Oferta oferta = new Oferta();
        oferta.setId_oferta(id_oferta);

        DTOConsulta_Oferta NuevoConsulta = new DTOConsulta_Oferta(oferta, vecino_comentario, descripcion_consulta_oferta);
        if (id_consulta_oferta == null) {

            gestor.agregarConsulta(NuevoConsulta);

        }

        int id_comercio = Integer.parseInt(request.getParameter("id_comercio"));
        request.setAttribute("id_comercio_oferta", id_comercio);

        ArrayList<Oferta> lista = gestor.getObtenerLista_OfertasPorId(id_comercio);
        request.setAttribute("ofertas", lista);

        RequestDispatcher rd = request.getRequestDispatcher("/pantallaOfertas.jsp");
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
