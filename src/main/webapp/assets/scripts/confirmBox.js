$(".remove").click(function (){
    let id = Number(this.parentElement.getAttribute("id"));
    console.log(this)
    console.log(this.parentElement)
    console.log(id)

    let container = document.createElement("div");
    container.className = 'confirm-box-container';

    let confirmBox = document.createElement("div");
    confirmBox.className = 'confirm-box';

    let textoConfirmar = document.createElement("h1");
    textoConfirmar.innerText = 'Confirmar ação';

    let pTexto = document.createElement("p");
    pTexto.innerText = 'Você tem certeza que deseja excluir essa dica?';

    let imagem = document.createElement("img");
    imagem.src = '../../assets/images/ModolinhoCorpoCompleto.png';

    let form = document.createElement("form")
    form.action = 'remover'
    form.method='post'
    form.className = 'confirm-form';

    let idBox = document.createElement("input")
    idBox.className = 'id_dica'
    idBox.setAttribute("type", "hidden");
    idBox.setAttribute("name", "id_dica");
    idBox.readOnly = true;
    idBox.value = id;

    let btnCancelar = document.createElement("button");
    btnCancelar.innerText = 'Cancelar';
    btnCancelar.setAttribute("type", "button");
    btnCancelar.className = 'cancelar';

    let btnExcluir = document.createElement("button");
    btnExcluir.innerText = 'Excluir';
    btnExcluir.setAttribute("type", "submit");
    btnExcluir.className = 'confirmar'

    container.appendChild(confirmBox);

    confirmBox.appendChild(textoConfirmar);
    confirmBox.appendChild(pTexto);
    confirmBox.appendChild(imagem);
    confirmBox.appendChild(form);

    form.appendChild(idBox);
    form.appendChild(btnCancelar);
    form.appendChild(btnExcluir);

    document.body.appendChild(container)

    btnCancelar.addEventListener("click", function (){
        container.remove();
    })
    btnExcluir.addEventListener("click", function (){
        btnExcluir.style.pointerEvents = "none"
        btnCancelar.style.pointerEvents = "none"
    })
})