const pessoas = document.getElementsByClassName("pessoa");
const next = document.getElementById("go-foward");
const prev = document.getElementById("go-back");
const bolas = document.getElementsByClassName("ball-pessoa");

bolas[6].children[0].style.fill = "var(--is-it-green-light)";
let pos = 0;
let max = (pessoas[0].offsetWidth+100)*6;
let min = (pessoas[0].offsetWidth+100)*5;
let index = 6;

window.addEventListener("resize", function(e){
    if (pos!==0){
        for (pessoa of pessoas){
            pessoa.style.transform = "translateX(0px)";
        }
        index = 6;
        for (bola of bolas){
            bola.children[0].style.fill = "var(--off-white)";
        }
        bolas[6].children[0].style.fill = "var(--is-it-green-light)";
        pos=0;
    }
})

next.addEventListener("click", function(){
    let anterior = index;
    min = (pessoas[0].offsetWidth+100)*5
    if (pos <= -min){
        max = (pessoas[0].offsetWidth+100)*6;
        pos = max;
        index = 0;
    } else{
        pos-=pessoas[0].offsetWidth+100;
        index++;
    }
    for (pessoa of pessoas){
        pessoa.style.transform = "translateX("+pos+"px)";
        pessoa.style.transition = ".3s"
    }
    bolas[anterior].children[0].style.fill = "var(--off-white)"
    bolas[index].children[0].style.fill = "var(--is-it-green-light)"
})
prev.addEventListener("click", function(){
    let anterior = index;
    max = (pessoas[0].offsetWidth+100)*6;
    if (pos >= max){
        min = (pessoas[0].offsetWidth+100)*5;
        pos = -min;
        index = 12;
    } else{
        pos+=pessoas[0].offsetWidth+100;
        index--;
    }
    for (pessoa of pessoas){
        pessoa.style.transform = "translateX("+pos+"px)";
        pessoa.style.transition = ".3s"
    }
    bolas[anterior].children[0].style.fill = "var(--off-white)"
    bolas[index].children[0].style.fill = "var(--is-it-green-light)"
})