<%--
  Created by IntelliJ IDEA.
  User: isaacdias-ieg
  Date: 24/09/2024
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.peticos.DAO.AdministradorDAO" %>
<%@ page import="com.peticos.Model.Administrador" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!-- Ícone -->
    <link rel="icon" href="../../assets/images/logo_app_branco.png">

    <!-- CSS -->
    <link rel="stylesheet" href="/areaRestrita/dashboard/dashboard.css">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Área Restrita - Peticos</title>
</head>
<body>
<input type="checkbox" id="adicionar-btn" name="adicionar-btn">
<input type="checkbox" id="editar-btn" name="editar-btn">
<header>
    <div class="abas">
        <a href="../../areaRestrita/administradores">CRUD</a>
        <a href="../../areaRestrita/dashboard/dashboard.jsp">Dashboard</a>
    </div>
    <div class="perfil">
        <%
            AdministradorDAO dao = new AdministradorDAO();
            Administrador admin = dao.getAdmin((String) request.getSession(false).getAttribute("admin"));
        %>
        <div class="foto">
            <%=admin.getPrimeiroNome().charAt(0)%>
        </div>
        <div class="info">
            <h3><%=admin.getPrimeiroNome()%></h3>
            <h5><%=admin.getEmail()%></h5>
        </div>
    </div>
</header>
<nav>
    <img src="../../assets/images/Simplified Logo.svg" alt="">
    <img src="../../assets/images/logo_app_branco.png" alt="">
    <ul>
    </ul>
</nav>
<main class="page-container">
    <div class="spacing"></div>
    <div class="container">
        <div class="header-filtro">
            <h1 class="title">Pesquisa de público alvo</h1>
        </div>
        <iframe class="frame-dash"
                title="Forms - Dados Tratados"
                src="https://app.powerbi.com/view?r=eyJrIjoiZDE2NjBlMTEtNWJhYy00ZWEwLTljNjUtOGMxNzUyZGJjYmQ2IiwidCI6ImIxNDhmMTRjLTIzOTctNDAyYy1hYjZhLTFiNDcxMTE3N2FjMCJ9"
                frameborder="0"
                allowFullScreen="true">
        </iframe>
    </div>
</main>
</body>
</html>
