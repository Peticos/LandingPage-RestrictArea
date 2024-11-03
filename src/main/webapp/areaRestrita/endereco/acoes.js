// Editar

// Remover
document.querySelectorAll(".remove").forEach(button => {
    button.addEventListener("click", function () {
        let id = Number(this.parentElement.parentElement.children[0].innerText);

        remover(id,  "endereco/remover", "Você tem certeza que deseja excluir esse endereço?");
    });
});
