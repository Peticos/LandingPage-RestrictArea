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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="administradores/remover.js" defer></script>
    <script src="administradores/filtros.js" defer></script>
    <script src="administradores/editar.js" defer></script>

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
            <a href="../../areaRestrita/categoriaPostagens">
                <img src="../../assets/images/category_icon.svg" alt="">
                <p>Categoria Postagens</p>
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
            <input type="checkbox" id="open-btn" name="open-btn">
            <div class="header-filtro">
                <h1>Administradores</h1>
                <hr>
                <div class="filtro-info">
                    <h2>Total: <%=admins.size()%></h2>
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
                <!--Ver filtros (Isaac)-->
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

        <%
            if (!admins.isEmpty()){
        %>
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
        <%
        } else{
        %>
        <h2>Sem administradores disponíveis...</h2>
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
        </div>
        <div class="form-input">
            <label for="senha-administrador">Senha</label>
            <input type="password" name="senha-administrador" id="senha-administrador" placeholder="Digite a senha">
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
        </div>
        <input type="number" name="id-administrador" id="id-administrador-e" hidden="hidden" readonly>
        <div class="actions">
            <label for="editar-btn" id="cancelar-edicao">Cancelar</label>
            <input type="submit" value="Salvar">
        </div>
    </form>
</div>
<script>
    $('form').submit(function(){
        $('input[type=submit]', this).attr('disabled', 'disabled');
    });
</script>
</body>
</html>
