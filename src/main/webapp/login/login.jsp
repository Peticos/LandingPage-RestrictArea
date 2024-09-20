<%@ page contentType="text/html;charset=UTF-8" %>
<%
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
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="login" method="post">
        <p><%=mensagemDeErro%></p>
        <label for="email">E-mail: </label>
        <input type="email" id="email" name="email" required>

        <label for="senha">Senha: </label>
        <input type="password" id="senha" name="senha" required>

        <input type="submit" value="Entrar">
    </form>
</body>
</html>
