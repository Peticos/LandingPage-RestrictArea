$(".remove").click(function () {
    let id = Number(this.parentElement.parentElement.children[0].innerText);

    let container = document.createElement("div");
    container.className = 'confirm-box-container';

    container.innerHTML = `
        <div class="confirm-box">
            <h1>Confirmar ação</h1>
            <p>Você tem certeza que deseja excluir esse administrador?</p>
            <img src="../../assets/images/ModolinhoCorpoCompleto.png" alt="Imagem">
            <form action="administradores/remover" method="post" class="confirm-form">
                <input type="hidden" name="id-administrador" class="id-administrador" value="${id}" readonly>
                <button type="button" class="cancelar">Cancelar</button>
                <button type="submit" class="confirmar">Excluir</button>
            </form>
        </div>
    `;

    document.body.appendChild(container);

    // Adiciona os eventos
    container.querySelector(".cancelar").addEventListener("click", function () {
        container.remove();
    });

    container.querySelector(".confirmar").addEventListener("click", function () {
        this.style.pointerEvents = "none";
        container.querySelector(".cancelar").style.pointerEvents = "none";
    });
});
