package produtorConsumidor;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Transportadora extends Thread {
    char nomeTransportadora;
    private Semaphore mutex, itens, espacos;
    FilaEntrega entregas;


    public Transportadora(FilaEntrega entregas, Semaphore mutex, Semaphore itens, Semaphore espacos){
        this.entregas = entregas;
        this.mutex = mutex;
        this.itens = itens;
        this.espacos = espacos;
    }


    public void run(){
        
        Random random = new Random();
        while(true){
            try {
            entregas.entregas.remove(entregas.entregas.get(0));
            Transporte transporte = new Transporte();
            Thread.sleep(random.nextInt(1000)); //arrumar intervalo conforme a tabela no .pdf
            }
            catch (InterruptedException e) {
				e.printStackTrace();
			} 
        }
    }
}
