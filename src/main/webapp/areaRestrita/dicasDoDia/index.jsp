<%@ page import="java.util.List" %>
<%@ page import="com.peticos.Model.DicaDoDia" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
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
    <!-- Lilita One & Varela Round (fontes da página) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <!-- Varela Round -->
    <link href="https://fonts.googleapis.com/css2?family=Lilita+One&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Varela+Round&display=swap" rel="stylesheet">
    <!-- Lilita One -->
    <link href="https://fonts.googleapis.com/css2?family=Lilita+One&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Varela+Round&display=swap" rel="stylesheet">

    <!-- Ícone -->
    <link rel="icon" href="../../assets/images/logo_app_branco.png">

    <!-- CSS -->
    <link rel="stylesheet" href="../../assets/styles/dicas.css">

    <!-- Scripts (JS) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="../../assets/scripts/remover.js" defer></script>
    <script src="../../assets/scripts/filtros.js" defer></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dicas do Dia - Área Restrita - Peticos</title>
</head>
<body>
<input type="checkbox" id="adicionar-btn" name="adicionar-btn">
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
        <li class="selecionado">
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
                    <input type="number" placeholder="12345">
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
        if (dicas!=null && !dicas.isEmpty()){
        %>
        <table cellspacing="0">
            <tr class="header-tabela">
                <th class="id-dica">ID</th>
                <th class="titulo">Título</th>
                <th class="texto">Texto</th>
                <th class="link">Link</th>
                <th class="data-tabela">Data</th>
                <th class="acao">Ações</th>
            </tr>
            <%
            for (int i = 0; i < dicas.size(); i++) {
            %>
            <tr>
                <td class="id-dica"><%=dicas.get(i).getId()%></td>
                <td class="titulo"><%=dicas.get(i).getTitulo()%></td>
                <td class="texto"><%=dicas.get(i).getTexto()%></td>
                <td class="link"><%=dicas.get(i).getLink()%></td>
                <td class="data-tabela"><%=dicas.get(i).getFormatedData()%></td>
                <td class="acao">
                    <button class="edit">
                        <img src="../../assets/images/edit.svg" alt="">
                    </button>
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
            <input type="text" name="titulo" id="titulo" placeholder="Como cuidar do seu cachorrinho que está doente?">
        </div>
        <div class="form-input">
            <label for="texto">Texto</label>
            <textarea name="texto" id="texto" cols="30" rows="10" placeholder="Os cães são ótimos companheiros e gostam..."></textarea>

        </div>
        <div class="form-input">
            <label for="link">Link</label>
            <input type="text" name="link" id="link" placeholder="https://peticos.com.br/caes">
        </div>
        <div class="form-input">
            <label for="data">Data</label>
            <input type="date" name="data" id="data">
        </div>
        <div class="actions">
            <label for="adicionar-btn" id="cancelar">Cancelar</label>
            <input type="submit" value="Adicionar">
        </div>
    </form>
</div>
<script>
    document.getElementById('form-adicionar').addEventListener("submit", function (e){
        const submitButton = document.querySelector('input[type="submit"]');
        submitButton.disabled = true;
    })
</script>
</body>
</html>
