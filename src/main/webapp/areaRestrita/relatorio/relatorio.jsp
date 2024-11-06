<%@ page import="java.util.List" %>
<%@ page import="com.peticos.DAO.AdministradorDAO" %>
<%@ page import="com.peticos.Model.Administrador" %>
<%@ page import="com.peticos.Model.Relatorio" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<Relatorio> relatorios = (List<Relatorio>) request.getAttribute("relatorios");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!-- Ícone -->
    <link rel="icon" href="../../assets/images/logo_app_branco.png">

    <!-- CSS -->
    <link rel="stylesheet" href="/areaRestrita/relatorio/relatorio.css">

    <!-- Scripts (JS) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="relatorio/filtros.js" defer></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Relatório - Área Restrita - Peticos</title>
</head>
<body>
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
        <li class="selecionado">
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
                <h1>Relatórios</h1>
                <hr>
                <div class="filtro-info">
                    <h2>Total: <%=relatorios.size()%></h2>
                    <div class="acoes-filtro">
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
                    <h3>Operação</h3>
                    <select id="operationSelect">
                        <option value="UPDATE">UPDATE</option>
                        <option value="INSERT">INSERT</option>
                        <option value="DELETE">DELETE</option>
                    </select>
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
            if (!relatorios.isEmpty()) {
        %>
        <div class="table-container">
            <table cellspacing="0">
                <tr class="header-tabela">
                    <th class="nome-tabela">Nome da tabela</th>
                    <th class="operacao">Operacao</th>
                    <th class="usuario">Usuário</th>
                    <th class="data-alteracao">Data da alteração</th>
                </tr>
            <%
                for (int i = 0; i < relatorios.size(); i++) {
            %>
                <tr>
                    <td class="nome-tabela"><%=relatorios.get(i).getNomeTabela()%></td>
                    <td class="operacao"><%=relatorios.get(i).getOperacao()%></td>
                    <td class="usuario"><%=relatorios.get(i).getUsuario()%></td>
                    <td class="data-alteracao"><%=relatorios.get(i).getDataAlteracao()%></td>
                </tr>
            <%
                }
            %>
            </table>
        </div>
        <%
            } else {
        %>
        <h2>Sem relatórios hoje...</h2>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
