<%@ page import="com.peticos.Model.Raca" %>
<%@ page import="java.util.List" %>
<%@ page import="com.peticos.DAO.AdministradorDAO" %>
<%@ page import="com.peticos.Model.Administrador" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<Raca> racas = (List<Raca>) request.getAttribute("racas");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!-- Ícone -->
    <link rel="icon" href="../../assets/images/logo_app_branco.png">

    <!-- CSS -->
    <link rel="stylesheet" href="/areaRestrita/raca/raca.css">

    <!-- Scripts (JS) -->
    <script src="raca/acoes.js" defer></script>
    <script src="raca/filtros.js" defer></script>
    <script src="global.js" defer></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Raça - Área Restrita - Peticos</title>
</head>
<body>
<input type="checkbox" id="adicionar-btn" name="adicionar-btn">
<input type="checkbox" id="editar-btn" name="editar-btn">
<header>
    <div class="abas">
        <a href="/areaRestrita/administradores">CRUD</a>
        <a href="https://area-restrita-dados-4.onrender.com/previsao-user">Dados do App</a>
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
        <li>
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
        <li class="selecionado">
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
            <input type="checkbox" id="open-btn" name="open-btn">
            <div class="header-filtro">
                <h1>Raça</h1>
                <hr>
                <div class="filtro-info">
                    <h2>Total: <%=racas.size()%></h2>
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
                <div class="id">
                    <h3>ID</h3>
                    <input type="number" placeholder="12345">
                </div>
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
            if (!racas.isEmpty()) {
        %>
        <div class="table-container">
            <table>
                <tr class="header-tabela">
                    <th class="id-raca primeiro">ID</th>
                    <th class="raca">Raça</th>
                    <th class="acao ultimo">Ações</th>
                </tr>
                <%
                    for (int i = 0; i < racas.size(); i++) {
                %>
                <tr>
                    <td class="id-raca"><%=racas.get(i).getId_raca()%></td>
                    <td class="raca"><%=racas.get(i).getRaca()%></td>
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
        } else {
        %>
        <h2>Sem raças disponíveis...</h2>
        <%
            }
        %>
    </div>
</div>
<div class="form-container">
    <form action="raca/adicionar" method="post" id="form-adicionar">
        <h1>Adicionar Raça</h1>
        <div class="form-input">
            <label for="nome-raca">Nome da Raça</label>
            <input type="text" name="nome-raca" id="nome-raca" placeholder="Golden, Husky, Yorkshire..." required>
            <h4>Não pode conter números</h4>
        </div>
        <div class="actions">
            <label for="adicionar-btn" id="cancelar">Cancelar</label>
            <input type="submit" value="Adicionar">
        </div>
    </form>
</div>
<div class="edit-container">
    <form action="raca/editar" method="post" id="form-editar">
        <h1>Editar Raça</h1>
        <div class="form-input">
            <label for="nome-raca-e">Nome da Raça</label>
            <input type="text" name="nome-raca" id="nome-raca-e" placeholder="Golden, Husky, Yorkshire..." required>
            <h4>Não pode conter números</h4>
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
