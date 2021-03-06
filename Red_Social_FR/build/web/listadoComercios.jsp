
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Listado Comercios</title>
    </head>
    <jsp:include page="/Plantillas/PlantillaAdmin.jsp" />
    <body>
        <br>
        <br>
        <div class = "row text-center justify-content-center"> 
            <div class="col-12 ">
                <button class="btn btn-primary" role="link" onclick="window.location = '/Red_Social_FR/Administracion.jsp'">Volver al menu Administracion</button>
                <button class="btn btn-warning" onclick="window.location = '/Red_Social_FR/AltaComercio.jsp'">Nuevo Comercio</button> 
            </div>
            <div class = "col-6">
                <br>
                <h3>Listado de Comercios</h3>
                <br>
                <table border="3" class="table table-striped table-primary">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">NRO</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Telefono</th>
                            <th scope="col">Direccion</th>
                            <th scope="col">Email</th>
                            <th scope="col">Rubro</th>
                            <th scope="col">Estado</th>
                            <th scope="col">ACCIONES</th>
                        </tr>	
                    </thead>
                    <c:forEach items="${comercios}" var="comercio" >
                        <tr> 
                            <td>  ${comercio.id_comercio} </td>
                            <td>  ${comercio.nombre_comercio} </td>
                            <td>  ${comercio.telefono_comercio} </td>
                            <td>  ${comercio.direccion_comercio} </td>
                            <td>  ${comercio.email_comercio} </td>
                            <td>  ${comercio.rubro.descripcion_rubro} </td>

                            <td>   <c:choose>
                                    <c:when test="${comercio.vigente_comercio == true}">Activo</c:when>    
                                    <c:otherwise>Inactivo</c:otherwise>
                                </c:choose> </td>

                            <td> <a class="btn btn-warning" href="ABMComercios?modo=editar&id=${ comercio.id_comercio }">Editar</a>
                                <c:choose> 
                                    <c:when test="${comercio.vigente_comercio}">
                                        <a class="btn btn-danger"  href="ABMComercios?modo=eliminar&id=${ comercio.id_comercio }">Eliminar</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="btn btn-success"  href="ABMComercios?modo=eliminar&id=${ comercio.id_comercio }">Activar</a>
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
