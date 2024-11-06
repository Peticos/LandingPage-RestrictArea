<%@ page import="java.util.List" %>
<%@ page import="com.peticos.Model.Administrador" %>
<%@ page import="com.peticos.DAO.AdministradorDAO" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<Administrador> admins = (List<Administrador>) request.getAttribute("administradores");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!-- Ícone -->
    <link rel="icon" href="../../assets/images/logo_app_branco.png">

    <!-- CSS -->
    <link rel="stylesheet" href="/areaRestrita/administradores/admins.css">

    <!-- Scripts (JS) -->
    <script src="administradores/acoes.js" defer></script>
    <script src="administradores/filtros.js" defer></script>
    <script src="global.js" defer></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administradores - Área Restrita - Peticos</title>
</head>
<body>
<input type="checkbox" id="adicionar-btn" name="adicionar-btn">
<input type="checkbox" id="editar-btn" name="editar-btn">
<header>
    <div class="abas">
        <a href="">CRUD</a>
        <a href="">Dashboard</a>
    </div>
    <div class="perfil">
        <%
            HttpSession sessao = request.getSession(false);

            AdministradorDAO dao = new AdministradorDAO();
            if (sessao == null || sessao.getAttribute("admin") == null) {
                // Usuário não é administrador, redirecionar para página de login
                request.getSession().setAttribute("erro", "Você precisa ser um administrador para acessar essa página!");
                response.sendRedirect("/login/login.jsp");
                return;
            }
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
        <li class="selecionado">
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
            <a href="../../areaRestrita/endereco">
                <img src="../../assets/images/category_icon.svg" alt="">
                <p>Endereços</p>
            </a>
        </li>
        <li>
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
        <li>
            <a href="../../areaRestrita/relatorio">
                <img src="../../assets/images/relatorio_icon.svg" alt="">
                <p>Relatório</p>
            </a>
        </li>
        <li>
            <a href="/logout"> <!-- Servlet de logout -->
                <img src="../../assets/images/logout.svg" alt="">
                <p>Sair</p>
            </a>
        </li>
    </ul>
</nav>
<div class="page-container">
    <div class="spacing"></div>
    <div class="container">
        <div class="filtro-container">
            <div class="header-filtro">
                <h1>Administradores</h1>
                <hr>
                <div class="filtro-info">
                    <h2>Total: <%=admins.size()%></h2>
                    <div class="acoes-filtro">
                        <label for="adicionar-btn" id="adicionar">
                            <img src="../../assets/images/add.svg" alt="">
                        </label>
                        <div class="pesquisar">
                            <input type="text" placeholder="Procure aqui..">
                            <img src="../../assets/images/search.svg" alt="">
                        </div>
                    </div>
                </div>
            </div>
            <div class="filtro">
                <!--Ver filtros (Isaac)-->
            </div>
        </div>
        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
        <div id="message-box" class="message">
            <p><%= message %></p>
        </div>

        <script>
            // Mostra a mensagem do servlet por 5 segundos
            setTimeout(function() {
                var messageBox = document.getElementById('message-box');
                if (messageBox) {
                    messageBox.style.display = 'none';
                }
            }, 5000);
        </script>
        <% } %>

        <%
            if (!admins.isEmpty()){
        %>
        <div class="table-container">
            <table cellspacing="0">
                <tr class="header-tabela">
                    <th class="id-administrador">ID</th>
                    <th class="nome-administrador">Nome</th>
                    <th class="e-mail-administrador">E-mail</th>
                    <th class="acao">Ações</th>
                </tr>
                <%
                    for (int i = 0; i < admins.size(); i++) {
                %>
                <tr>
                    <td class="id-administrador"><%=admins.get(i).getId()%></td>
                    <td class="nome-administrador"><%=admins.get(i).getNome()%></td>
                    <td class="e-mail-administrador"><%=admins.get(i).getEmail()%></td>
                    <td class="acao">
                        <label for="editar-btn" class="edit">
                            <img src="../../assets/images/edit.svg" alt="">
                        </label>
                        <button class="remove">
                            <img src="../../assets/images/remove.svg" alt="">
                        </button>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
        <%
        } else{
        %>
        <h2 class="indisponivel">Sem administradores disponíveis...</h2>
        <%
            }
        %>
    </div>
</div>
<div class="form-container">
    <form action="administradores/adicionar" method="post" id="form-adicionar">
        <h1>Adicionar Administrador</h1>
        <div class="form-input">
            <label for="nome-administrador">Nome</label>
            <input type="text" name="nome-administrador" id="nome-administrador" placeholder="João da Silva">
        </div>
        <div class="form-input">
            <label for="e-mail-administrador">E-mail</label>
            <input type="email" name="e-mail-administrador" id="e-mail-administrador" placeholder="joaodasilva@email.com">
            <h4>Deve conter "nome", "@domínio", ".com" ou ".org" e pode conter ".br"</h4>
        </div>
        <div class="form-input">
            <label for="senha-administrador">Senha</label>
            <input type="password" name="senha-administrador" id="senha-administrador" placeholder="Digite a senha">
            <h4>Deve ter 8 dígitos ou mais, uma letra minúscula, uma maiúscula, um número e um dígito especial</h4>
        </div>

        <div class="actions">
            <label for="adicionar-btn" id="cancelar">Cancelar</label>
            <input type="submit" value="Adicionar">
        </div>
    </form>
</div>
<div class="edit-container">
    <form action="administradores/editar" method="post" id="form-editar">
        <h1>Editar Administrador</h1>
        <div class="form-input">
            <label for="nome-administrador-e">Nome</label>
            <input type="text" name="nome-administrador" id="nome-administrador-e" placeholder="João da Silva">
        </div>
        <div class="form-input">
            <label for="e-mail-administrador-e">E-mail</label>
            <input type="email" name="e-mail-administrador" id="e-mail-administrador-e" placeholder="joaodasilva@email.com">
            <h4>Deve conter "nome@domínio.com" ou ".org" e pode conter ".br"</h4>
        </div>
        <input type="number" name="id" id="id-e" hidden="hidden" readonly>
        <div class="actions">
            <label for="editar-btn" id="cancelar-edicao">Cancelar</label>
            <input type="submit" value="Salvar">
        </div>
    </form>
</div>
<script>
    document.querySelectorAll('form').forEach(form => {
        form.addEventListener('submit', function() {
            const submitButton = this.querySelector('input[type=submit]');
            if (submitButton) {
                submitButton.setAttribute('disabled', 'disabled');
            }
        });
    });
</script>
</body>
</html>
