/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
import modelo.Rubro;

/**
 *
 * @author fabia
 */
@WebServlet(name = "NuevoComercio", urlPatterns = {"/ABMComercios"})
public class ServletComercio extends HttpServlet {

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
            out.println("<title>Servlet ServletComercio</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletComercio at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gestor_BD gestor = new Gestor_BD();

      /*  String usr = (String) request.getSession().getAttribute("usr");*/ 

       /* if (usr != null && !usr.equals("")) {*/

            String modo = request.getParameter("modo");
            if (modo == null || modo.isEmpty()) {
                ArrayList<Comercio> lista = gestor.getObtenerComercios();
                request.setAttribute("comercios", lista);

                RequestDispatcher rd = request.getRequestDispatcher("/listadoComercios.jsp");
                rd.forward(request, response);
            } else if (modo.equals("alta")) {
                request.setAttribute("accion", "Alta");
                ArrayList<Comercio> lista = gestor.getObtenerComercios();
                request.setAttribute("comercios", lista);
                RequestDispatcher rd = request.getRequestDispatcher("/listadoComercios.jsp");
                rd.forward(request, response);
            } else if (modo.equals("editar")) {
                request.setAttribute("accion", "Edición");
                int id_comercio = Integer.parseInt(request.getParameter("id"));

                Comercio comercio = gestor.getObtenerComercioPorId(id_comercio);
                request.setAttribute("modeloComercio", comercio);
                
                RequestDispatcher rd = request.getRequestDispatcher("/EditarComercio.jsp");
                rd.forward(request, response);

            } else if (modo.equals("eliminar")) {
                int id_comercio = Integer.parseInt(request.getParameter("id"));
                gestor.eliminarComercio(id_comercio);

                ArrayList<Comercio> lista = gestor.getObtenerComercios();
                request.setAttribute("comercios", lista);

                RequestDispatcher rd = request.getRequestDispatcher("/listadoComercios.jsp");
                rd.forward(request, response);
            } else if (modo.equals("home")) {
                ArrayList<Comercio> lista = gestor.getObtenerComercios();
                request.setAttribute("comercios", lista);

                RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
                rd.forward(request, response);
            } else if (modo.equals("altaConsulta")) {
                request.setAttribute("accion", "Alta");
                ArrayList<Comercio> lista = gestor.getObtenerComercios();
                request.setAttribute("comercios", lista);
                RequestDispatcher rd = request.getRequestDispatcher("/pantallaOfertas.jsp");
                rd.forward(request, response);
            }
        /*} else {
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }*/
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

        String id_comercio = (String) request.getParameter("id_comercio");
        String nombre_comercio = (String) request.getParameter("nombre_comercio");
        String telefono_comercio = (String) request.getParameter("telefono_comercio");
        String direccion_comercio = (String) request.getParameter("direccion_comercio");
        String email_comercio = (String) request.getParameter("email_comercio");
        boolean vigente_comercio = Boolean.parseBoolean(request.getParameter("vigente_comercio"));

        int id_rubro = Integer.parseInt(request.getParameter("descripcion_rubro"));
        Rubro rubro = new Rubro();
        rubro.setId_rubro(id_rubro);

        Comercio nuevoComercio = new Comercio(nombre_comercio, telefono_comercio, direccion_comercio, email_comercio, rubro, vigente_comercio);

        if (id_comercio == null) {

            gestor.agregarComercio(nuevoComercio);

        } else {

            nuevoComercio.setId_comercio(Integer.parseInt(id_comercio));
            gestor.modificarComercio(nuevoComercio);

        }
        ArrayList<Comercio> lista = gestor.getObtenerComercios();
        request.setAttribute("comercios", lista);

        response.sendRedirect(getServletContext().getContextPath() + "/ABMComercios");

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
