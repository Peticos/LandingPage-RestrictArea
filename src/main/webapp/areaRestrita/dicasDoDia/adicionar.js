$('#form-adicionar').on("submit", function (e) {
   let link = $('#link');
   let teste = link.val(); // Use .val() para pegar o valor com jQuery

   // Desabilita todos os formulários na página
   $('form').find('input, button, textarea').attr('disabled', true);

   // Defina sua regex aqui
   let regex = /https?:\/\/.+/;

   // Use regex.test() para validar a string
   if (!regex.test(teste)) {
      e.preventDefault();  // Previne o envio do formulário

      let mensagem = "Link inválido!";
      console.log(mensagem);

      // Limpa o campo, adiciona mensagem de erro e a classe de inválido
      link.val("");
      link.attr("placeholder", mensagem);
      link.addClass("invalido");

      // Reabilita todos os formulários se a validação falhar
      $('form').find('input, button, textarea').removeAttr('disabled');
   }
});

// Delegando o evento "focus" para inputs com a classe "invalido"
$(document).on("focus", ".invalido", function () {
   $(this).attr("placeholder", "");  // Remove o placeholder
   $(this).removeClass("invalido");  // Remove a classe "invalido"
});
