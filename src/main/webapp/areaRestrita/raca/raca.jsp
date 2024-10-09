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
    <link rel="stylesheet" href="/areaRestrita/raca/raca.css">

    <!-- Scripts (JS) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="../../assets/scripts/remover.js" defer></script>
    <script src="../../assets/scripts/filtros.js" defer></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Raça - Área Restrita - Peticos</title>
</head>
<body>
<input type="checkbox" id="adicionar-btn" name="adicionar-btn">
<header>
    <div class="abas">
        <a href="">CRUD</a>
        <a href="">Dashboard</a>
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
        <li>
            <a href="../../areaRestrita/dashboard">
                <img src="../../assets/images/dashboard_icon.svg" alt="">
                <p>Dashboard</p>
            </a>
        </li>
        <li>
            <a href="../../areaRestrita/administradores">
                <img src="../../assets/images/admin_icon.svg" alt="">
                <p>Administradores</p>
            </a>
        </li>
        <li>
            <a href="../../areaRestrita/dicasDoDia">
                <img src="../../assets/images/dicadodia_icon.svg" alt="">
                <p>Dica Do Dia</p>
            </a>
        </li>
        <li>
            <a href="../../areaRestrita/categoriaPostagens">
                <img src="../../assets/images/category_icon.svg" alt="">
                <p>Categoria Postagens</p>
            </a>
        </li>
        <li class="selecionado">
            <a href="../../areaRestrita/raca">
                <img src="../../assets/images/paw.svg" alt="">
                <p>Raça</p>
            </a>
        </li>
        <li>
            <a href="../../areaRestrita/especie">
                <img src="../../assets/images/especie_icon.svg" alt="">
                <p>Espécie</p>
            </a>
        </li>
        <li>
            <a href="../../areaRestrita/local">
                <img src="../../assets/images/local_icon.svg" alt="">
                <p>Local</p>
            </a>
        </li>
    </ul>
</nav>
<div class="page-container">
    <div class="spacing"></div>
    <div class="container">
        <div class="filtro-container">
            <input type="checkbox" id="open-btn" name="open-btn">
            <div class="header-filtro">
                <h1>Raça</h1>
                <hr>
                <div class="filtro-info">
                    <h2>Total: 14</h2>
                    <div class="acoes-filtro">
                        <label for="adicionar-btn" id="adicionar">
                            <img src="../../assets/images/add.svg" alt="">
                        </label>
                        <label for="open-btn" id="filtrar">
                            <img src="../../assets/images/filter.svg" alt="">
                        </label>
                        <label for="open-btn" id="parar-filtro">
                            <img src="../../assets/images/filter-off.svg" alt="">
                        </label>
                        <div class="pesquisar">
                            <input type="text" placeholder="Procure aqui..">
                            <img src="../../assets/images/search.svg" alt="">
                        </div>
                    </div>
                </div>
            </div>
            <div class="filtro">
                <div class="id">
                    <h3>ID</h3>
                    <input type="number" placeholder="12345">
                </div>
            </div>
        </div>
        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
        <div id="message-box" class="message">
            <p><%= message %></p>
        </div>

        <script>
            // Definir um tempo para esconder a mensagem após 5 segundos (5000 milissegundos)
            setTimeout(function() {
                var messageBox = document.getElementById('message-box');
                if (messageBox) {
                    messageBox.style.display = 'none'; // Ocultar a mensagem
                }
            }, 5000); // 5000 milissegundos = 5 segundos
        </script>
        <% } %>
    </div>
</div>
</body>
</html>
