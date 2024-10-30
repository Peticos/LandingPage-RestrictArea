const table = document.querySelector("table tbody");
const rows = table.getElementsByTagName("tr");


function filterTable() {

    let input = document.querySelector(".pesquisar input"); // Input de pesquisa
    let filter = input.value.toUpperCase();
    let table = document.querySelector("table tbody");
    let tr = table.getElementsByTagName("tr");

    for (let i = 1; i < tr.length; i++) {
        let td = tr[i].getElementsByTagName("td")[0]; // Coluna de Título
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


// Filtrar por operação
document.getElementById("operationSelect").addEventListener("change", function () {
    const filterValue = this.value;
    const rows = document.querySelectorAll("tbody tr:not(.header-tabela)");

    rows.forEach(row => {
        if (row.querySelector(".operacao").textContent !== filterValue) {
            row.style.display = "none";
        } else {
            row.style.display = "table-row";
        }
    });
});

// Parar os filtros
document.getElementById("parar-filtro").addEventListener("click", function (){
    if ($('#open-btn').is(":checked")){
        document.getElementById("operationSelect").selectedIndex = 0;
        const rows = document.querySelectorAll("tbody tr:not(.header-tabela)");

        rows.forEach(row => {
            row.style.display = "table-row";
        });
    }
})



