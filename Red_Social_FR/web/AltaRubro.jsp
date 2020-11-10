
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html> 
<html lang="es">

    <head>
        <title>XENEIC || Alta Rubro</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </head>
    <jsp:include page="/Plantillas/PlantillaAdmin.jsp" />

    <jsp:useBean id="gestor" scope="request" class="controlador.Gestor_BD" />

    <jsp:useBean id="nuevoRubro" scope="session" class="modelo.Rubro" />
    <jsp:setProperty name="nuevoRubro" property="*" />

    <body>
        <div class="container-fluid">
            <br>
            <div class="row text-center justify-content-center">
                <div class="col-12 ">
                    <button class="btn btn-primary" role="link" onclick="window.location = '/Red_Social_FR/Administracion.jsp'">Volver al menu Administracion</button>
                 
                </div>
                <div class="col-lg-4 ">
                    <br>
                    <h3>ALTA DE RUBROS</h3>

                    <form action="ABMRubros" method="POST">

                        <div class="form-group">
                            <label>Rubro</label>
                            <input type="text" name="descripcion_rubro"  class="form-control" placeholder="Descripcion de rubro" required>
                        </div>

                        <div class="form-group">
                            <input type="checkbox" name="vigente_rubro" class="form-check-input" value ="true">
                            <label class="form-check-label" for="exampleCheck1">Vigente</label>
                        </div>
                        <br>
                        <button class="boton" type="submit" id="nuevoRubro">Registrar</button>
                    </form>

                    <br>

                </div>
            </div>
            <div class="separador"></div>

        </div>

    </body>

</html>