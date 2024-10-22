<%@ page import="com.peticos.Model.Local" %>
<%@ page import="java.util.List" %>
<%@ page import="com.peticos.DAO.AdministradorDAO" %>
<%@ page import="com.peticos.Model.Administrador" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<Local> locais = (List<Local>) request.getAttribute("locais");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!-- Ícone -->
    <link rel="icon" href="../../assets/images/logo_app_branco.png">

    <!-- CSS -->
    <link rel="stylesheet" href="/areaRestrita/local/locais.css">

    <!-- Scripts (JS) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="local/remover.js" defer></script>
    <script src="local/filtros.js" defer></script>
    <script src="local/editar.js" defer></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Locais - Área Restrita - Peticos</title>
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
        <li class="selecionado">
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
                <h1>Local</h1>
                <hr>
                <div class="filtro-info">
                    <h2>Total: <%=locais.size()%></h2>
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
                <div class="form-input">
                    <input type="number" id="filter-id" placeholder="ID do local">
                </div>
                <div class="form-input">
                    <select id="filter-tipo">
                        <option value="">Todos</option>
                        <option value="1">Veterinária</option>
                        <option value="2">Petshop</option>
                        <option value="3">Lazer</option>
                        <option value="4">ONG</option>
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
            if (!locais.isEmpty()){
        %>
        <div class="table-container">
            <table cellspacing="0">
                <tr class="header-tabela">
                    <th class="id-local">ID</th>
                    <th class="id-tipo-local">ID Tipo Local</th>
                    <th class="nome-local">Nome do Local</th>
                    <th class="descricao">Descrição</th>
                    <th class="link-saber-mais">Link saber mais</th>
                    <th class="imagem-local">Imagem do Local</th>
                    <th class="acao">Ações</th>
                </tr>
                <%
                    for (int i = 0; i < locais.size(); i++) {
                %>
                <tr>
                    <td class="id-local"><%=locais.get(i).getIdLocal()%></td>
                    <td class="id-tipo-local"><%=locais.get(i).getIdTipoLocal()%></td>
                    <td class="nome-local"><%=locais.get(i).getNomeLocal()%></td>
                    <td class="descricao"><%=locais.get(i).getDescricao()%></td>
                    <td class="link-saber-mais"><%=locais.get(i).getLinkSaberMais()%></td>
                    <td class="imagem-local"><%=locais.get(i).getImagemLocal()%></td>
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
        <h2>Sem locais disponíveis...</h2>
        <%
            }
        %>
    </div>
</div>
<div class="form-container">
    <form action="local/adicionar" method="post" id="form-adicionar">
        <h1>Adicionar Local</h1>
        <div class="form-input">
            <label for="id-tipo-local">ID Tipo Local</label>
            <select name="id-tipo-local" id="id-tipo-local" required>
                <option value="1">1 - Veterinária</option>
                <option value="2">2 - Petshop</option>
                <option value="3">3 - Lazer</option>
                <option value="4">4 - ONG</option>
            </select>
        </div>
        <div class="form-input">
            <label for="nome-local">Nome do Local</label>
            <input type="text" name="nome-local" id="nome-local" placeholder="Clínica Cães e Gatos..." required>
        </div>
        <div class="form-input">
            <label for="descricao">Descrição</label>
            <input type="text" name="descricao" id="descricao" placeholder="Clínica especializada em..." required>
        </div>
        <div class="form-input">
            <label for="link-saber-mais">Link Saber Mais</label>
            <input type="text" name="link-saber-mais" id="link-saber-mais" placeholder="https://clinica.com.br/caes">
        </div>
        <div class="form-input">
            <label for="imagem-local">Imagem do Local</label>
            <input type="text" name="imagem-local" id="imagem-local" placeholder="https://imagem.jpeg">
        </div>
        <div class="actions">
            <label for="adicionar-btn" id="cancelar">Cancelar</label>
            <input type="submit" value="Adicionar">
        </div>
    </form>
</div>
<div class="edit-container">
    <form action="local/editar" method="post" id="form-editar">
        <h1>Editar Dica Do Dia</h1>
        <div class="form-input">
            <label for="id-tipo-local-e">ID Tipo Local</label>
            <select name="id-tipo-local" id="id-tipo-local-e" required>
                <option value="1">1 - Veterinária</option>
                <option value="2">2 - Petshop</option>
                <option value="3">3 - Lazer</option>
                <option value="4">4 - ONG</option>
            </select>
        </div>
        <div class="form-input">
            <label for="nome-local-e">Nome do Local</label>
            <input type="text" name="nome-local" id="nome-local-e" placeholder="Clínica Cães e Gatos..." required>
        </div>
        <div class="form-input">
            <label for="descricao-e">Descrição</label>
            <input type="text" name="descricao" id="descricao-e" placeholder="Clínica especializada em..." required>
        </div>
        <div class="form-input">
            <label for="link-saber-mais-e">Link Saber Mais</label>
            <input type="text" name="link-saber-mais" id="link-saber-mais-e" placeholder="https://clinica.com.br/caes">
        </div>
        <div class="form-input">
            <label for="imagem-local-e">Imagem do Local</label>
            <input type="text" name="imagem-local" id="imagem-local-e">
        </div>
        <input type="number" name="id-local" id="id-local-e" hidden="hidden" readonly>
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
