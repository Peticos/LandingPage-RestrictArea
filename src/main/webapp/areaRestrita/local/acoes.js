// Editar
const editDiv = document.getElementsByClassName("edit-container")[0];
document.querySelectorAll(".edit").forEach(button => {
    button.addEventListener("click", function () {
        const id = Number(this.parentElement.parentElement.children[0].innerText);

        editDiv.children[0].querySelector("#id-tipo-local-e").value = this.parentElement.parentElement.children[1].innerText;
        editDiv.children[0].querySelector("#id-endereco-e").value = this.parentElement.parentElement.children[2].innerText;
        editDiv.children[0].querySelector("#nome-local-e").value = this.parentElement.parentElement.children[3].innerText;
        editDiv.children[0].querySelector("#descricao-e").value = this.parentElement.parentElement.children[4].innerText;
        editDiv.children[0].querySelector("#link-saber-mais-e").value = this.parentElement.parentElement.children[5].innerText;
        editDiv.children[0].querySelector("#imagem-local-e").value = this.parentElement.parentElement.children[6].innerText;
        editDiv.children[0].querySelector("#rua-local-e").value = this.parentElement.parentElement.children[7].innerText;
        editDiv.children[0].querySelector("#numero-local-e").value = this.parentElement.parentElement.children[8].innerText;
        editDiv.children[0].querySelector("#telefone-local-e").value = this.parentElement.parentElement.children[9].innerText;
        editDiv.children[0].querySelector("#id-e").value = id;
    });
});


// Remover
document.querySelectorAll(".remove").forEach(button => {
    button.addEventListener("click", function () {
        let id = Number(this.parentElement.parentElement.children[0].innerText);

        remover(id,  "local/remover", "Você tem certeza que deseja excluir esse local?");
    });
});