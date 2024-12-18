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
    <script src="local/acoes.js" defer></script>
    <script src="local/filtros.js" defer></script>
    <script src="global.js" defer></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Locais - Área Restrita - Peticos</title>
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
                <div class="id">
                    <h3>ID</h3>
                    <input type="number" placeholder="12345">
                </div>

                <div class="id id-tipo-local-filtro">
                    <h3>Tipo Local</h3>
                    <select id="localSelect">
                        <option value="ONG">ONG</option>
                        <option value="Parque">Parque</option>
                        <option value="PetShop">PetShop</option>
                        <option value="Veterinário">Veterinário</option>
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
            <table>
                <tr class="header-tabela">
                    <th class="id-local invisivel">ID</th>
                    <th class="id-tipo-local primeiro">Tipo Local</th>
                    <th class="id-endereco">ID Endereço</th>
                    <th class="nome-local">Nome do Local</th>
                    <th class="descricao">Descrição</th>
                    <th class="link-saber-mais invisivel">Link saber mais</th>
                    <th class="imagem-local invisivel">Imagem do Local</th>
                    <th class="rua-local">Rua</th>
                    <th class="numero-local">Número</th>
                    <th class="telefone-local invisivel">Telefone</th>
                    <th class="acao ultimo">Ações</th>
                </tr>
                <%
                    for (int i = 0; i < locais.size(); i++) {
                %>
                <tr>
                    <td class="id-local invisivel"><%=locais.get(i).getIdLocal()%></td>
                    <td class="id-tipo-local"><%=locais.get(i).getTipoLocal()%></td>
                    <td class="id-endereco"><%=locais.get(i).getIdEndereco()%></td>
                    <td class="nome-local"><%=locais.get(i).getNomeLocal()%></td>
                    <td class="descricao"><%=locais.get(i).getDescricao()%></td>
                    <td class="link-saber-mais invisivel"><%=locais.get(i).getLinkSaberMais()%></td>
                    <td class="imagem-local invisivel"><%=locais.get(i).getImagemLocal()%></td>
                    <td class="rua-local"><%=locais.get(i).getRua()%></td>
                    <td class="numero-local"><%=locais.get(i).getNumero()%></td>
                    <td class="telefone-local invisivel"><%=locais.get(i).getTelefoneFormatado()%></td>
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
    <form action="/areaRestrita/local/adicionar" method="post" id="form-adicionar">
        <h1>Adicionar Local</h1>
        <div class="form-input">
            <label for="id-tipo-local">ID Tipo Local</label>
            <select name="id-tipo-local" id="id-tipo-local" required>
                <option value="2">1 - Veterinária</option>
                <option value="3">2 - Petshop</option>
                <option value="1">3 - Parque</option>
                <option value="4">4 - ONG</option>
            </select>
        </div>
        <div class="form-input">
            <label for="id-endereco">ID Endereço</label>
            <input type="text" name="id-endereco" id="id-endereco" placeholder="123456" required>
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
            <label for="telefone-local">Telefone</label>
            <input type="tel" name="telefone-local" id="telefone-local" placeholder="(xx) xxxxx-xxxx" required>
        </div>
        <div class="form-input">
            <label for="link-saber-mais">Link Saber Mais</label>
            <input type="text" name="link-saber-mais" id="link-saber-mais" placeholder="https://clinica.com.br/caes" required>
            <h4>Deve começar com "https://" e a extensão de domínio ".com", ".org" ou ".gov"</h4>
        </div>
        <div class="form-input">
            <label for="imagem-local">Imagem do Local</label>
            <input type="text" name="imagem-local" id="imagem-local" placeholder="https://imagem.jpeg" required>
            <h4>Deve começar com "https://" e a extensão de domínio ".com", ".org" ou ".gov"</h4>
        </div>
        <div class="form-input">
            <label for="imagem-local">Rua</label>
            <input type="text" name="rua-local" id="rua-local" placeholder="Rua xxxx" required>
        </div>
        <div class="form-input">
            <label for="numero-local">Número</label>
            <input type="text" name="numero-local" id="numero-local" placeholder="123456" required>
        </div>
        <div class="actions">
            <label for="adicionar-btn" id="cancelar">Cancelar</label>
            <input type="submit" value="Adicionar">
        </div>
    </form>
</div>
<div class="edit-container">
    <form action="/areaRestrita/local/editar" method="post" id="form-editar">
        <h1>Editar Local</h1>
        <div class="form-input">
            <label for="id-tipo-local-e">ID Tipo Local</label>
            <select name="id-tipo-local-e" id="id-tipo-local-e" required>
                <option value="2">1 - Veterinária</option>
                <option value="3">2 - Petshop</option>
                <option value="1">3 - Parque</option>
                <option value="4">4 - ONG</option>
            </select>
        </div>
        <div class="form-input">
            <label for="id-endereco-e">ID Endereço</label>
            <input type="text" name="id-endereco-e" id="id-endereco-e" placeholder="123456" required>
        </div>
        <div class="form-input">
            <label for="nome-local-e">Nome do Local</label>
            <input type="text" name="nome-local-e" id="nome-local-e" placeholder="Clínica Cães e Gatos..." required>
        </div>
        <div class="form-input">
            <label for="descricao-e">Descrição</label>
            <input type="text" name="descricao-e" id="descricao-e" placeholder="Clínica especializada em..." required>
        </div>
        <div class="form-input">
            <label for="telefone-local-e">Telefone</label>
            <input type="tel" name="telefone-local-e" id="telefone-local-e" placeholder="(xx) xxxxx-xxxx" required>
        </div>
        <div class="form-input">
            <label for="link-saber-mais-e">Link Saber Mais</label>
            <input type="text" name="link-saber-mais-e" id="link-saber-mais-e" placeholder="https://clinica.com.br/caes">
            <h4>Deve começar com "https://" e a extensão de domínio ".com", ".org" ou ".gov"</h4>
        </div>
        <div class="form-input">
            <label for="imagem-local-e">Imagem do Local</label>
            <input type="text" name="imagem-local-e" id="imagem-local-e">
            <h4>Deve começar com "https://" e a extensão de domínio ".com", ".org" ou ".gov"</h4>
        </div>
        <div class="form-input">
            <label for="rua-local-e">Rua</label>
            <input type="text" name="rua-local-e" id="rua-local-e" placeholder="Rua xxxx">
        </div>
        <div class="form-input">
            <label for="numero-local-e">Número</label>
            <input type="text" name="numero-local-e" id="numero-local-e" placeholder="123456">
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
