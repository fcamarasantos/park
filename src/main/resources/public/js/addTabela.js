// Caso usemos o storage essa variavel não existirá mais.
var qtdProdutos = 0;

$(document).ready(function () {

  // $('.money').mask('000.000.000.000.000,00', { reverse: true });
  $("#add-produto").bind("click", gerarTabela);

});

function clear() {
  $(".clear").val("");
}


function valorTotal(qtd, preco) {
  var t = parseFloat($('#valor-total').text());
  var v = (vt + qtd * preco);
  $('#valor-total').text(v);
};

function gerarTabela() {
  qtdProdutos++;
  var qtdProduto = $('#qtd-produto').val();
  var precoU = parseFloat($('#preco-unitario-produto').val()).toFixed(2);

  conteudo = "<tr class='row' id='" + qtdProdutos + "'>" +
    "<td class='d-none d-md-table-cell col-2'>#"+qtdProduto+"</td>" +
    "<td class='col-4 small-sm'>" + $('#nome-produto').val() + "</th>" +
    "<td class='col-2 text-center'>" + qtdProduto + "</th>" +
    "<td class='col-4 col-md-3 small-sm'>R$ " + precoU + "</th>" +
    "<td class='col-1 text-center'><button value='" + qtdProdutos + "' class='btn btn-outline-danger btn-sm circle btnExcluir'><i class='fas fa-trash'></i></button></th>" +
    "</tr>";

  $('#tBody').append(conteudo);
  $('.btnExcluir').click(function () {
    id = $(this).val()
    $('tr').each(function () {
      if ($(this).attr('id') == id) {
        $(this).remove();
      }  
    })
  })
  valorTotal(qtdProduto, precoU);
  clear();
}



