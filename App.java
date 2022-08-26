package produtorConsumidor;
import java.util.concurrent.Semaphore;

public class App {
    //Pendencias
    //Começar a entrega 3,
    //Organizar os sleep,
    //Ajeitar as classes
    
    public static void main(String args[]){
        FilaVenda vendas = new FilaVenda();
        FilaEntrega entregas = new FilaEntrega();

        Semaphore mutexVendas = new Semaphore( 1 );
        Semaphore mutexEntregas = new Semaphore( 1 );
		Semaphore itens = new Semaphore( 0 );
		Semaphore itens2 = new Semaphore( 0 );
		Semaphore espacos = new Semaphore( 100 );
        

        Loja LojaA = new Loja(vendas, mutexVendas, itens);
        LojaA.nomeLoja = 'A';
        Fabricante FabrA = new Fabricante(vendas, entregas, mutexVendas, itens, itens2, mutexEntregas);
        Transportadora TransA = new Transportadora('A', entregas, espacos, itens2, mutexEntregas);
        //Loja LojaB = new Loja(vendas, mutexVendas, itens, espacos);
        //Loja LojaC = new Loja(vendas, mutexVendas, itens, espacos);
        //Loja LojaD = new Loja(vendas, mutexVendas, itens, espacos);
        //Loja LojaE = new Loja(vendas, mutexVendas, itens, espacos);
        //Loja LojaF = new Loja(vendas, mutexVendas, itens, espacos);
        //Loja LojaG = new Loja(vendas, mutexVendas, itens, espacos);
        //Loja LojaH = new Loja(vendas, mutexVendas, itens, espacos);

        
        //Fabricante FabrB = new Fabricante(vendas, entregas, mutexVendas, itens, espacos);
        //Fabricante FabrC = new Fabricante(vendas, entregas, mutexVendas, itens, espacos);
        //Fabricante FabrD = new Fabricante(vendas, entregas, mutexVendas, itens, espacos);

        //Transportadora TransA = new Transportadora(entregas, mutexVendas, itens, espacos);
        //Transportadora TransB = new Transportadora(entregas, mutexVendas, itens, espacos);

        LojaA.start();
        FabrA.start();
        TransA.start();
        try {
            LojaA.join();
            FabrA.join();
            TransA.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
