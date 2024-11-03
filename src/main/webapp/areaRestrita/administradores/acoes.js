// Editar
const editDiv = document.getElementsByClassName("edit-container")[0];
document.querySelectorAll(".edit").forEach(button => {
    button.addEventListener("click", function () {
        // Preenche o form de editar com as informações do campo escolhido
        const id = Number(this.parentElement.parentElement.children[0].innerText);

        editDiv.children[0].querySelector("#nome-administrador-e").value = this.parentElement.parentElement.children[1].innerText;
        editDiv.children[0].querySelector("#e-mail-administrador-e").value = this.parentElement.parentElement.children[2].innerText;
        editDiv.children[0].querySelector("#id-administrador-e").value = id;
    });
});

// Remover
document.querySelectorAll(".remove").forEach(button => {
    button.addEventListener("click", function () {
        let id = Number(this.parentElement.parentElement.children[0].innerText);

        remover(id,  "administradores/remover", "Você tem certeza que deseja excluir esse administrador?");
    });
});
