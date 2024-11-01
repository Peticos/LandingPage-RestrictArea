// Editar
const editDiv = document.getElementsByClassName("edit-container")[0];
document.querySelectorAll(".edit").forEach(button => {
    button.addEventListener("click", function () {
        const id = Number(this.parentElement.parentElement.children[0].innerText);

        editDiv.children[0].querySelector("#especie-e").value = this.parentElement.parentElement.children[1].innerText;
        editDiv.children[0].querySelector("#id-especie-e").value = id;
    });
});

// Remover
document.querySelectorAll(".remove").forEach(button => {
    button.addEventListener("click", function () {
        let id = Number(this.parentElement.parentElement.children[0].innerText);

        remover(id,  "especie/remover", "Você tem certeza que deseja excluir essa espécie?");
    });
});