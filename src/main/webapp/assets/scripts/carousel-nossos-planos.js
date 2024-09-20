const planos = document.getElementsByClassName("plano");
const prox = document.getElementById("go-foward-ne");
const anterior = document.getElementById("go-back-ne");
const bolinhas = document.getElementsByClassName("ball");

bolinhas[1].children[0].style.fill = "var(--is-it-green)";
let indice = 1;
let posicao = 0;
let limite = (planos[0].offsetWidth+100)

window.addEventListener("resize", function(){
    if (posicao!==0){
        for (plano of planos){
            plano.style.transform = "translateX(0px)";
        }
        indice = 1;
        bolinhas[0].children[0].style.fill = "var(--off-white)";
        bolinhas[1].children[0].style.fill = "var(--is-it-green)";
        bolinhas[2].children[0].style.fill = "var(--off-white)";
        posicao = 0;
    }
})

prox.addEventListener("click", function(){
    let ant = indice
    limite = (planos[0].offsetWidth+70)
    if (posicao <= -limite){
        posicao = limite;
        indice=0
    } else{
        posicao-=limite;
        indice++;
    }
    for (plano of planos){
        plano.style.transform = "translateX("+posicao+"px)";
        plano.style.transition = ".3s"
    }
    bolinhas[ant].children[0].style.fill = "var(--off-white)"
    bolinhas[indice].children[0].style.fill = "var(--is-it-green)"
})
anterior.addEventListener("click", function(){
    let ant = indice;
    limite = (planos[0].offsetWidth+70);
    if (posicao >= limite){
        posicao = -limite;
        indice=2;
    } else{
        posicao+=limite;
        indice--;
    }
    for (plano of planos){
        plano.style.transform = "translateX("+posicao+"px)";
        plano.style.transition = ".3s"
    }
    bolinhas[ant].children[0].style.fill = "var(--off-white)"
    bolinhas[indice].children[0].style.fill = "var(--is-it-green)"
})