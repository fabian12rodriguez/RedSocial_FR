
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="gestor" scope="request" class="controlador.Gestor_BD" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Editar Oferta</title>
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
                                <h1 class="card-title mb-4 mt-1">${ accion } de Oferta</h1>
                                <form action="ABMOfertas" method="POST">
                                    <input type="hidden" name="id_oferta" value="<jsp:getProperty name="modeloOferta" property="id_oferta"></jsp:getProperty>" />
                                        <div class="form-group">
                                            <tr><td>Comercios</td><td>
                                                    <select name="id_comercio">
                                                    <c:forEach items="${ gestor.obtenerComercios }" var="item">
                                                        <option value="${ item.id_comercio }" <c:if test="${ item.id_comercio == modeloOferta.comercio.id_comercio}">selected</c:if>>${ item.nombre_comercio }</option>
                                                    </c:forEach>
                                                </select>
                                    </div>
                                    <div class="form-group">
                                        <tr><td>Articulos</td><td>
                                                <select name="codigo_articulo">
                                                    <c:forEach items="${ gestor.obtenerArticulos }" var="item">
                                                        <option value="${ item.codigo_articulo }" <c:if test="${ item.codigo_articulo == modeloOferta.articulo.codigo_articulo}">selected</c:if>>${ item.nombre_articulo }</option>
                                                    </c:forEach>
                                                </select>
                                    </div>

                                    <div class="form-group">
                                        <label>Fecha de inicio</label>
                                        <input type="text" name="fecha_inicio_oferta"  value="<jsp:getProperty name="modeloOferta" property="fecha_inicio_oferta"></jsp:getProperty>" />
                                        </div>
                                        <div class="form-group">
                                            <label>Fecha de fin</label>
                                            <input type="text" name="fecha_finalizacion_oferta"  value="<jsp:getProperty name="modeloOferta" property="fecha_finalizacion_oferta"></jsp:getProperty>" />
                                        </div>
                                        <div class="form-group">
                                            <label>Descripcion</label>
                                            <input type="text" name="descripcion_oferta"  value="<jsp:getProperty name="modeloOferta" property="descripcion_oferta"></jsp:getProperty>" />
                                        </div>
                                        <div class="form-group">
                                            <label>Precio</label>
                                            <input type="text" name="precio_oferta"  value="<jsp:getProperty name="modeloOferta" property="precio_oferta"></jsp:getProperty>" />
                                        </div>
                                        <br>
                                        <input type="submit" value="Aceptar" />
                                    </form>

                                    <br>
                                    <div class="col-12 ">
                                        <button class="btn btn-primary" role="link" onclick="window.location = '/Red_Social_FR/ABMOfertas'">Volver al listado</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </c:when>
        </c:choose>
    </body>
</html>
