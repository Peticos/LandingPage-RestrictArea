function filterTable() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.querySelector(".pesquisar input"); // Input de pesquisa
    filter = input.value.toUpperCase();
    table = document.querySelector("table tbody");
    tr = table.getElementsByTagName("tr");

    for (i = 1; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1]; // Coluna de Título
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function filterByDate() {
    var startDate = new Date(document.getElementById("data-inicio").value);
    var endDate = new Date(document.getElementById("data-fim").value);
    var table = document.querySelector("table tbody");
    var rows = table.getElementsByTagName("tr");

    for (var i = 1; i < rows.length; i++) {
        var dateCell = rows[i].getElementsByTagName("td")[4]; // Coluna de Data
        var dataTexto = dateCell.innerHTML
        var dia = dataTexto.substring(0, 2)
        var mes = dataTexto.substring(3, 5)
        var ano = dataTexto.substring(6)
        var dataFormatada = ano+"-"+mes+"-"+dia
        var rowDate = new Date(dataFormatada);

        if (rowDate >= startDate && rowDate <= endDate) {
            rows[i].style.display = "";
        } else {
            rows[i].style.display = "none";
        }
    }
}

// Adicionar listeners para os inputs de data e um listener para o campo de pesquisa
document.getElementById("data-inicio").addEventListener("change", filterByDate);
document.getElementById("data-fim").addEventListener("change", filterByDate);
document.querySelector(".pesquisar input").addEventListener("keyup", filterTable);