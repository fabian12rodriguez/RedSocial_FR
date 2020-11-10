
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Listado Consultas</title>
    </head>
    <jsp:include page="/Plantillas/PlantillaAdmin.jsp" />
    <body>
        <br>
        <br>
        <div class = "row text-center justify-content-center"> 
            <div class="col-12 ">
                <button class="btn btn-primary" role="link" onclick="window.location = '/Red_Social_FR/Administracion.jsp'">Volver al menu Administracion</button>
            </div>
            <div class = "col-9">
                <br>
                <h3>Listado de consultas</h3>
                <br>
                <table border="3" class="table table-striped table-primary">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">NRO</th>
                            <th scope="col">VECINO</th>
                            <th scope="col">OFERTA</th>
                            <th scope="col">DESCRIPCION</th>
                            <th scope="col">RESPUESTA</th>
                            <th scope="col">ESTADO</th>
                            <th scope="col">ACCIONES</th>
                        </tr>	
                    </thead>
                    <c:forEach items="${consultas}" var="consulta" >
                        <tr>  <td>  ${consulta.id_consulta_oferta} </td>
                            <td>  ${consulta.vecino_comentario} </td>
                            <td>  ${consulta.oferta.descripcion_oferta} </td>
                            <td>  ${consulta.descripcion_consulta_oferta} </td> 
                            <td>  ${consulta.respuesta_consulta_vecino} </td> 
                            <td>   <c:choose>
                                    <c:when test="${consulta.aprobada_consulta_oferta == true}">Activo</c:when>    
                                    <c:otherwise>Inactivo</c:otherwise>
                                </c:choose> </td> 
                            <td>
                                <c:choose> 
                                    <c:when test="${consulta.respuesta_consulta_vecino == null}">
                                        <a class="btn btn-warning" href="ModerarConsultas?modo=alta&id=${  consulta.id_consulta_oferta}">Alta Respuesta</a>
                                    </c:when>
                                    <c:otherwise>

                                    </c:otherwise>
                                </c:choose>
                                <c:choose> 
                                    <c:when test="${consulta.aprobada_consulta_oferta}">
                                        <a class="btn btn-danger"  href="ModerarConsultas?modo=eliminar&id=${ consulta.id_consulta_oferta }">Eliminar</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="btn btn-success"  href="ModerarConsultas?modo=eliminar&id=${ consulta.id_consulta_oferta}">Activar</a>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </div>	

        </div>
    </body>
</html>
