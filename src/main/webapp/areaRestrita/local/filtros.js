const table = document.querySelector("table tbody");
const rows = table.getElementsByTagName("tr");

function filterTable() {
    let input = document.querySelector(".pesquisar input"); // Input de pesquisa
    let filter = input.value.toUpperCase();
    let tr = table.getElementsByTagName("tr");

    for (let i = 1; i < tr.length; i++) {
        let td = tr[i].getElementsByTagName("td")[3]; // Coluna de Nome
        if (td) {
            let txtValue = td.textContent || td.innerText;
            tr[i].style.display = txtValue.toUpperCase().indexOf(filter) > -1 ? "table-row" : "none";
        }
    }
}

document.querySelector(".pesquisar input").addEventListener("keyup", filterTable);

// Filtrar pelo Tipo Local
document.getElementById("localSelect").addEventListener("change", function () {
    const filterValue = this.value;
    const rows = document.querySelectorAll("tbody tr:not(.header-tabela)");

    rows.forEach(row => {
        if (row.querySelector(".operacao").textContent !== filterValue) { // Não sei se é .operacao
            row.style.display = "none";
        } else {
            row.style.display = "table-row";
        }
    });
});

// Parar os filtros
document.getElementById("parar-filtro").addEventListener("click", function () {
    if (document.getElementById("open-btn").checked) {
        limparID();
        for (let i = 1; i < rows.length; i++) {
            rows[i].style.display = "table-row";
        }
    }
});
