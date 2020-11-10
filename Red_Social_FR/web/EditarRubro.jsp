
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Editar Rubro</title>
    </head>
      <jsp:include page="/Plantillas/PlantillaAdmin.jsp" />
    <body>
        <c:choose>
            <c:when test="${ not empty usr}">
                <div class="container-fluid">
                    <div class = "row text-center justify-content-center"> 
                        <div class="col-2 ">
                            <div class="card">
                                <article class="card-body"></article>
                                <h1 class="card-title mb-4 mt-1">${ accion } de Rubros</h1>
                                <form action="ABMRubros" method="POST">
                                    <input type="hidden" name="id_rubro" value="<jsp:getProperty name="modeloRubro" property="id_rubro"></jsp:getProperty>" />
                                        <p>
                                            <label>Descripcion de rubro: </label>
                                            <input name="descripcion_rubro"  type="text" value="<jsp:getProperty name="modeloRubro" property="descripcion_rubro"></jsp:getProperty>" />
                                        </p>
                                     

                                        <input type="submit" value="Aceptar" />
                                    </form>
                                    <br>
                                    </article>
                                </div>
                                <br>
                                <div class="col-12 ">
                                    <button class="btn btn-primary" role="link" onclick="window.location = '/Red_Social_FR/ABMRubros'">Volver al listado</button>
                                </div>
                            </div>
                        </div>
                    </div>
            </c:when>
        </c:choose>
    </body>
</html>
