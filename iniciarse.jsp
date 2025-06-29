<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="gestionBD.Daoregistrop"%>
<%@page import="gestionBD.Pojoregistrop"%>
<%@page import ="jakarta.servlet.http.HttpSession" %>
<%@page import="java.io.*"%>

<%
    // Variables de entrada del formulario
    String matricula = request.getParameter("matricula");
    String password = request.getParameter("password");
    String errorMessage = null;
    boolean loginSuccess = false;
    
    // Si las credenciales son enviadas, validamos el login
    if (matricula != null && password != null) {
        // Si las credenciales son "admin" y "admin1"
        if ("admin".equals(matricula) && "admin1".equals(password)) {
            // Redirigir a admin.html si las credenciales son correctas
            response.sendRedirect("./htmla/index.jsp");
            return;  // Salir de la ejecución JSP para evitar que se muestre contenido innecesario
        } else {
            // Si las credenciales no son correctas, verificamos en la base de datos
            
            Daoregistrop dao = new Daoregistrop();
            Pojoregistrop pojo=dao.verificar(matricula, password);
            
            // Validar las credenciales en la base de datos
            if (pojo !=null) {
                // Si las credenciales están registradas, pero no son "admin" y "admin1", redirigimos al index
               HttpSession usuario= request.getSession(true);
               usuario.setAttribute("objeto",pojo);
                response.sendRedirect("./htmlu/index.jsp");
                return;  // Salir de la ejecución JSP para evitar que se muestre contenido innecesario
            } else {
                // Si las credenciales no están registradas o son incorrectas, mostrar error
                errorMessage = "Credenciales incorrectas o no registradas. Por favor, vuelve a intentar.";
            }
        }
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>  <link rel="icon" type="image/png" href="./images/UTTEC.png">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UTTEC INTERCHANGE!</title>

    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <!-- custom css file link  -->
    <link rel="stylesheet" href="./css/style.css">

</head>
<body style="background-image: url('./images/fondo2.png'); background-size: cover; background-position: center; background-repeat: no-repeat; background-attachment: fixed;">
    
<!-- header section starts  -->

<header>

    <a href="#" class="logo"><img src="./images/logou.png" alt="LOGO"></a>

    <div id="menu" class="fas fa-bars"></div>

    <nav class="navbar">
        <ul>
            <li><a class="active" href="./index.html#home">Inicio</a></li>
            <li><a href="./index.html#service">Servicios</a></li>
            <li><a href="./index.html#process">Convocatorias</a></li>
            <li><a href="./index.html#review">Requisitos</a></li>
            <li><a href="./index.html#contact">Contacto Académico</a></li>
            <li><a href="./index.html#register">Registrarme</a></li>
        </ul>
    </nav>

</header>

<section class="home" id="home">

    <div class="content">
        <span>Estudia lejos, llega más lejos</span>
        <h3>UTTEC INTERCHANGE!</h3>
    </div>

    <div class="image">
        <img src="" alt="">
    </div>

    <section class="register" id="register">
        <% if (loginSuccess) { %>
            <!-- Si el usuario ha iniciado sesión correctamente, mostrar su mensaje -->
            <script>
        window.location.href = 'index.html';  // Redirigir al usuario a index.html
    </script>
        <% } else { %>
            <!-- Si no ha iniciado sesión, mostrar el formulario de inicio de sesión -->
            <% if (errorMessage != null) { %>
                <p style="color: red;"><%= errorMessage %></p>
            <% } %>
            <h1 class="headinglog">Iniciar sesión</h1>
            <form action="iniciarse.jsp" method="post" class="login-form">
                <input type="text" placeholder="Matricula " class="box" name="matricula" required="">
            <input type="password" placeholder="Contraseña" class="box" name="password" required="">
                <br><br>
                
                <input type="submit" value="Aceptar" class="btn">
            <a href="index.html#register" class="link">¿Aún no tienes una cuenta? ¡Registrate!</a>
        
            </form>

            
        <% } %>

    </section>

</section>
</body>
</html>
