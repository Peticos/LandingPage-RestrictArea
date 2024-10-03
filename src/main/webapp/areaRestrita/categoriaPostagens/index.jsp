<%@ page import="java.util.List" %>
<%@ page import="com.peticos.Model.Categoria" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!-- Lilita One & Varela Round (fontes da página) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <!-- Varela Round -->
    <link href="https://fonts.googleapis.com/css2?family=Lilita+One&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Varela+Round&display=swap" rel="stylesheet">
    <!-- Lilita One -->
    <link href="https://fonts.googleapis.com/css2?family=Lilita+One&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Varela+Round&display=swap" rel="stylesheet">

    <!-- Ícone -->
    <link rel="icon" href="../../assets/images/logo_app_branco.png">

    <!-- CSS -->
    <link rel="stylesheet" href="../../assets/styles/dicas.css">

    <!-- Scripts (JS) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="../../assets/scripts/remover.js" defer></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Categoria Postagens - Área Restrita - Peticos</title>
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
            <h1>Categoria Postagens</h1>
            <button>
                <img src="../../assets/images/add.svg" alt="">
                Adicionar Categoria
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
            List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
            if (categorias !=null && !categorias.isEmpty()){

        %>
        <table class="dicas" cellspacing="0">
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Ações</th>
            </tr>
            <%
                for (int i = 0; i < categorias.size(); i++) {

            %>
            <tr>
                <td class="titulo"><%=categorias.get(i).getId()%></td>
                <td class="texto center"><%=categorias.get(i).getNome()%></td>
                <td class="acao center" id="<%=categorias.get(i).getId()%>">
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
        <h2>Sem categrias disponíveis...</h2>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
