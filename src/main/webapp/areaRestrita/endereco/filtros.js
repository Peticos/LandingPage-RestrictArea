const table = document.querySelector("table tbody");
const rows = table.getElementsByTagName("tr");

// Funções genéricas
function limparID() {
    document.querySelector(".id input").value = "";
}

function filterTable() {
    limparID();

    let input = document.querySelector(".pesquisar input"); // Input de pesquisa
    let filter = input.value.toUpperCase();
    let table = document.querySelector("table tbody");
    let tr = table.getElementsByTagName("tr");

    for (let i = 1; i < tr.length; i++) {
        let td = tr[i].getElementsByTagName("td")[3]; // Coluna de Bairro
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

// Filtrar pelo id
function filtrarPorId() {
    for (let i = 1; i < rows.length; i++) {
        if (rows[i].getElementsByTagName("td")[0].innerText !== this.value) {
            rows[i].style.display = "none";
        } else {
            rows[i].style.display = "table-row";
        }
    }
}

// Parar os filtros
function pararFiltros() {
    if (document.getElementById('open-btn').checked) {
        limparID();

        for (let i = 1; i < rows.length; i++) {
            rows[i].style.display = "table-row";
        }
    }
}

// Event listeners
document.querySelector(".pesquisar input").addEventListener("keyup", filterTable);
document.getElementById("filtrar-id").addEventListener("keyup", filtrarPorId);
document.getElementById("parar-filtro").addEventListener("click", pararFiltros);


