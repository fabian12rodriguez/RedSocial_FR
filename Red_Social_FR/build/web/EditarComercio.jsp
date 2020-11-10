
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="gestor" scope="request" class="controlador.Gestor_BD" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Editar Comercio</title>
    </head>
    <jsp:include page="/Plantillas/PlantillaAdmin.jsp" />
    <body>
        <c:choose>
            <c:when test="${ not empty usr}">
                <div class="container-fluid">
                    <div class = "row text-center justify-content-center"> 
                        <div class="col-6 ">
                            <div class="card">
                                <article class="card-body"></article>
                                <h1 class="card-title mb-4 mt-1">${ accion } de Comercio</h1>
                                <form action="ABMComercios" method="POST">
                                    <input type="hidden" name="id_comercio" value="<jsp:getProperty name="modeloComercio" property="id_comercio"></jsp:getProperty>" />
                                        <p>
                                            <label>Nombre de comercio: </label>
                                            <input name="nombre_comercio"  type="text" value="<jsp:getProperty name="modeloComercio" property="nombre_comercio"></jsp:getProperty>" />
                                        </p>
                                        <p>
                                            <label>Telefono de comercio: </label>
                                            <input name="telefono_comercio"  type="text" value="<jsp:getProperty name="modeloComercio" property="telefono_comercio"></jsp:getProperty>" />
                                        </p>
                                        <p>
                                            <label>Descripcion de comercio: </label>
                                            <input name="direccion_comercio"  type="text" value="<jsp:getProperty name="modeloComercio" property="direccion_comercio"></jsp:getProperty>" />
                                        </p>
                                        <p>
                                            <label>Email: </label>
                                            <input name="email_comercio"  type="text" value="<jsp:getProperty name="modeloComercio" property="email_comercio"></jsp:getProperty>" />
                                        </p>

                                        <p>
                                            <label>Descripcion de rubro: </label>
                                            <select name="descripcion_rubro">
                                            <c:forEach items="${ gestor.obtenerRubros }" var="item">
                                                <option value="${ item.id_rubro }" <c:if test="${ item.id_rubro == modeloComercio.rubro.id_rubro}">selected</c:if>>${ item.descripcion_rubro }</option>
                                            </c:forEach>
                                        </select>

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
