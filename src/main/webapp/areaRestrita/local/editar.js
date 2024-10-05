const editDiv = document.getElementsByClassName("edit-container")[0];
$(".edit").click(function (){
    const id = Number(this.parentElement.parentElement.children[0].innerText);

    editDiv.children[0].querySelector("#nome-e").value = this.parentElement.parentElement.children[1].innerText;

    editDiv.children[0].querySelector("#descricao-e").value = this.parentElement.parentElement.children[2].innerText;

    editDiv.children[0].querySelector("#tipo-e").value = this.parentElement.parentElement.children[3].innerText;

    editDiv.children[0].querySelector("#link-e").value = this.parentElement.parentElement.children[4].innerText;

    editDiv.children[0].querySelector("#img-e").value = this.parentElement.parentElement.children[5].innerText;

    editDiv.children[0].querySelector("#id-e").value = id;
})