
fun main() {
    val nomeProduto = "Notebook Acer"
    val precoUnitario = 3500.0
    val quantidadeComprada = 10
    val taxaImposto = 0.1 // 10%
    val margemLucro = 0.2 // 20%

    val valorTotalSemImpostos = precoUnitario * quantidadeComprada
    val valorImposto = valorTotalSemImpostos * taxaImposto
    val valorTotalComImpostos = valorTotalSemImpostos + valorImposto
    val precoVenda = valorTotalComImpostos * (1 + margemLucro)

    println("Nome do Produto: $nomeProduto")
    println("Preço Unitário: R$ $precoUnitario")
    println("Quantidade Comprada: $quantidadeComprada")
    println("Valor Total Sem Impostos: R$ ${round(valorTotalSemImpostos * 100) / 100}")
    println("Valor do Imposto: R$ ${round(valorImposto * 100) / 100}")
    println("Valor Total Com Impostos: R$ ${round(valorTotalComImpostos * 100) / 100}")
    println("Preço de Venda: R$ ${round(precoVenda * 100) / 100}")
}
