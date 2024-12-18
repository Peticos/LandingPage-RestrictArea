const table = document.querySelector("table tbody");
const rows = table.getElementsByTagName("tr");

// Funções genéricas
function limparDatas() {
    document.getElementById("data-inicio").value = "";
    document.getElementById("data-fim").value = "";
}
function limparID() {
    document.querySelector(".id input").value = "";
}
function limparFiltros() {
    limparDatas();
    limparID();
}

// Funções de filtro
function filtrarPorTexto() {
    limparFiltros();

    let input = document.querySelector(".pesquisar input"); // Input de pesquisa
    let filter = input.value.toUpperCase();
    let tr = table.getElementsByTagName("tr");

    for (let i = 1; i < tr.length; i++) {
        let td = tr[i].getElementsByTagName("td")[1]; // Coluna de Título
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
function filtrarPorData() {
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
            rows[i].style.display = "table-row";
        } else {
            rows[i].style.display = "none";
        }
    }
}
function filtrarPorId() {
    limparDatas();

    for (let i = 1; i < rows.length; i++) {
        if (rows[i].getElementsByTagName("td")[0].innerText !== this.value) {
            rows[i].style.display = "none";
        } else {
            rows[i].style.display = "table-row";
        }
    }
}
function mostrarDicaDeHoje() {
    limparFiltros();

    let hoje = new Date();
    hoje = String(hoje.toISOString().split('T')[0]);

    for (let i = 1; i < rows.length; i++) {
        const dateCell = rows[i].getElementsByTagName("td")[4];
        const dataTexto = dateCell.innerHTML;
        const dia = dataTexto.substring(0, 2);
        const mes = dataTexto.substring(3, 5);
        const ano = dataTexto.substring(6);
        const dataFormatada = String(ano + "-" + mes + "-" + dia);

        if (dataFormatada !== String(hoje)) {
            rows[i].style.display = "none";
        } else {
            rows[i].style.display = "table-row";
        }
    }
}
function pararFiltros() {
    if (document.getElementById('open-btn').checked) {
        limparFiltros();

        for (let i = 1; i < rows.length; i++) {
            rows[i].style.display = "table-row";
        }
    }
}

// Event listeners
document.getElementById("data-inicio").addEventListener("change", filtrarPorData);
document.getElementById("data-fim").addEventListener("change", filtrarPorData);
document.querySelector(".pesquisar input").addEventListener("keyup", filtrarPorTexto);
document.getElementById("dica-hoje").addEventListener("click", mostrarDicaDeHoje);
document.getElementById("filtrar-id").addEventListener("keyup", filtrarPorId);
document.getElementById("parar-filtro").addEventListener("click", pararFiltros);
