<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s"   uri="http://www.springframework.org/tags" %>
<!doctype html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />" type="text/css">
        <link rel="stylesheet" href="<c:url value='/css/bootstrap-responsive.min.css' />" type="text/css">
    </head>
    <body>
        <nav class="navbar navbar-fixed-top" role="navigation">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="i-bar"></span>
                        <span class="i-bar"></span>
                        <span class="i-bar"></span>
                    </a>
                    <a class="brand" href="<c:url value='/' />">Blog</a>
                    <div class="nav-collapse">
                        <ul class ="nav">
                            <li><a href="<c:url value='/'/>">Inicio</a></li>
                            <li class="active"><a href="<c:url value='/'/>">Articulos</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </nav>
        <br>
        <h1>Nuevo Artículos</h1>
        <div class ="well">
            <a href="<c:url value= '/articulo/nuevo' />" class ="btn btn-primary"><i class="icon-file icon-white"></i>Nuevo </a>
         </div>
         
        <!-- JavaScript at the bottom for fast page loading -->
        <script src="<c:url value='/js/jquery-1.8.2.min.js' />"></script>
        <script src="<c:url value='/js/bootstrap.min.js' />"></script>
    </body>
</html>