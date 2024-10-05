const editDiv = document.getElementsByClassName("edit-container")[0];
$(".edit").click(function (){
    const id = Number(this.parentElement.parentElement.children[0].innerText);
    console.log(id)

    editDiv.children[0].querySelector("#id-tipo-local-e").value = this.parentElement.parentElement.children[1].innerText;

    editDiv.children[0].querySelector("#nome-local-e").value = this.parentElement.parentElement.children[2].innerText;

    editDiv.children[0].querySelector("#descricao-e").value = this.parentElement.parentElement.children[3].innerText;

    editDiv.children[0].querySelector("#link-saber-mais-e").value = this.parentElement.parentElement.children[4].innerText;

    editDiv.children[0].querySelector("#imagem-local-e").value = this.parentElement.parentElement.children[5].innerText;

    editDiv.children[0].querySelector("#id-local-e").value = id;
})