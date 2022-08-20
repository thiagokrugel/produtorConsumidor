import java.util.concurrent.Semaphore;
import java.util.Random;

public class Fabricante extends Thread{
    char nomeFabricante;
    private Semaphore mutex, itens, espacos;
    FilaVenda vendas;
    FilaEntrega entregas;


    public Fabricante(FilaVenda vendas, FilaEntrega entregas, Semaphore mutex, Semaphore itens, Semaphore espacos){
        this.vendas = vendas;
        this.entregas = entregas;
        this.mutex = mutex;
        this.itens = itens;
        this.espacos = espacos;
    }

    public void run(){
        Random random = new Random();
        while(true){
            try {
                vendas.vendas.remove(vendas.vendas.get(0));
                Fabricacao fabricacao = new Fabricacao();
                Thread.sleep(random.nextInt(1000)); //arrumar intervalo conforme a tabela no .pdf
                Entrega entrega = new Entrega();
                entregas.entregas.add(entrega); 
            }
            catch (InterruptedException e) {
				e.printStackTrace();
			}           
        }
    }
}
