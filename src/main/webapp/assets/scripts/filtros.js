const table = document.querySelector("table tbody");
const rows = table.getElementsByTagName("tr");

function filterTable() {
    let input, filter, table, tr, td, i, txtValue;
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
    const startDate = new Date(document.getElementById("data-inicio").value);
    const endDate = new Date(document.getElementById("data-fim").value);
    console.log("Start date: "+startDate)
    for (let i = 1; i < rows.length; i++) {
        const dateCell = rows[i].getElementsByTagName("td")[4]; // Coluna de Data
        const dataTexto = dateCell.innerHTML;
        const dia = dataTexto.substring(0, 2);
        const mes = dataTexto.substring(3, 5);
        const ano = dataTexto.substring(6);
        const dataFormatada = ano + "-" + mes + "-" + dia;
        const rowDate = new Date(dataFormatada);

        console.log("Row date: "+rowDate)
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

// Dica De Hoje
document.getElementById("dica-hoje").addEventListener("click", function (){
    let hoje = new Date();
    hoje = String(hoje.toISOString().split('T')[0])

    console.log("Hoje: "+hoje)
    for (let i = 1; i < rows.length; i++) {
        const dateCell = rows[i].getElementsByTagName("td")[4];
        const dataTexto = dateCell.innerHTML;
        const dia = dataTexto.substring(0, 2);
        const mes = dataTexto.substring(3, 5);
        const ano = dataTexto.substring(6);
        const dataFormatada = String(ano + "-" + mes + "-" + dia);
        console.log("Row date: "+dataFormatada)

        if (dataFormatada !== hoje){
            rows[i].style.display = "none";
        } else {
            rows[i].style.display = "grid";
        }
    }
})

// Parar os filtros
document.getElementById("parar-filtro").addEventListener("click", function (){
    if ($('#open-btn').is(":checked")){
        console.log("Limpando filtros");

        for (let i = 1; i < rows.length; i++) {
            rows[i].style.display = "grid";
        }
    }
})
