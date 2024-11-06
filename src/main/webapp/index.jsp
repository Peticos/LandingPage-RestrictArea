<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!-- Ícone -->
    <link rel="icon" href="assets/images/logo_app_branco.png">

    <!-- Styles (CSS) -->
    <link rel="stylesheet" href="landing.css">

    <!-- Scripts (JavaScript) -->
    <script src="assets/scripts/carousel-nossa-equipe.js" defer></script>
    <script src="assets/scripts/carousel-nossos-planos.js" defer></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Peticos - Landing Page</title>
</head>
<body>
    <!-- Checkbox para ativação do menu lateral -->
    <input type="checkbox" name="input-menu-lateral" id="input-menu-lateral">
    <!-- Menu lateral (Só para telas menores) -->
    <div id="menu-lateral-container">
        <div id="menu-lateral">
            <label for="input-menu-lateral">
                <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-424 284-228q-11 11-28 11t-28-11q-11-11-11-28t11-28l196-196-196-196q-11-11-11-28t11-28q11-11 28-11t28 11l196 196 196-196q11-11 28-11t28 11q11 11 11 28t-11 28L536-480l196 196q11 11 11 28t-11 28q-11 11-28 11t-28-11L480-424Z"></path></svg>
            </label>
            <ul>
                <li>
                    <a href="#microempresas" onclick="document.getElementById('input-menu-lateral').checked = false;">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-340q33 0 56.5-23.5T560-420q0-33-23.5-56.5T480-500q-33 0-56.5 23.5T400-420q0 33 23.5 56.5T480-340ZM160-120q-33 0-56.5-23.5T80-200v-440q0-33 23.5-56.5T160-720h160v-80q0-33 23.5-56.5T400-880h160q33 0 56.5 23.5T640-800v80h160q33 0 56.5 23.5T880-640v440q0 33-23.5 56.5T800-120H160Zm0-80h640v-440H160v440Zm240-520h160v-80H400v80ZM160-200v-440 440Z"></path></svg>
                        <p>Microempresas</p>
                    </a>
                </li>
                <li>
                    <a href="#entre-contato" onclick="document.getElementById('input-menu-lateral').checked = false;">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M160-160q-33 0-56.5-23.5T80-240v-480q0-33 23.5-56.5T160-800h640q33 0 56.5 23.5T880-720v480q0 33-23.5 56.5T800-160H160Zm640-480L501-453q-5 3-10.5 4.5T480-447q-5 0-10.5-1.5T459-453L160-640v400h640v-400ZM480-520l320-200H160l320 200ZM160-640v10-59 1-32 32-.5 58.5-10 400-400Z"></path></svg>
                        <p>Contato</p>
                    </a>
                </li>
                <li>
                    <a href="#bem-vindo" onclick="document.getElementById('input-menu-lateral').checked = false;">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-280q17 0 28.5-11.5T520-320v-160q0-17-11.5-28.5T480-520q-17 0-28.5 11.5T440-480v160q0 17 11.5 28.5T480-280Zm0-320q17 0 28.5-11.5T520-640q0-17-11.5-28.5T480-680q-17 0-28.5 11.5T440-640q0 17 11.5 28.5T480-600Zm0 520q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z"></path></svg>
                        <p>Sobre</p>
                    </a>
                </li>
                <li>
                    <a href="https://www.instagram.com/_peticos/" target="_blank" onclick="document.getElementById('input-menu-lateral').checked = false;">
                        <img src="assets/images/instagram_.svg" alt="">
                        <p>Instagram</p>
                    </a>
                </li>
            </ul>
        </div>
        <label for="input-menu-lateral"></label>
    </div>
    <header>
        <img src="assets/images/Simplified Logo.svg" alt="Peticos" id="header-logo">
        <ul id="header-contatos">
            <li><a href="#microempresas">Microempresas</a></li>
            <li><a href="#entre-contato">Contato</a></li>
            <li><a href="#bem-vindo">Sobre</a></li>
            <li><a href="https://www.instagram.com/_peticos/" target="_blank"><img src="assets/images/instagram_.svg" alt="Instagram"></a></li>
            <li>
                <label for="input-menu-lateral" id="btn-menu-lateral">
                    <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M120-240v-80h720v80H120Zm0-200v-80h720v80H120Zm0-200v-80h720v80H120Z"></path></svg>
                </label>
            </li>
        </ul>
    </header>

    <!--Container para mensagem de bem-vindo-->
    <div id="bem-vindo">
        <div class="textos">
            <h1 class="titulo">
                Seja bem-vindo ao Peticos!
            </h1>
            <p>
                O Peticos é um aplicativo direcionado à comunidade tutores de pets e profissionais da área!
                Nossa missão é manter o bem-estar animal das comunidades e estimular a economia nesse ramo.
            </p>
        </div>
        <div id="celulares-container">
            <img src="assets/images/Celulares.png" alt="" id="celulares">
        </div>
    </div>

    <!--Container de planos premium-->
    <div id="nossos-planos-container">
        <div class="rolagem">
            <div class="item item1">
                <p>Pet Amigo</p>
            </div>
            <div class="item item2">
                <p>Família</p>
            </div>
            <div class="item item3">
                <p>Amor</p>
            </div>
            <div class="item item4">
                <p>Cuidado</p>
            </div>
            <div class="item item5">
                <p>Carinho</p>
            </div>
            <div class="item item6">
                <p>Pet Amigo</p>
            </div>
            <div class="item item7">
                <p>Família</p>
            </div>
            <div class="item item8">
                <p>Amor</p>
            </div>
            <div class="item item9">
                <p>Cuidado</p>
            </div>
            <div class="item item10">
                <p>Carinho</p>
            </div>
        </div>
        <div id="nossos-planos">
            <h1>Nossos Planos!</h1>
            <button class="carousel-button" id="go-back-ne">
                <img src="assets/images/seta direita.svg" alt="">
            </button>
            <div id="planos-container">
                <div class="plano">
                    <h1>MEI Premium</h1>
                    <p>
                        Os planos Premium oferecem benefícios adicionais, como postagens ilimitadas e visualizações potencializadas. Eles são ideais para prestadores de serviço que desejam aumentar significativamente sua presença no mercado e alcançar um público mais amplo de maneira eficiente.
                    </p>
                    <h3>R$ 35,90/mês ou R$ 399,90/ano</h3>
                </div>
                <div class="plano">
                    <h1>Plano Premium Tutor</h1>
                    <p>
                        O Plano Premium do Tutor de Pet garante uma melhor experiência, pois proporciona benefícios adicionais, como remoção de anúncios, controle de saúde e uma agenda mais completa e personalizada!
                    </p>
                    <h3>R$ 10,99/mês ou R$ 119,90/ano</h3>
                </div>
                <div class="plano">
                    <h1>MEI Básico</h1>
                    <p>
                        O Plano MEI Básico oferece um pacote com a flexibilidade de gerenciar o número de postagens, dividindo 1000 visualizações mensais para promover seu produto ou serviço.
                    </p>
                    <h3>R$ 25,90/mês ou R$ 279,90/ano</h3>
                </div>
            </div>
            <button class="carousel-button" id="go-foward-ne">
                <img src="assets/images/seta direita.svg" alt="">
            </button>
            <div id="indicador-plano">
                <div class="ball">
                    <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                </div>
                <div class="ball">
                    <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                </div>
                <div class="ball">
                    <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                </div>
            </div>
        </div>
        <div class="rolagem2">
            <div class="item item1">
                <p>Pet Amigo</p>
            </div>
            <div class="item item2">
                <p>Família</p>
            </div>
            <div class="item item3">
                <p>Amor</p>
            </div>
            <div class="item item4">
                <p>Cuidado</p>
            </div>
            <div class="item item5">
                <p>Carinho</p>
            </div>
            <div class="item item6">
                <p>Pet Amigo</p>
            </div>
            <div class="item item7">
                <p>Família</p>
            </div>
            <div class="item item8">
                <p>Amor</p>
            </div>
            <div class="item item9">
                <p>Cuidado</p>
            </div>
            <div class="item item10">
                <p>Carinho</p>
            </div>
        </div>
    </div>

    <!--Container de Parceiros e Microempresas-->
    <div class="pm-container">
        <div class="parceiros">
            <div class="textos">
                <h1>Parceiros</h1>
                <p>
                    Nossos parceiros são um de nossos pilares!
                    Temos planos que oferecem benefícios, funcionalidades e eventos com a marca do parceiro. Nossas parcerias envolvem Pet Shops, ONG's de animais, e organizações voltadas à saúde do seu pet. Os parceiros oferecem eventos tanto presenciais, com a sua marca, quanto on-line, no nosso app! Ao baixar, você poderá receber convites de eventos gratuitamente com o seu Petilogin!
                </p>
            </div>
            <div class="imagem">
                <img src="assets/images/parceirosDogs.png" alt="">
            </div>
        </div>
        <div class="microempresas" id="microempresas">
            <div class="imagem">
                <img src="assets/images/microempresasDog.png" alt="">
            </div>
            <div class="textos">
                <h1>Microempresas</h1>
                <p>
                    Nossa missão é apoiar e auxiliar toda a comunidade pet, por isso, incentivamos os microempreendedores por meio de nosso app, uma vez que permitimos anúncios de seus produtos e serviços por um preço extremamente em conta! Contamos com planos mensais e anuais para o MEI, e exibimos o seus anúncios no nosso feed inicial.
                    Isso também beneficia o tutor de pet, uma vez que o conteúdo de nossos anuncios estão sempre voltados ao bem estar de seu animal, garantindo assim uma melhor experiência entre tutor e anunciante!
                </p>
            </div>
        </div>
    </div>

    <!--Container de propaganda-->
    <div class="baixe-container">
        <img src="assets/images/background-patas.png" alt="">
        <div class="baixe">
            <div class="mensagem">
                <img src="assets/images/ModolinhoWaterBlue.svg" alt="">
                <h1>Baixe o aplicativo!</h1>
            </div>
            <div class="baixe-playstore">
                <p>
                    Junte-se a nós em uma jornada em busca de um futuro melhor! Baixe o app!
                </p>
                <a href="" target="_blank"> <!--Colocar link do app na playstore-->
                    <img src="assets/images/Google Play.png" alt="">
                </a>
            </div>
        </div>
        <img src="assets/images/background-patas.png" alt="">
    </div>

    <!-- Nossa equipe -->
    <div class="quem-somos-container">
        <div class="quem-somos">
            <h1>Quem somos?</h1>
            <div class="carrossel-container">
                <div class="carrossel-main-container">
                    <button class="carousel-button" id="go-back">
                        <img src="assets/images/arrow.svg" alt="">
                    </button>
                    <div class="carrossel" id="carousel1">
                        <div class="pessoa">
                            <img src="assets/images/bianca.png" alt="">
                            <h2>Bianca</h2>
                            <p>
                                Oi, eu sou a Bianca Machado, faço UX e participo da equipe de desenvolvimento do Peticos!
                            </p>
                            <div class="background-blur"></div>
                        </div>
                        <div class="pessoa">
                            <img src="assets/images/guilherne.png" alt="">
                            <h2>Guilherme</h2>
                            <p>
                                Oi! Eu sou o Guilherme, faço design, análise de dados e ciência de dados no Peticos.
                            </p>
                            <div class="background-blur"></div>
                        </div>
                        <div class="pessoa">
                            <img src="assets/images/gustavo.png" alt="">
                            <h2>Gustavo</h2>
                            <p>
                                Oi, meu nome é Gustavo e eu faço parte da equipe de back-end do projeto.
                            </p>
                            <div class="background-blur"></div>
                        </div>
                        <div class="pessoa">
                            <img src="assets/images/geovanna.png" alt="">
                            <h2>Geovanna</h2>
                            <p>
                                Oi! Eu sou a Geovanna e atuo como desenvolvedora front, back e mobile do Peticos.
                            </p>
                            <div class="background-blur"></div>
                        </div>
                        <div class="pessoa">
                            <img src="assets/images/giovanna.png" alt="">
                            <h2>Giovana</h2>
                            <p>
                                Oie. Eu sou a Giovana e faço a análise de dados, design e marketing do Peticos!
                            </p>
                            <div class="background-blur"></div>
                        </div>
                        <div class="pessoa">
                            <img src="assets/images/hallison.png" alt="">
                            <h2>Hállison</h2>
                            <p>
                                Sou o Hállison, responsável pela parte de banco de dados e gestão de projeto.
                            </p>
                            <div class="background-blur"></div>
                        </div>
                        <div class="pessoa">
                            <img src="assets/images/isaac.png" alt="">
                            <h2>Isaac</h2>
                            <p>
                                Opa, meu nome é Isaac. Eu sou engenheiro de dados e programador front-end e back-end no Peticos.
                            </p>
                            <div class="background-blur"></div>
                        </div>
                        <div class="pessoa">
                            <img src="assets/images/carvalho.png" alt="">
                            <h2>João</h2>
                            <p>
                                Oi, meu nome é João Carvalho e eu faço o front-end e análise de dados.
                            </p>
                            <div class="background-blur"></div>
                        </div>
                        <div class="pessoa">
                            <img src="assets/images/livia.png" alt="">
                            <h2>Lívia</h2>
                            <p>
                                Oi. Eu sou a Lívia, faço a experiência do usuário, o design e o back end do Peticos.
                            </p>
                            <div class="background-blur"></div>
                        </div>
                        <div class="pessoa">
                            <img src="assets/images/mayumi.png" alt="">
                            <h2>Mayumi</h2>
                            <p>
                                Oie! Eu sou a Mayumi, participo do back-end e do design do Peticos.
                            </p>
                            <div class="background-blur"></div>
                        </div>
                        <div class="pessoa">
                            <img src="assets/images/frossard.png" alt="">
                            <h2>Pedro</h2>
                            <p>
                                Oi! Eu sou o Pedro e faço o planejamento de projeto e back-end do Peticos.
                            </p>
                            <div class="background-blur"></div>
                        </div>
                        <div class="pessoa">
                            <img src="assets/images/ruan.png" alt="">
                            <h2>Ruan</h2>
                            <p>
                                Oi, eu me chamo Ruan e sou responsável pelo front-end e pelo design do Peticos!
                            </p>
                            <div class="background-blur"></div>
                        </div>
                        <div class="pessoa">
                            <!-- Pra o carrossel ficar com um número ímpar e poder centralizar -->
                        </div>
                    </div>
                    <button class="carousel-button" id="go-foward">
                        <img src="assets/images/arrow.svg" alt="">
                    </button>
                </div>
                <div id="indicador-pessoa">
                    <div class="ball-pessoa">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                    </div>
                    <div class="ball-pessoa">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                    </div>
                    <div class="ball-pessoa">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                    </div>
                    <div class="ball-pessoa">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                    </div>
                    <div class="ball-pessoa">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                    </div>
                    <div class="ball-pessoa">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                    </div>
                    <div class="ball-pessoa">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                    </div>
                    <div class="ball-pessoa">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                    </div>
                    <div class="ball-pessoa">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                    </div>
                    <div class="ball-pessoa">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                    </div>
                    <div class="ball-pessoa">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                    </div>
                    <div class="ball-pessoa">
                        <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px"><path d="M480-200q-117 0-198.5-81.5T200-480q0-117 81.5-198.5T480-760q117 0 198.5 81.5T760-480q0 117-81.5 198.5T480-200Z"></path></svg>
                    </div>
                </div>
            </div>
            <img src="assets/images/Modolinho.svg" alt="" id="modolinho">
        </div>
    </div>

    <!-- Footer da página -->
    <footer>
        <p>© 2024 Peticos. All rights reserved.</p>
        <img src="assets/images/peticosModolinho.svg" alt="">
        <ul id="entre-contato">
            <li>
                <a href="mailto:bhavatech@outlook.com" >
                    <img src="assets/images/mail.svg" alt="">
                </a>
            </li>
            <li>
                <a href="mailto:bhavatechteam@gmail.com">
                    <img src="assets/images/mail.svg" alt="">
                </a>
            </li>
            <li>
                <a href="https://www.instagram.com/_peticos/" target="_blank">
                    <img src="assets/images/instagram_.svg" alt="" class="ig">
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/login/login.jsp"> <!--Deve levar para a área restrita-->
                    <img src="assets/images/restrictArea.svg" alt="">
                </a>
            </li>
        </ul>
    </footer>
</body>
</html>