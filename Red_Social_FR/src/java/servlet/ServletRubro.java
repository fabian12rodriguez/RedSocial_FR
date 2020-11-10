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
import modelo.Rubro;

@WebServlet(name = "NuevoRubro", urlPatterns = {"/ABMRubros"})
public class ServletRubro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following    sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NuevoRubro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NuevoRubro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Gestor_BD gestor = new Gestor_BD();

        String usr = (String) request.getSession().getAttribute("usr");

        if (usr != null && !usr.equals("")) {

            String modo = request.getParameter("modo");
            if (modo == null || modo.isEmpty()) {
                ArrayList<Rubro> lista = gestor.getObtenerRubros();
                request.setAttribute("rubros", lista);

                RequestDispatcher rd = request.getRequestDispatcher("/listadoRubros.jsp");
                rd.forward(request, response);
            } else if (modo.equals("alta")) {
                request.setAttribute("accion", "Alta");
                ArrayList<Rubro> lista = gestor.getObtenerRubros();
                request.setAttribute("rubros", lista);
                RequestDispatcher rd = request.getRequestDispatcher("/AltaRubro.jsp");
                rd.forward(request, response);
            } else if (modo.equals("editar")) {
                request.setAttribute("accion", "Edición");
                int id_rubro = Integer.parseInt(request.getParameter("id"));

                Rubro rubro = gestor.getObtenerRubroPorId(id_rubro);
                request.setAttribute("modeloRubro", rubro);
                RequestDispatcher rd = request.getRequestDispatcher("/EditarRubro.jsp");
                rd.forward(request, response);
            } else if (modo.equals("eliminar")) {
                int id_rubro = Integer.parseInt(request.getParameter("id"));
                gestor.eliminarRubro(id_rubro);

                request.setAttribute("rubros", gestor.getObtenerRubros());

                RequestDispatcher rd = request.getRequestDispatcher("/listadoRubros.jsp");
                rd.forward(request, response);
            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        Gestor_BD gestor = new Gestor_BD();

        String id_rubro = (String) request.getParameter("id_rubro");
        String descripcion_rubro = (String) request.getParameter("descripcion_rubro");
        boolean vigente_rubro = Boolean.parseBoolean(request.getParameter("vigente_rubro"));

        Rubro nuevoRubro = new Rubro(descripcion_rubro, vigente_rubro);

        if (id_rubro == null) {

            gestor.agregarRubro(nuevoRubro);

        } else {

            nuevoRubro.setId_rubro(Integer.parseInt(id_rubro));
            gestor.modificarRubro(nuevoRubro);
        }
        ArrayList<Rubro> lista = gestor.getObtenerRubros();
        request.setAttribute("rubros", lista);
        response.sendRedirect(getServletContext().getContextPath() + "/ABMRubros");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
