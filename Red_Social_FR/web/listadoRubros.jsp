
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Listado Rubros</title>
    </head>
    <jsp:include page="/Plantillas/PlantillaAdmin.jsp" />
    <body>
        <br>
        <br>

        <div class = "row text-center justify-content-center"> 
            <div class="col-12 ">
                <button class="btn btn-primary" role="link" onclick="window.location = '/Red_Social_FR/Administracion.jsp'">Volver al menu Administracion</button>
                <button class="btn btn-warning" onclick="window.location = 'ABMRubros?modo=alta';">Nuevo Rubro</button> 
            </div>
           
            <div class = "col-6">
                 <br>
                <h3>Listado de rubros</h3>
                <br>
                <table border="3" class="table table-striped table-primary">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">NRO</th>
                            <th scope="col">RUBROS</th>
                            <th scope="col">ESTADO</th>
                            <th scope="col">ACCIONES</th>
                        </tr>	
                    </thead>
                    <c:forEach items="${rubros}" var="rubro" >
                        <tr> 
                            <td>  ${rubro.id_rubro} </td>
                            <td>  ${rubro.descripcion_rubro} </td>
                            <td>   <c:choose>
                                    <c:when test="${rubro.vigente_rubro == true}">Activo</c:when>    
                                    <c:otherwise>Inactivo</c:otherwise>
                                </c:choose> </td>
                            <td> <a class="btn btn-warning" href="ABMRubros?modo=editar&id=${ rubro.id_rubro }">Editar</a>
                                <c:choose> 
                                    <c:when test="${rubro.vigente_rubro}">
                                        <a class="btn btn-danger"  href="ABMRubros?modo=eliminar&id=${ rubro.id_rubro }">Eliminar</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="btn btn-success"  href="ABMRubros?modo=eliminar&id=${ rubro.id_rubro }">Activar</a>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>

            </div>	

        </div>
    </body>
</html>
