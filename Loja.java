package produtorConsumidor;
import java.util.concurrent.Semaphore;

public class Loja extends Thread {
    char nomeLoja;
    int contadorVendas;
    private Semaphore mutex, itens;
    FilaVenda vendas;


    public Loja(FilaVenda vendas, Semaphore mutex, Semaphore itens){
        this.vendas = vendas;
        this.mutex = mutex;
        this.itens = itens;
    }

    public char sorteiaProduto() {
        String possibilidades = "ABCDEFGH";
        char nomeProduto = possibilidades.charAt(random.nextInt(8));
        return nomeProduto;
    }

    public void run(){

        while(true){
            try {

                Venda venda = new Venda(sorteiaProduto(), this);
                contadorVendas++;
                
                System.out.println("Venda na loja: " + nomeLoja + " Número: " + contadorVendas + " Produto: " + venda.nomeProduto);
                mutex.acquire();
                    vendas.vendas.add(venda);
                mutex.release();
                itens.release();//sinalizar

                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }

}
