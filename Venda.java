package produtorConsumidor;

public class Venda {
    Loja loja;
    char nomeProduto;

    public Venda(char nomeProduto, Loja loja) {
        this.nomeProduto = nomeProduto;
        this.loja = loja;
    }
}
