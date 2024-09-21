<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if (request.getSession(false).getAttribute("admin")!=null){
        response.sendRedirect("/areaRestrita/index.jsp");
    }
    String mensagemDeErro = "";
    if (request.getAttribute("erro")!=null){
        mensagemDeErro = (String) request.getAttribute("erro");
    } else if (request.getSession(false).getAttribute("erro")!=null){
        // Definindo a mensagem de erro
        mensagemDeErro = (String) request.getSession(false).getAttribute("erro");

        // Removendo o atributo de erro
        request.getSession(false).removeAttribute("erro");
    }
%>
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
    <link rel="icon" href="../assets/images/logo_app_branco.png">

    <!-- Styles (CSS) -->
    <link rel="stylesheet" href="../assets/styles/login.css">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acesso Área Restrita - Peticos</title>
</head>
<body>
    <header>
        <div class="header-voltar">
            <a href="/index.jsp">
                <img src="../assets/images/arrow.svg" alt="Voltar">
            </a>
        </div>
        <div class="header-logo">
            <img src="../assets/images/Simplified Logo.svg" alt="Peticos">
        </div>
        <div class="header-instagram">
            <img src="../assets/images/instagram_.svg" alt="Instagram">
        </div>
    </header>
    <div class="content-container">
        <div id="form-container">
            <h1>Bem-vindo à área restrita!</h1>
            <form action="acessar" method="post" id="login-form">
                <p><%=mensagemDeErro%></p>
                <div class="form-input">
                    <label for="email">E-mail: </label>
                    <input type="email" id="email" name="email" required placeholder="Digite seu e-mail aqui">
                </div>
                <div class="form-input">
                    <label for="senha">Senha: </label>
                    <input type="password" id="senha" name="senha" required placeholder="Digite sua senha">
                </div>
                <input type="submit" value="Entrar">
            </form>
        </div>
        <div class="animais-container">
            <div class="animais">
                <div class="gato-container">
                    <img src="../assets/images/gato branco premium.png" alt="">
                </div>
                <div class="circulo">
                    <div class="cachorro-container">
                        <img src="../assets/images/ModolinhoCorpoCompleto.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
<footer>
    <p>© 2024 Peticos. All rights reserved.</p>
    <img src="../assets/images/peticosModolinho.svg" alt="">
    <ul id="entre-contato">
        <li>
            <a href="mailto:bhavatech@outlook.com" >
                <img src="../assets/images/mail.svg" alt="">
            </a>
        </li>
        <li>
            <a href="mailto:bhavatechteam@gmail.com">
                <img src="../assets/images/mail.svg" alt="">
            </a>
        </li>
        <li>
            <a href="https://www.instagram.com/_peticos/" target="_blank">
                <img src="../assets/images/instagram_.svg" alt="" class="ig">
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/login/login.jsp"> <!--Deve levar para a área restrita-->
                <img src="../assets/images/restrictArea.svg" alt="">
            </a>
        </li>
    </ul>
</footer>
</body>
</html>
