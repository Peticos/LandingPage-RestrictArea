// Editar
const editDiv = document.getElementsByClassName("edit-container")[0];
document.querySelectorAll(".edit").forEach(button => {
    button.addEventListener("click", function () {
        const id = Number(this.parentElement.parentElement.children[0].innerText);

        editDiv.children[0].querySelector("#estado-e").value = this.parentElement.parentElement.children[1].innerText;
        editDiv.children[0].querySelector("#cidade-e").value = this.parentElement.parentElement.children[2].innerText;
        editDiv.children[0].querySelector("#bairro-e").value = this.parentElement.parentElement.children[3].innerText;
    });
});

// Remover
document.querySelectorAll(".remove").forEach(button => {
    button.addEventListener("click", function () {
        let id = Number(this.parentElement.parentElement.children[0].innerText);

        remover(id,  "endereco/remover", "Você tem certeza que deseja excluir esse endereço?");
    });
});
