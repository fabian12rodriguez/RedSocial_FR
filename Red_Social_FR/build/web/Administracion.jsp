
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XENEIC || Administracion</title>
         <link rel="shortcut icon" href="https://es.logodownload.org/wp-content/uploads/2018/10/Boca-Juniors-logo-escudo1-881x1024.png" />
    </head>
    <body>
        <jsp:include page="/Plantillas/PlantillaAdmin.jsp" />

        <div class="container"> 
            <h1 class="text-center mb-4">MENU ADMINISTRACION</h1>
            <div class="row align-items-center">
                <div class="col-12 botonera text-center">

                    <br>
                    <div class="dropdown">
                        <button class="btn boton btn-lg dropdown-toggle" type="button" id="dropdownMenuButton"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Rubros
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="/Red_Social_FR/AltaRubro.jsp">Alta</a>
                            <a class="dropdown-item" href="/Red_Social_FR/ABMRubros">Listados</a>
                        </div>
                    </div>
                    <div class="dropdown">
                        <button class="btn boton btn-lg dropdown-toggle" type="button" id="dropdownMenuButton"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Comercios
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="/Red_Social_FR/AltaComercio.jsp">Alta</a>
                            <a class="dropdown-item" href="/Red_Social_FR/ABMComercios">Listados</a>
                        </div>
                    </div>
                    <div class="dropdown">
                        <button class="btn boton btn-lg dropdown-toggle" type="button" id="dropdownMenuButton"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Ofertas
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="/Red_Social_FR/AltaOferta.jsp">Alta</a>
                            <a class="dropdown-item" href="/Red_Social_FR/ABMOfertas">Listados</a>
                        </div>
                    </div>
                    <div class="dropdown">
                        <button class="btn boton btn-lg dropdown-toggle" type="button" id="dropdownMenuButton"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Consultas
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="/Red_Social_FR//ModerarConsultas">Moderar Consultas</a>

                        </div>
                    </div>
                    <div class="dropdown">
                        <button class="btn boton btn-lg dropdown-toggle" type="button" id="dropdownMenuButton"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Listados
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="/Red_Social_FR/LstComercioOrdenado.jsp">Comercios ordenados por comentarios</a>
                            <a class="dropdown-item" href="/Red_Social_FR/LstComentarioNoRespondido.jsp">Comentarios no respondidos</a>
                            <a class="dropdown-item" href="/Red_Social_FR/LstPromedioValoracionComercio.jsp">Promedio de valoracion de cada comercio</a>
                            <a class="dropdown-item" href="/Red_Social_FR/LstCantidadValoraciones.jsp">Cantidad de valoraciones</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>



    </body>
</html>
