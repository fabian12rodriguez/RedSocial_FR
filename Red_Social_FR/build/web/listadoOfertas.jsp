
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Listado Ofertas</title>
    </head>
     <jsp:include page="/Plantillas/PlantillaAdmin.jsp" />
    <body>
        <br>
        <br>

        <div class = "row text-center justify-content-center"> 
            <div class="col-12 ">
                <button class="btn btn-primary" role="link" onclick="window.location = '/Red_Social_FR/Administracion.jsp'">Volver al menu Administracion</button>
                <button class="btn btn-warning" onclick="window.location = 'ABMOfertas?modo=alta';">Nueva Oferta</button> 
            </div>

            <div class = "col-6">
                <br>
                <h3>Listado de Ofertas</h3>
                <br>
                <table border="3" class="table table-striped table-primary">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">NRO</th>
                            <th scope="col">Comercio</th>
                            <th scope="col">Articulo</th>
                            <th scope="col">Fecha inicio Oferta</th>
                            <th scope="col">Fecha fin Oferta</th>
                            <th scope="col">Descripcion</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Vigente</th>
                            <th scope="col">ACCIONES</th>
                        </tr>	
                    </thead>
                    <c:forEach items="${ofertas}" var="oferta" >
                        <tr> 
                            <td>  ${oferta.id_oferta} </td>
                            <td>  ${oferta.comercio.nombre_comercio} </td>
                            <td>  ${oferta.articulo.nombre_articulo} </td>
                            <td>  ${oferta.fecha_inicio_oferta} </td>
                            <td>  ${oferta.fecha_finalizacion_oferta} </td>
                            <td>  ${oferta.descripcion_oferta} </td>
                            <td>  ${oferta.precio_oferta} </td>

                            <td>   <c:choose>
                                    <c:when test="${oferta.vigente_oferta == true}">Activo</c:when>    
                                    <c:otherwise>Inactivo</c:otherwise>
                                </c:choose> </td>
                            <td> <a class="btn btn-warning" href="ABMOfertas?modo=editar&id=${  oferta.id_oferta}">Editar</a>
                                <c:choose> 
                                    <c:when test="${oferta.vigente_oferta}">
                                        <a class="btn btn-danger"  href="ABMOfertas?modo=eliminar&id=${  oferta.id_oferta }">Eliminar</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="btn btn-success"  href="ABMOfertas?modo=eliminar&id=${  oferta.id_oferta }">Activar</a>
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
