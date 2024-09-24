<<%@ page contentType="text/html;charset=UTF-8" %>
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
    <link rel="stylesheet" href="../../assets/styles/admin.css">

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
            <a href="../../areaRestrita/dashboard/index.jsp">Dashboard</a>
        </li>
        <li id="admin">
            <img src="../../assets/images/admin_icon.svg" alt="">
            <a href="../../areaRestrita/administradores/index.jsp">Administradores</a>
        </li>
        <li>
            <img src="../../assets/images/dicadodia_icon.svg" alt="">
            <a href="../../areaRestrita/dicasDoDia/index.jsp">Dica Do Dia</a>
        </li>
        <li>
            <img src="../../assets/images/category_icon.svg" alt="">
            <a href="../../areaRestrita/categoriaPostagens/index.jsp">Categoria Postagens</a>
        </li>
        <li>
            <img src="../../assets/images/paw.svg" alt="">
            <a href="../../areaRestrita/raca/index.jsp">Raça</a>
        </li>
        <li>
            <img src="../../assets/images/especie_icon.svg" alt="">
            <a href="../../areaRestrita/especie/index.jsp">Espécie</a>
        </li>
        <li>
            <img src="../../assets/images/local_icon.svg" alt="">
            <a href="../../areaRestrita/local/index.jsp">Local</a>
        </li>
    </ul>
</nav>
<div id="content-container">
        <hr>

        <div>
            <h1>Administradores</h1>
            <div>
                <img src="" alt="">
                <p>Adicionar Admin</p>
            </div>
        </div>

        <table>

            <tr id="id">
                <%
                    for (int i = 0; i < ; i++) {
                        

                %>
                <td></td>
            </tr>

            <tr id="nome">
                <td></td>
            </tr>

            <tr id="email">
                <td></td>
            </tr>

            <tr>
                <td></td>
            </tr>

        </table>
    </div>
</body>
</html>