
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Buscar Ofertas</title>
    </head>
    <jsp:include page="/Plantillas/PlantillaMenu.jsp" />
    <body>

    <body>
        <div class="container-fluid">
            <h1 class="display-4 text-center">OFERTAS</h1>
            <form action="BuscarOfertas" method="POST">
                <div class="col-3">
                    <label>Buscador</label>
                    <input type="text" name="palabra"  class="form-control" placeholder="Ingrese descripcion de la oferta" required>
                    <br>
                    <button class="btn btn-primary" onclick="window.location = 'BuscarOfertas?modo=buscar';">Buscar</button> 

            </form>
        </div>
        <div class="row"> 
            <c:forEach items="${ofertas}" var="oferta" >
                <div class="col-4">
                    <div class="card mb-4">
                        <div class="card-body text-center">
                            <h4 class="display-4">${oferta.descripcion_oferta}</h4>
                            <p class="lead">Comercio: ${oferta.comercio.nombre_comercio}</p>
                            <p class="lead">Fecha de inicio: ${oferta.fecha_inicio_oferta}</p>
                            <p class="lead">Fecha de finalizacion: ${oferta.fecha_finalizacion_oferta}</p>
                            <p class="lead">Articulo: ${oferta.articulo.nombre_articulo}</p>
                            <h5 class="mb-5">Precio: $${oferta.precio_oferta}</h5>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>
</div>
</body>
</html>
