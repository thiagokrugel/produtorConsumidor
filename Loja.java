import java.util.concurrent.Semaphore;

public class Loja extends Thread {
    char nomeLoja;
    int contadorVendas;
    private Semaphore mutex, itens, espacos;
    FilaVenda vendas;


    public Loja(FilaVenda vendas, Semaphore mutex, Semaphore itens, Semaphore espacos){
        this.vendas = vendas;
        this.mutex = mutex;
        this.itens = itens;
        this.espacos = espacos;
    }

    public void run(){

        while(true){
            Venda venda = new Venda();
            vendas.vendas.add(venda);
            contadorVendas++;
        }
    }

}
