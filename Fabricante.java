package produtorConsumidor;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class Fabricante extends Thread{
    char nomeFabricante;
    private Semaphore mutexVendas, itens, itens2, mutexEntregas;
    private FilaVenda vendas;
    private FilaEntrega entregas;

    public Semaphore limitadorFabricacao;

    public Fabricante(FilaVenda vendas, FilaEntrega entregas, Semaphore mutexVendas, Semaphore itens, Semaphore itens2, Semaphore mutexEntregas){
        this.vendas = vendas;
        this.entregas = entregas;
        this.mutexVendas = mutexVendas;
        this.itens = itens;
        this.itens2 = itens2;
        this.mutexEntregas = mutexEntregas;
        
        // Limitador do fabricante de acordo com o tipo de fabricante
        if (this.nomeFabricante == 'B') {
            limitadorFabricacao = new Semaphore(1);
        } else {
            limitadorFabricacao = new Semaphore(4);
        }

    }

    public void run(){
        Random random = new Random();
        while(true){
            try {
                Thread.sleep(random.nextInt(3000)); //arrumar intervalo conforme a tabela no .pdf
                
                itens.acquire();
                    
                    mutexVendas.acquire();
                        Venda newVenda = vendas.vendas.get(0);
                        vendas.vendas.remove(vendas.vendas.get(0));
                    mutexVendas.release();

                    Thread.sleep(random.nextInt(1000)); //arrumar intervalo conforme a tabela no .pdf

                    this.limitadorFabricacao.acquire();
                        // Tempo de fabricação de acordo com a loja e a venda
                        new Fabricacao(this, newVenda).start();
                        // O realese está sendo aplicado na classe Fabricação; 
                    
                    // Cria entrega
                    Entrega entrega = new Entrega();
                    entrega.numeroEntrega++;
                    entrega.venda = newVenda;
                    
                    mutexEntregas.acquire();
                        entregas.entregas.add(entrega);
                        //System.out.println("Fila de entregas: " + entregas.entregas.size());
                    mutexEntregas.release();

                    Thread.sleep(random.nextInt(1000)); //arrumar intervalo conforme a tabela no .pdf

                    //System.out.println("Fabricante retira produto");
                
                itens2.release();
            }
            catch (InterruptedException e) {
				e.printStackTrace();
			}           
        }
    }
}
