<%@ page import="java.util.List" %>
<%@ page import="com.peticos.DAO.AdministradorDAO" %>
<%@ page import="com.peticos.Model.Administrador" %>
<%@ page import="com.peticos.Model.Especie" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<Especie> especies = (List<Especie>) request.getAttribute("especies");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!-- Ícone -->
    <link rel="icon" href="../../assets/images/logo_app_branco.png">

    <!-- CSS -->
    <link rel="stylesheet" href="/areaRestrita/especie/especies.css">

    <!-- Scripts (JS) -->
    <script src="especie/acoes.js" defer></script>
    <script src="especie/filtros.js" defer></script>
    <script src="global.js" defer></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Espécies - Área Restrita - Peticos</title>
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
        <li class="selecionado">
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
                <h1>Espécie</h1>
                <hr>
                <div class="filtro-info">
                    <h2>Total: <%=especies.size()%></h2>
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
                    <input type="text" placeholder="1234" id="filtrar-id">
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
            if (!especies.isEmpty()){
        %>
        <div class="table-container">
            <table cellspacing="0">
                <tr class="header-tabela">
                    <th class="id-especie">ID</th>
                    <th class="especie">Espécie</th>
                    <th class="acao">Ações</th>
                </tr>
                <%
                    for (int i = 0; i < especies.size(); i++) {
                %>
                <tr>
                    <td class="id-especie"><%=especies.get(i).getId()%></td>
                    <td class="especie"><%=especies.get(i).getNome()%></td>
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
        <h2>Sem espécies disponíveis...</h2>
        <%
            }
        %>
    </div>
</div>
<div class="form-container">
    <form action="especie/adicionar" method="post" id="form-adicionar">
        <h1>Adicionar Espécie</h1>
        <div class="form-input">
            <label for="especie">Nome da espécie</label>
            <input type="text" name="especie" id="especie" placeholder="Cachorro..">
        </div>
        <div class="actions">
            <label for="adicionar-btn" id="cancelar">Cancelar</label>
            <input type="submit" value="Adicionar">
        </div>
    </form>
</div>
<div class="edit-container">
    <form action="especie/editar" method="post" id="form-editar">
        <h1>Editar Espécie</h1>
        <div class="form-input">
            <label for="especie-e">Nome da espécie</label>
            <input type="text" name="especie" id="especie-e" placeholder="Cachorro.." required>
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
