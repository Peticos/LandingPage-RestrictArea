const table = document.querySelector("table tbody");
const rows = table.getElementsByTagName("tr");

function filterTable() {

    let input = document.querySelector(".pesquisar input"); // Input de pesquisa
    let filter = input.value.toUpperCase();
    let table = document.querySelector("table tbody");
    let tr = table.getElementsByTagName("tr");

    for (let i = 1; i < tr.length; i++) {
        let td = tr[i].getElementsByTagName("td")[2]; // Coluna de Título
        if (td) {
            let txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "table-row";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

document.querySelector(".pesquisar input").addEventListener("keyup", filterTable);


// Filtrar pelo id
$(".id")[0].querySelector("input").addEventListener("keyup", function (){

    console.log(this.value)
    for (let i = 1; i < rows.length; i++) {
        if (rows[i].getElementsByTagName("td")[0].innerText!==this.value){
            rows[i].style.display = "none";
            console.log()
        }
        else{
            rows[i].style.display = "table-row";
        }
    }
});

function limparID(){
    $(".id")[0].querySelector("input").value = "";
}

// Parar os filtros
document.getElementById("parar-filtro").addEventListener("click", function (){
    if ($('#open-btn').is(":checked")){
        limparID();

        for (let i = 1; i < rows.length; i++) {
            rows[i].style.display = "table-row";
        }
    }
})
