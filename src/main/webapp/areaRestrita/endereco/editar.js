const editDiv = document.getElementsByClassName("edit-container")[0];
$(".edit").click(function (){
    const id = Number(this.parentElement.parentElement.children[0].innerText);

    editDiv.children[0].querySelector("#estado-e").value = this.parentElement.parentElement.children[1].innerText;

    editDiv.children[0].querySelector("#cidade-e").value = this.parentElement.parentElement.children[2].innerText;

    editDiv.children[0].querySelector("#bairro-e").value = this.parentElement.parentElement.children[3].innerText;
})