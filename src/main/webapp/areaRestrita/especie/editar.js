const editDiv = document.getElementsByClassName("edit-container")[0];
$(".edit").click(function (){
    const id = Number(this.parentElement.parentElement.children[0].innerText);

    editDiv.children[0].querySelector("#especie-e").value = this.parentElement.parentElement.children[1].innerText;

    editDiv.children[0].querySelector("#id-especie-e").value = id;
})