/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DTO.DTOArticulo;
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
import modelo.Comercio;
import modelo.Oferta;

/**
 *
 * @author fabia
 */
@WebServlet(name = "NuevoOferta", urlPatterns = {"/ABMOfertas"})
public class ServletOferta extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletOferta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletOferta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gestor_BD gestor = new Gestor_BD();

      

     
        String modo = request.getParameter("modo");
        if (modo == null || modo.isEmpty()) {
            ArrayList<Oferta> lista = gestor.getObtenerOfertas();
            request.setAttribute("ofertas", lista);

            RequestDispatcher rd = request.getRequestDispatcher("/listadoOfertas.jsp");
            rd.forward(request, response);
        } else if (modo.equals("alta")) {
            request.setAttribute("accion", "Alta");
            ArrayList<Oferta> lista = gestor.getObtenerOfertas();
            request.setAttribute("ofertas", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/AltaOferta.jsp");
            rd.forward(request, response);
        } else if (modo.equals("editar")) {
            request.setAttribute("accion", "Edición");
            int id_oferta = Integer.parseInt(request.getParameter("id"));

            Oferta oferta = gestor.getObtenerOfertaPorId(id_oferta);
            request.setAttribute("modeloOferta", oferta);
            RequestDispatcher rd = request.getRequestDispatcher("/EditarOferta.jsp");
            rd.forward(request, response);
        } else if (modo.equals("eliminar")) {
            int id_oferta = Integer.parseInt(request.getParameter("id"));
            gestor.eliminarOferta(id_oferta);

            ArrayList<Oferta> lista = gestor.getObtenerOfertas();
            request.setAttribute("ofertas", lista);

            RequestDispatcher rd = request.getRequestDispatcher("/listadoOfertas.jsp");
            rd.forward(request, response);
        } else if (modo.equals("traerOferta")) {

            int id_comercio = Integer.parseInt(request.getParameter("id"));
            
            request.setAttribute("id_comercio_oferta", id_comercio);

            ArrayList<Oferta> lista = gestor.getObtenerLista_OfertasPorId(id_comercio);
            request.setAttribute("ofertas", lista);

            RequestDispatcher rd = request.getRequestDispatcher("/pantallaOfertas.jsp");
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
        String id_oferta = (String) request.getParameter("id_oferta");
        int id_comercio = Integer.parseInt(request.getParameter("id_comercio"));
        int codigo_articulo = Integer.parseInt(request.getParameter("codigo_articulo"));
        String fecha_inicio_oferta = (String) request.getParameter("fecha_inicio_oferta");
        String fecha_finalizacion_oferta = (String) request.getParameter("fecha_finalizacion_oferta");
        String descripcion_oferta = (String) request.getParameter("descripcion_oferta");
        float precio_oferta = Float.parseFloat(request.getParameter("precio_oferta"));
        boolean vigente_comercio = Boolean.parseBoolean(request.getParameter("vigente_comercio"));

        DTOArticulo articulo = new DTOArticulo();
        articulo.setCodigo_articulo(codigo_articulo);

        Comercio comercio = new Comercio();
        comercio.setId_comercio(id_comercio);

        Oferta nuevaOferta = new Oferta(comercio, articulo, fecha_inicio_oferta, fecha_finalizacion_oferta, descripcion_oferta, precio_oferta, vigente_comercio);

        if (id_oferta == null) {

            gestor.agregarOferta(nuevaOferta);

        } else {

            nuevaOferta.setId_oferta(Integer.parseInt(id_oferta));
            gestor.modificarOferta(nuevaOferta);
        }
        ArrayList<Oferta> lista = gestor.getObtenerOfertas();
        request.setAttribute("ofertas", lista);
        response.sendRedirect(getServletContext().getContextPath() + "/ABMOfertas");

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
