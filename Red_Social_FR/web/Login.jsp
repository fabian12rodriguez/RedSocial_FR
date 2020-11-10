
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Login</title>

    </head>

    <body class="text-center">
        <jsp:include page="/Plantillas/PlantillaLogin.jsp" />

        <div class="row text-center justify-content-center">
            <div class="col-9">

                <ul class="lista col-12">

                    <li>
                        <h5 class="display-4">INGRESO DEL SISTEMA</h5>
                        <form method="post" action="Login">
                            <div class="form-group">
                                <label>Usuario</label>
                                <input name="txtUsuario" class="form-control">
                            </div> 
                            <div class="form-group">
                                <label>Contraseña</label>
                                <input class="form-control" placeholder="******" type="password" name="txtPass">
                            </div> 
                            <div class="form-group"> 
                                <div class="checkbox">
                                </div> 
                                <div class="form-group">
                                    <button type="submit" class="btn btn-warning btn-block"> Entrar  </button>
                                </div>   
                                <%  if (request.getAttribute("mensajeError") != null && !request.getAttribute("mensajeError").equals("")) { %>
                                <h2>${ mensajeError }</h2>  <% }%>
                        </form> 
                    </li>
                </ul>

            </div>

        </div> 

    </body>
</html>
