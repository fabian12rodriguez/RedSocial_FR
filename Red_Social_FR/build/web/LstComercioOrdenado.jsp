
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.DTOReportes"%>
<jsp:useBean id="gestor" scope="request" class="controlador.Gestor_BD" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Reporte</title>
    </head>
    <jsp:include page="/Plantillas/PlantillaAdmin.jsp" />
    <body>

        <br>
        <div class = "row text-center justify-content-center"> 
            <div class="col-12 ">
                <button class="btn btn-primary" role="link" onclick="window.location = '/Red_Social_FR/Administracion.jsp'">Volver al menu Administracion</button>
            </div>
            <div class = "col-6">
                <br>
                <h3>Cantidad de comentarios por comercio</h3>
                <br>
                <table class="table table-striped table-primary">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Nro. Comercio</th>
                            <th scope="col">Comercio</th>
                            <th scope="col">Cantidad de comentarios</th>
                        </tr>	
                    </thead>
                    <c:forEach items="${gestor.obtenerCantComentariosComercio}" var="item">
                        <tr>
                            <th scope="row">${item.id_comercio}</th>
                            <th scope="row">${item.nombre_comercio}</th>
                            <th scope="row">${item.cantidad_comentarios}</th>
                        </tr>				
                    </c:forEach>
                </table>
            </div>	
        </div>	
    </body>
</html>
