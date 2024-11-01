// Editar
const editDiv = document.getElementsByClassName("edit-container")[0];
document.querySelectorAll(".edit").forEach(button => {
    button.addEventListener("click", function () {
        const id = Number(this.parentElement.parentElement.children[0].innerText);

        editDiv.children[0].querySelector("#titulo-e").value = this.parentElement.parentElement.children[1].innerText;
        editDiv.children[0].querySelector("#texto-e").value = this.parentElement.parentElement.children[2].innerText;
        editDiv.children[0].querySelector("#link-e").value = this.parentElement.parentElement.children[3].innerText;

        const data = this.parentElement.parentElement.children[4].innerText;
        const dia = data.substring(0, 2);
        const mes = data.substring(3, 5);
        const ano = data.substring(6);
        const dataFormatada = ano + "-" + mes + "-" + dia;

        editDiv.children[0].querySelector("#data-e").value = dataFormatada;
        editDiv.children[0].querySelector("#id-e").value = id;
    });
});

// Remover
document.querySelectorAll(".remove").forEach(button => {
    button.addEventListener("click", function () {
        let id = Number(this.parentElement.parentElement.children[0].innerText);

        remover(id, "dicasDoDia/remover", "Você tem certeza que deseja excluir essa dica?")
    });
});