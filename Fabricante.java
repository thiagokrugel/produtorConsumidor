package produtorConsumidor;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class Fabricante extends Thread{
    char nomeFabricante;
    private Semaphore mutex, itens, espacos;
    FilaVenda vendas;
    //FilaEntrega entregas;


    public Fabricante(FilaVenda vendas, Semaphore mutex, Semaphore itens, Semaphore espacos){
        this.vendas = vendas;
        //this.entregas = entregas;
        this.mutex = mutex;
        this.itens = itens;
        this.espacos = espacos;
    }

    public void run(){
        Random random = new Random();
        while(true){
            try {
                itens.acquire();
                    System.out.println("Antes retirada: " + vendas.vendas.size());
                    vendas.vendas.remove(vendas.vendas.get(0));
                    System.out.println("Depois retirada: " + vendas.vendas.size());
                    //Fabricacao fabricacao = new Fabricacao();
                    Thread.sleep(random.nextInt(1000)); //arrumar intervalo conforme a tabela no .pdf
                    System.out.println("Fabricante retira produto");
                    System.out.println("--------------------------");
                    
                    //Entrega entrega = new Entrega();
                    //entregas.entregas.add(entrega);
                mutex.release();
            }
            catch (InterruptedException e) {
				e.printStackTrace();
			}           
        }
    }
}
