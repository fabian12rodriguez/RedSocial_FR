
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Home</title>
    </head>
    <jsp:include page="/Plantillas/PlantillaMenu.jsp" />
    <body>
        <div class="container-fluid">

            <h1 class="display-4 text-center">COMERCIOS</h1>
            <div class="row"> 
                <c:forEach items="${comercios}" var="comercio" >
                    <div class="col-4">
                        <div class="card mb-4">
                            <div class="card-body text-center">
                                <h4 class="display-4">${comercio.nombre_comercio}</h4>
                                <p class="lead">${comercio.rubro.descripcion_rubro}</p>
                                <p class="lead">${comercio.direccion_comercio}</p>
                                <h5 class="mb-5"> ${comercio.telefono_comercio}</h5>

                                <div class="col-12 text-center"> 
                                    <a class="shadow boton_home btn-primary" onclick="window.location = '${pageContext.request.contextPath}/ABMOfertas?modo=traerOferta&id=${comercio.id_comercio}'">Ver todas las ofertas</a>
                                    <a class="shadow boton_home btn-warning" onclick="window.location = '${pageContext.request.contextPath}/AComentario?id_comercio=${comercio.id_comercio}'">Valorar Comercio</a>
                              

                                </div>

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
