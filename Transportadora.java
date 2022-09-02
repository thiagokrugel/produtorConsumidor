package produtorConsumidor;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Transportadora extends Thread {
    char nomeTransportadora;
    private Semaphore espacos, itens2, mutexEntregas;
    FilaEntrega entregas;

    public Semaphore limitadorEntrega;

    public Transportadora(char nomeTransportadora, FilaEntrega entregas, Semaphore espacos, Semaphore itens2, Semaphore mutexEntregas){
        this.nomeTransportadora = nomeTransportadora;
        this.entregas = entregas;
        this.espacos = espacos;
        this.itens2 = itens2;
        this.mutexEntregas = mutexEntregas;

        if (this.nomeTransportadora == 'A') {
            limitadorEntrega = new Semaphore(1);
        } else {
            limitadorEntrega = new Semaphore(4);
        }
    }


    public void run(){
        
        Random random = new Random();
        while(true){
            try {
                Thread.sleep(random.nextInt(5000)); //arrumar intervalo conforme a tabela no .pdf

                itens2.acquire();
                    mutexEntregas.acquire();
                        Entrega newEntrega = entregas.entregas.get(0);
                        entregas.entregas.remove(entregas.entregas.get(0));
                    mutexEntregas.release();

                    new Transporte(this, newEntrega).start();

                    //System.out.println("Saiu da transportadora: " + this.nomeTransportadora);
  
                    System.out.println("Produto: " + newEntrega.venda.nomeProduto + " Pedido: " + newEntrega.venda.loja.contadorVendas +  newEntrega.venda.loja.nomeLoja);
                    
                espacos.release();
                
            }
            catch (Exception e) {
				e.printStackTrace();
			} 
        }
    }
}
