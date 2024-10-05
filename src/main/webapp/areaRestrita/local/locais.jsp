<%@ page import="java.util.List" %>
<%@ page import="com.peticos.Model.Local" %>
<%@ page import="com.peticos.Controller.Local.CarregarLocal" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!-- Ícone -->
    <link rel="icon" href="../../assets/images/logo_app_branco.png">

    <!-- CSS -->
    <link rel="stylesheet" href="/areaRestrita/local/locais.css">

    <!-- Scripts (JS) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="remover.js" defer></script>
    <script src="filtros.js" defer></script>
    <script src="editar.js" defer></script>

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
        <div class="foto">

        </div>
        <div class="info">
            <h3>Isaac</h3>
            <h5>isaac.dias@germinare.org.br</h5>
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
                    <h2>Total: 14</h2>
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
            List<Local> locais = (List<Local>) request.getAttribute("locais");
            if (locais!=null && !locais.isEmpty()){
        %>
        <table cellspacing="0">
            <tr class="header-tabela">
                <th class="id-local">ID</th>
                <th class="titulo">Tipo Local</th>
                <th class="texto">Nome</th>
                <th class="descricao">Descrição</th>
                <th class="link">Link</th>
                <th class="data-tabela">Imagem</th>
                <th class="acao">Ações</th>
            </tr>
            <%
                for (int i = 0; i < locais.size(); i++) {
            %>
            <tr>
                <td class="id-local"><%=locais.get(i).getId_local()%></td>
                <td class="titulo"><%=locais.get(i).getTipo_local()%></td>
                <td class="texto"><%=locais.get(i).getNome_local()%></td>
                <td class="descricao"><%=locais.get(i).getDescricao()%></td>
                <td class="link"><%=locais.get(i).getLink_saber_mais() %></td>
                <td class="data-tabela"><%=locais.get(i).getimagem_local()%></td>
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
            <label for="nome">Nome</label>
            <input type="text" name="nome" id="nome" placeholder="Petshop...">
        </div>
        <div class="form-input">
            <label for="descricao">Descricao</label>
            <textarea name="descricao" id="descricao" cols="30" rows="10" placeholder="Um loja para cães e gatos..."></textarea>

        </div>
        <div class="form-input">
            <label for="tipo">Tipo</label>
            <input type="number" name="tipo" id="tipo" placeholder="123456">
        </div>
        <div class="form-input">
            <label for="link">Link</label>
            <input type="text" name="link" id="link" placeholder="https://peticos.com.br/caes">
        </div>
        <div class="form-input">
            <label for="img">Imagem</label>
            <input type="text" name="img" id="img" placeholder="htpps://url.com.br/img">
        </div>
        <div class="actions">
            <label for="adicionar-btn" id="cancelar">Cancelar</label>
            <input type="submit" value="Adicionar">
        </div>
    </form>
</div>
<div class="edit-container">
    <form action="local/editar" method="post" id="form-editar">
        <h1>Editar Local</h1>
        <div class="form-input">
            <label for="nome-e">Nome</label>
            <input type="text" name="nome" id="nome-e" placeholder="Como cuidar do seu cachorrinho que está doente?" required>
        </div>
        <div class="form-input">
            <label for="descricao-e">Tipo</label>
            <textarea name="descricao" id="descricao-e" cols="30" rows="10" placeholder="Os cães são ótimos companheiros e gostam..." required></textarea>
        </div>
        <div class="form-input">
            <label for="tipo-e">Tipo</label>
            <input type="text" name="tipo" id="tipo-e" placeholder="123456" required>
        </div>
        <div class="form-input">
            <label for="link">Link</label>
            <input type="text" name="link" id="link-e" placeholder="https://peticos.com.br/caes" required>
        </div>
        <div class="form-input">
            <label for="img">Imagem</label>
            <input type="text" name="img" id="img-e" placeholder="htpps://url.com.br/img">
        </div>
        <input type="number" name="id" id="id-e" hidden="hidden" readonly>
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

