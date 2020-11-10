
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="gestor" scope="request" class="controlador.Gestor_BD" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Valoracion</title>
    </head>
    <jsp:include page="/Plantillas/PlantillaMenu.jsp" />


    <body>
        <div class="container-fluid">
            <div class="row align-items-center justify-content-center">
                <div class="col-3">
                    <form action="AComentario" method="POST">
                        <input type="hidden" name="id_comercio" value="${prueba}">

                            <div class="form-group">
                                <label>Nombre: </label>
                                <input type="text" name="vecino_comentario"  class="form-control" placeholder="Su nombre" required>
                            </div>
                            <div class="form-group">
                                <label for="exampleFormControlTextarea1">Opinion</label>
                                <textarea class="form-control" name="descripcion_comentario" id="descripcion_comentario" rows="3" required></textarea>
                            </div>
                            <h5>Valoracion</h5>
                            <p class="clasificacion">
                                <input id="radio1" type="radio" name="valoracion_comercio" checked="" value="1">1<!--
                                --><label for="radio1">★</label><!--
                                --><input id="radio2" type="radio" name="valoracion_comercio" value="2">2<!--
                                --><label for="radio2">★</label><!--
                                --><input id="radio3" type="radio" name="valoracion_comercio" value="3">3<!--
                                --><label for="radio3">★</label><!--
                                --><input id="radio4" type="radio" name="valoracion_comercio" value="4">4<!--
                                --><label for="radio4">★</label><!--
                                --><input id="radio5" type="radio" name="valoracion_comercio" value="5">5<!--
                                --><label for="radio5">★</label>
                            </p>
                            <br>
                            <input type="submit" value="Aceptar" />
                        </form>
                    </div>
                </div>
                <h1 class="display-4 text-center">Comentarios</h1>
                <div class="row"> 
                <c:forEach items="${comentarios}" var="comentario" >
                    <div class="col-4">
                        <div class="card mb-4">
                            <div class="card-body text-center">
                                <p class="lead">${comentario.vecino_comentario}</p>
                                <p class="lead">Opinion: ${comentario.descripcion_comentario}</p>
                                <p class="lead">Puntuacion: ${comentario.valoracion_comercio_comentario}</p>

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
    </div>
</body>
</html>
