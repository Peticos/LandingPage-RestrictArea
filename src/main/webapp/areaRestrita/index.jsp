<%@ page contentType="text/html;charset=UTF-8" %>
<%
    HttpSession sessao = request.getSession(false);
    if (sessao == null || sessao.getAttribute("admin") == null) {
        // Definindo uma mensagem de erro
        String mensagemDeErro = "Você precisa ser um administrador para acessar essa página!";

        // Definindo a mensagem de erro
        sessao.setAttribute("erro", mensagemDeErro);

        // Redirecionando para a página de login
        response.sendRedirect("/login/login.jsp");
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Area restrita</h1>
</body>
</html>
