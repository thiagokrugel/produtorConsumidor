package produtorConsumidor;
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
            try {

                mutex.acquire();//esperar
                    Venda venda = new Venda('A', this);
                    contadorVendas++;

                    System.out.println("Venda na loja: " + nomeLoja + " Número: " + contadorVendas + " Produto: " + venda.nomeProduto);

                    vendas.vendas.add(venda);
                    System.out.println(vendas.vendas.get(0).nomeProduto);
                    Thread.sleep(1000);
                    
                itens.release();//sinalizar

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }

}
