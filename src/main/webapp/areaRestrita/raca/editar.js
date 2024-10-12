const editDiv = document.getElementsByClassName("edit-container")[0];
$(".edit").click(function (){
    const id = Number(this.parentElement.parentElement.children[0].innerText);

    editDiv.children[0].querySelector("#nome-raca-e").value = this.parentElement.parentElement.children[1].innerText;

    editDiv.children[0].querySelector("#id-raca-e").value = id;
})