
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html> 
<html lang="en">

    <head>
        <title>XENEIC || Alta Comercio</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </head>
    <jsp:include page="/Plantillas/PlantillaAdmin.jsp" />

    <jsp:useBean id="gestor" scope="request" class="controlador.Gestor_BD" />

    <jsp:useBean id="nuevoComercio" scope="session" class="modelo.Comercio" />
    <jsp:setProperty name="nuevoComercio" property="*" />



    <body>
        <div class="container-fluid">
            <br>
            <div class="row text-center justify-content-center">
                    <div class="col-12 ">
                    <button class="btn btn-primary" role="link" onclick="window.location = '/Red_Social_FR/Administracion.jsp'">Volver al menu Administracion</button>
                 
                </div>
              
                <div class="col-lg-4 ">
                      <br>
                    <h3>ALTA DE COMERCIOS</h3>

                    <form action="ABMComercios" method="POST">

                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" name="nombre_comercio"  class="form-control" placeholder="Nombre de comercio" required>
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" name="telefono_comercio"  class="form-control" placeholder="Telefono de comercio" required>
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" name="direccion_comercio"  class="form-control" placeholder="Direccion de comercio" required>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="text" name="email_comercio"  class="form-control" placeholder="Email de comercio" required>
                        </div>
                        <div class="form-group">
                            <tr><td>Rubros</td><td>
                                    <select name="descripcion_rubro" >
                                        <c:forEach var="ec" items="${gestor.obtenerRubros}">
                                            <option value="${ec.id_rubro}">${ec.descripcion_rubro}
                                            </c:forEach>
                                    </select>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="vigente_comercio" class="form-check-input" value ="true">
                            <label class="form-check-label" for="exampleCheck1">Vigente</label>
                        </div>
                        <br>
                        <button class="boton" type="submit" id="nuevoComercio">Registrar</button>
                    </form>

                </div>
            </div>
          
        </div>

    </body>

</html>


