
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html> 
<html lang="en">

    <head>
        <title>XENEIC || Alta Oferta</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </head>
    <jsp:include page="/Plantillas/PlantillaAdmin.jsp" />

    <jsp:useBean id="gestor" scope="request" class="controlador.Gestor_BD" />

    <jsp:useBean id="nuevoOferta" scope="session" class="modelo.Oferta" />
    <jsp:setProperty name="nuevoOferta" property="*" />

    <body>
        <div class="container-fluid">
            <br>
            <div class="row text-center justify-content-center">
                <div class="col-12 ">
                    <button class="btn btn-primary" role="link" onclick="window.location = '/Red_Social_FR/Administracion.jsp'">Volver al menu Administracion</button>

                </div>
                <div class="col-lg-4 ">
                    <br>
                    <h3>Alta de Ofertas</h3>
                     <br>
                    <form action="ABMOfertas" method="POST">

                        <div class="form-group">
                            <tr><td>Comercios</td><td>
                                    <select name="id_comercio" >
                                        <c:forEach var="ec" items="${gestor.obtenerComercios}">
                                            <option value="${ec.id_comercio}">${ec.nombre_comercio}
                                            </c:forEach>
                                    </select>
                        </div>
                        <div class="form-group">
                            <tr><td>Articulos</td><td>
                                    <select name="codigo_articulo" >
                                        <c:forEach var="ec" items="${gestor.obtenerArticulos}">
                                            <option value="${ec.codigo_articulo}">${ec.nombre_articulo}
                                            </c:forEach>
                                    </select>
                        </div>

                        <div class="form-group">
                            <label>Fecha de inicio</label>
                            <input type="text" name="fecha_inicio_oferta"  class="form-control" placeholder="Fecha de inicializacion de la oferta" required>
                        </div>
                        <div class="form-group">
                            <label>Fecha de fin</label>
                            <input type="text" name="fecha_finalizacion_oferta"  class="form-control" placeholder="Fecha de finalizacion de la oferta" required>
                        </div>
                        <div class="form-group">
                            <label>Descripcion</label>
                            <input type="text" name="descripcion_oferta"  class="form-control" placeholder="Descripcion de la oferta" required>
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" name="precio_oferta"  class="form-control" placeholder="Precio de la oferta" required>
                        </div>

                        <div class="form-group">
                            <input type="checkbox" name="vigente_oferta" class="form-check-input" value ="true">
                            <label class="form-check-label" for="exampleCheck1">Vigente</label>
                        </div>
                        <br>
                        <button class="boton" type="submit" id="nuevoComercio">Registrar</button>
                    </form>

                    <br>

                </div>
            </div>
        </div>

    </body>

</html>