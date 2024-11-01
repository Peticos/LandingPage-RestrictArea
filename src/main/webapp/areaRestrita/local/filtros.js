const table = document.querySelector("table tbody");
const rows = table.getElementsByTagName("tr");

function filterTable() {
    let input = document.querySelector(".pesquisar input"); // Input de pesquisa
    let filter = input.value.toUpperCase();
    let tr = table.getElementsByTagName("tr");

    for (let i = 1; i < tr.length; i++) {
        let td = tr[i].getElementsByTagName("td")[4]; // Coluna de Nome
        if (td) {
            let txtValue = td.textContent || td.innerText;
            tr[i].style.display = txtValue.toUpperCase().indexOf(filter) > -1 ? "table-row" : "none";
        }
    }
}

document.querySelector(".pesquisar input").addEventListener("keyup", filterTable);

// Filtrar pelo ID
document.querySelector(".id input").addEventListener("keyup", function () {
    for (let i = 1; i < rows.length; i++) {
        rows[i].style.display = rows[i].getElementsByTagName("td")[0].innerText !== this.value ? "none" : "table-row";
    }
});

function limparID() {
    document.querySelector(".id input").value = "";
}

// Parar os filtros
document.getElementById("parar-filtro").addEventListener("click", function () {
    if (document.getElementById("open-btn").checked) {
        limparID();
        for (let i = 1; i < rows.length; i++) {
            rows[i].style.display = "table-row";
        }
    }
});
