package produtorConsumidor;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Transportadora extends Thread {
    char nomeTransportadora;
    private Semaphore espacos, itens2, mutexEntregas;
    FilaEntrega entregas;


    public Transportadora(char nomeTransportadora, FilaEntrega entregas, Semaphore espacos, Semaphore itens2, Semaphore mutexEntregas){
        this.nomeTransportadora = nomeTransportadora;
        this.entregas = entregas;
        this.espacos = espacos;
        this.itens2 = itens2;
        this.mutexEntregas = mutexEntregas;
    }


    public void run(){
        
        Random random = new Random();
        while(true){
            try {
                Thread.sleep(random.nextInt(5000)); //arrumar intervalo conforme a tabela no .pdf

                itens2.acquire();
                    mutexEntregas.acquire();
                        entregas.entregas.remove(entregas.entregas.get(0));
                    mutexEntregas.release();
                    System.out.println("Saiu da transportadora: " + this.nomeTransportadora);
                    //Transporte transporte = new Transporte();    
                espacos.release();
                
            }
            catch (Exception e) {
				e.printStackTrace();
			} 
        }
    }
}
