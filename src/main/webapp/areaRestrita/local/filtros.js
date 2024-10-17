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
                tr[i].style.display = "grid";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

document.querySelector(".pesquisar input").addEventListener("keyup", filterTable);
