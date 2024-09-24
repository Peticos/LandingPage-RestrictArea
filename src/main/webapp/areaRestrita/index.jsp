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
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Restrita - Peticos</title>
</head>
<body>

</body>
</html>
