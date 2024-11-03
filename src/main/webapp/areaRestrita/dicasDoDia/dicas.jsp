<%@ page import="java.util.List" %>
<%@ page import="com.peticos.Model.DicaDoDia" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="com.peticos.DAO.AdministradorDAO" %>
<%@ page import="com.peticos.Model.Administrador" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    Date menorData = date;
    Date maiorData = date;

    List<DicaDoDia> dicas = (List<DicaDoDia>) request.getAttribute("dicas");
    for (DicaDoDia dica : dicas) {
        Date dataDica = dica.getData();
        if (dataDica.compareTo(menorData) < 0) {
            menorData = dataDica;
        }
        if (dataDica.compareTo(maiorData) > 0) {
            maiorData = dataDica;
        }
    }
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!-- Ícone -->
    <link rel="icon" href="../../assets/images/logo_app_branco.png">

    <!-- CSS -->
    <link rel="stylesheet" href="/areaRestrita/dicasDoDia/dicas.css">

    <!-- Scripts (JS) -->
    <script src="global.js" defer></script>
    <script src="dicasDoDia/filtros.js" defer></script>
    <script src="dicasDoDia/acoes.js" defer></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dicas do Dia - Área Restrita - Peticos</title>
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
        <li class="selecionado">
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
            <input type="checkbox" id="open-btn" name="open-btn">
            <div class="header-filtro">
                <h1>Dica Do Dia</h1>
                <hr>
                <div class="filtro-info">
                    <h2>Total: <%=dicas.size()%></h2>
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
                <div class="data">
                    <h3>Início</h3>
                    <input type="date" id="data-inicio" name="data-inicio" min="<%=dateFormat.format(menorData)%>" max="<%=dateFormat.format(maiorData)%>">
                </div>
                <div class="data">
                    <h3>Fim</h3>
                    <input type="date"id="data-fim" name="data-fim" value="<%=dateFormat.format(maiorData)%>" min="<%=dateFormat.format(menorData)%>" max="<%=dateFormat.format(maiorData)%>">
                </div>
                <div class="id">
                    <h3>ID</h3>
                    <input type="number" placeholder="12345" id="filtrar-id">
                </div>
                <button id="dica-hoje">
                    Dica de Hoje
                </button>
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
        if (!dicas.isEmpty()){
        %>
        <div class="table-container">
            <table cellspacing="0">
                <tr class="header-tabela">
                    <th class="id invisivel">ID</th>
                    <th class="titulo">Título</th>
                    <th class="texto">Texto</th>
                    <th class="link invisivel">Link</th>
                    <th class="data-tabela">Data</th>
                    <th class="acao">Ações</th>
                </tr>
                <%
                for (int i = 0; i < dicas.size(); i++) {
                %>
                <tr>
                    <td class="id invisivel"><%=dicas.get(i).getId()%></td>
                    <td class="titulo"><%=dicas.get(i).getTitulo()%></td>
                    <td class="texto"><%=dicas.get(i).getTexto()%></td>
                    <td class="link invisivel"><%=dicas.get(i).getLink()%></td>
                    <td class="data-tabela"><%=dicas.get(i).getFormatedData()%></td>
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
        <h2>Sem dicas disponíveis...</h2>
        <%
        }
        %>
    </div>
</div>
<div class="form-container">
    <form action="dicasDoDia/adicionar" method="post" id="form-adicionar">
        <h1>Adicionar Dica Do Dia</h1>
        <div class="form-input">
            <label for="titulo">Título</label>
            <input type="text" name="titulo" id="titulo" placeholder="Como cuidar do seu cachorrinho que está doente?" maxlength="255" required>
        </div>
        <div class="form-input">
            <label for="texto">Texto</label>
            <textarea name="texto" id="texto" cols="30" rows="10" placeholder="Os cães são ótimos companheiros e gostam..." maxlength="255" required></textarea>

        </div>
        <div class="form-input">
            <label for="link">Link</label>
            <input type="text" name="link" id="link" placeholder="https://peticos.com.br/caes" maxlength="255" required>
            <h4>Deve começar com "https://"</h4>
        </div>
        <div class="form-input">
            <label for="data">Data</label>
            <input type="date" name="data" id="data" required>
        </div>
        <div class="actions">
            <label for="adicionar-btn" id="cancelar">Cancelar</label>
            <input type="submit" value="Adicionar">
        </div>
    </form>
</div>
<div class="edit-container">
    <form action="dicasDoDia/editar" method="post" id="form-editar">
        <h1>Editar Dica Do Dia</h1>
        <div class="form-input">
            <label for="titulo-e">Título</label>
            <input type="text" name="titulo" id="titulo-e" placeholder="Como cuidar do seu cachorrinho que está doente?" required>
        </div>
        <div class="form-input">
            <label for="texto-e">Texto</label>
            <textarea name="texto" id="texto-e" cols="30" rows="10" placeholder="Os cães são ótimos companheiros e gostam..." required></textarea>
        </div>
        <div class="form-input">
            <label for="link-e">Link</label>
            <input type="text" name="link" id="link-e" placeholder="https://peticos.com.br/caes" required>
            <h4>Deve começar com "https://"</h4>
        </div>
        <div class="form-input">
            <label for="data-e">Data</label>
            <input type="date" name="data" id="data-e" required>
        </div>
        <input type="number" name="id" id="id-e" hidden="hidden" readonly required>
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
