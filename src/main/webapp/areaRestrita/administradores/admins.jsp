<%@ page import="java.util.List" %>
<%@ page import="com.peticos.Model.Administrador" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!-- Ícone -->
    <link rel="icon" href="../../assets/images/logo_app_branco.png">

    <!-- CSS -->
    <link rel="stylesheet" href="admins.css">

    <!-- Scripts (JS) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="../../assets/scripts/remover.js" defer></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administradores - Área Restrita - Peticos</title>
</head>
<body>
<nav>
    <img src="../../assets/images/Simplified Logo.svg" alt="">
    <ul>
        <li>
            <img src="../../assets/images/dashboard_icon.svg" alt="">
            <a href="../../areaRestrita/dashboard">Dashboard</a>
        </li>
        <li>
            <img src="../../assets/images/admin_icon.svg" alt="">
            <a href="../../areaRestrita/administradores">Administradores</a>
        </li>
        <li id="dicas">
            <img src="../../assets/images/dicadodia_icon.svg" alt="">
            <a href="../../areaRestrita/dicasDoDia">Dica Do Dia</a>
        </li>
        <li>
            <img src="../../assets/images/category_icon.svg" alt="">
            <a href="../../areaRestrita/categoriaPostagens">Categoria Postagens</a>
        </li>
        <li>
            <img src="../../assets/images/paw.svg" alt="">
            <a href="../../areaRestrita/raca">Raça</a>
        </li>
        <li>
            <img src="../../assets/images/especie_icon.svg" alt="">
            <a href="../../areaRestrita/especie">Espécie</a>
        </li>
        <li>
            <img src="../../assets/images/local_icon.svg" alt="">
            <a href="../../areaRestrita/local">Local</a>
        </li>
    </ul>
</nav>
<div class="page-container">
    <div class="spacing"></div>
    <div class="content-container">
        <hr>
        <div class="add-container">
            <h1>Administradores</h1>
            <button>
                <img src="../../assets/images/add.svg" alt="">
                Adicionar Admin
            </button>
        </div>
        <%
            String retorno = request.getParameter("retorno");
            if (retorno!=null && !retorno.isEmpty()){

        %>
        <p><%=retorno%></p>
        <%
            }
        %>
        <%
            List<Administrador> administradores = (List<Administrador>) request.getAttribute("administradores");
            if (administradores !=null && !administradores.isEmpty()){

        %>
        <table class="dicas" cellspacing="0">
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Ações</th>
            </tr>
            <%
                for (int i = 0; i < administradores.size(); i++) {

            %>
            <tr>
                <td class="titulo"><%=administradores.get(i).getId()%></td>
                <td class="texto"><%=administradores.get(i).getNome()%></td>
                <td class="link"><%=administradores.get(i).getEmail()%></td>
                <td class="acao center" id="<%=administradores.get(i).getId()%>">
                    <button class="edit">
                        <img src="../../assets/images/edit.svg" alt="">
                    </button>
                    <button class="remove">
                        <img src="../../assets/images/remove.svg" alt="">
                    </button>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <%
        } else{
        %>
        <h2>Sem administradores disponíveis...</h2>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
