    
<%@page import="controlador.Gestor_BD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="gestor" scope="request" class="controlador.Gestor_BD" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Ofertas</title>
    </head>
    <jsp:include page="/Plantillas/PlantillaMenu.jsp" />
    <body>
        <div class="container-fluid">
            <h1 class="display-4 text-center">OFERTAS</h1>
            <div class="row"> 
                <c:forEach items="${ofertas}" var="oferta" >
                    <div class="col-4">
                        <div class="card mb-4">
                            <div class="card-body text-center">
                                <h4 class="display-4">${oferta.descripcion_oferta}</h4>
                                <p class="lead">Fecha de inicio: ${oferta.fecha_inicio_oferta}</p>
                                <p class="lead">Fecha de finalizacion: ${oferta.fecha_finalizacion_oferta}</p>
                                <p class="lead">Articulo: ${oferta.articulo.nombre_articulo}</p>
                                <h5 class="mb-5">Precio: $${oferta.precio_oferta}</h5>
                                <h3>Dejar Consulta</h3>
                                <form action="ABConsultas" method="POST">
                                    <input type="hidden" name="id_comercio" value="${id_comercio_oferta}">

                                    <input type="hidden" name="id_oferta" value="${oferta.id_oferta}">

                                    <div class="form-group">
                                        <label>Nombre: </label>
                                        <input type="text" name="vecino_comentario"  class="form-control" placeholder="Su nombre" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Consulta: </label>
                                        <input type="text" name="descripcion_consulta_oferta"  class="form-control" placeholder="Consulta" required>
                                    </div>

                                    <input type="submit" value="Aceptar" />
                              
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div> 
            <h1 class="display-4 text-center">CONSULTAS</h1>
            <input type="hidden" name="id_comercio" value="${id_comercio_oferta}">

            <div class="row"> 
                <c:forEach items="${gestor.getObtenerConsulta_OfertasPorComercio(id_comercio_oferta)}" var="consulta" >
                    <div class="col-4">
                        <div class="card mb-4">
                            <div class="card-body text-center">
                                <p class="lead">Vecino: ${consulta.vecino_comentario}</p>
                                <p class="lead">Descripcion Oferta: ${consulta.oferta.descripcion_oferta}</p>
                                <p class="lead">Consulta: ${consulta.descripcion_consulta_oferta}</p>
                                <p class="lead">Respuesta del comercio: ${consulta.respuesta_consulta_vecino}</p>

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>  
        </div>
    </div>
</body>
</html>
