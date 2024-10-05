const table = document.querySelector("table tbody");
const rows = table.getElementsByTagName("tr");

function limparDatas(){
    $("#data-inicio").val("")
    $("#data-fim").val("")
}
function limparID(){
    $(".id")[0].querySelector("input").value = "";
}
function limparFiltros(){
    limparDatas();
    limparID();
}

function filterTable() {
    limparFiltros();

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
                tr[i].style.display = "grid";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}
function filterByDate() {
    const startDate = new Date(document.getElementById("data-inicio").value);
    const endDate = new Date(document.getElementById("data-fim").value);

    limparID();

    for (let i = 1; i < rows.length; i++) {
        const dateCell = rows[i].getElementsByTagName("td")[4]; // Coluna de Data
        const dataTexto = dateCell.innerHTML;
        const dia = dataTexto.substring(0, 2);
        const mes = dataTexto.substring(3, 5);
        const ano = dataTexto.substring(6);
        const dataFormatada = ano + "-" + mes + "-" + dia;
        const rowDate = new Date(dataFormatada);

        if (rowDate >= startDate && rowDate <= endDate) {
            rows[i].style.display = "grid";
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
    limparFiltros();

    let hoje = new Date();
    hoje = String(hoje.toISOString().split('T')[0])

    for (let i = 1; i < rows.length; i++) {
        const dateCell = rows[i].getElementsByTagName("td")[4];
        const dataTexto = dateCell.innerHTML;
        const dia = dataTexto.substring(0, 2);
        const mes = dataTexto.substring(3, 5);
        const ano = dataTexto.substring(6);
        const dataFormatada = String(ano + "-" + mes + "-" + dia);

        if (dataFormatada !== hoje){
            rows[i].style.display = "none";
        } else {
            rows[i].style.display = "grid";
        }
    }
})

// Filtrar pelo id
$(".id")[0].querySelector("input").addEventListener("keyup", function (){
    limparDatas();

    console.log(this.value)
    for (let i = 1; i < rows.length; i++) {
        if (rows[i].getElementsByTagName("td")[0].innerText!==this.value){
            rows[i].style.display = "none";
            console.log()
        } else{
            rows[i].style.display = "grid";
        }
    }
});

// Parar os filtros
document.getElementById("parar-filtro").addEventListener("click", function (){
    if ($('#open-btn').is(":checked")){
        limparFiltros();

        for (let i = 1; i < rows.length; i++) {
            rows[i].style.display = "grid";
        }
    }
})
