<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!-- Ícone -->
    <link rel="icon" href="../assets/images/logo_app_branco.png">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/errorPage/500/500.css">
    <title>Erro Inesperado - Peticos</title>
</head>
<body>

<!-- Header -->
<header>
    <div class="header-voltar">
        <a href="/index.jsp">
            <img src="../../assets/images/arrow.svg" alt="Voltar">
        </a>
    </div>
    <div class="header-logo">
        <img src="../../assets/images/Simplified Logo.svg" alt="Peticos">
    </div>
    <div class="header-instagram">
        <img src="../../assets/images/instagram_.svg" alt="Instagram">
    </div>
</header>

<!-- Content -->
<div id="content-container">
    <div id="error">
        <div id="error-cima">
            <h1>500</h1>
            <h2>Ops! Algo inesperado aconteceu...</h2>
            <details>
                <summary>Mais</summary>
                <p><%=exception%></p>
            </details>
        </div>
        <img id="cabeca-modolinho" src="../../assets/images/cabeca_modolinho_triste_interrogacao.svg" alt="">
        <a id="voltar-pagina-principal" href="../../index.jsp">Página Principal</a>
    </div>
    <div>
        <img id="modolinho-duvida" src="../../assets/images/modolinho_triste_interrogacao.svg" alt="">
    </div>
</div>

<!-- Footer -->
<footer>
    <p>© 2024 Peticos. All rights reserved.</p>
    <img src="../../assets/images/peticosModolinho.svg" alt="">
    <ul id="entre-contato">
        <li>
            <a href="mailto:bhavatech@outlook.com" >
                <img src="../../assets/images/mail.svg" alt="">
            </a>
        </li>
        <li>
            <a href="mailto:bhavatechteam@gmail.com">
                <img src="../../assets/images/mail.svg" alt="">
            </a>
        </li>
        <li>
            <a href="https://www.instagram.com/_peticos/" target="_blank">
                <img src="../../assets/images/instagram_.svg" alt="" class="ig">
            </a>
        </li>
        <li>
            <a href="../../login/login.jsp"> <!--Deve levar para a área restrita-->
                <img src="../../assets/images/restrictArea.svg" alt="">
            </a>
        </li>
    </ul>
</footer>
</body>
</html>

