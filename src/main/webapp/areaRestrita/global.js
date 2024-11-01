function remover(id, caminhoServlet, mensagem){
    // Cria o elemento do container da confirmação
    let container = document.createElement("div");
    container.className = 'confirm-box-container';

    container.innerHTML = `
            <div class="confirm-box">
                <h1>Confirmar ação</h1>
                <p>${mensagem}</p>
                <img src="/assets/images/ModolinhoCorpoCompleto.png" alt="Imagem">
                <form action="${caminhoServlet}" method="post" class="confirm-form">
                    <input type="hidden" name="id" class="id" value="${id}" readonly>
                    <button type="button" class="cancelar">Cancelar</button>
                    <button type="submit" class="confirmar">Excluir</button>
                </form>
            </div>
        `;

    document.body.appendChild(container);

    // Adiciona evento para o botão cancelar
    container.querySelector(".cancelar").addEventListener("click", function () {
        container.remove();
    });

    // Adiciona evento para o botão confirmar
    container.querySelector(".confirmar").addEventListener("click", function () {
        this.style.pointerEvents = "none";
        container.querySelector(".cancelar").style.pointerEvents = "none";
    });
}
