package produtorConsumidor;
import java.util.concurrent.Semaphore;

public class App {

    
    public static void main(String args[]){
        FilaVenda vendas = new FilaVenda();
        //FilaEntrega entregas = new FilaEntrega();

        Semaphore mutex = new Semaphore( 1 );
		Semaphore itens = new Semaphore( 0 );
		Semaphore espacos = new Semaphore( 100 );
        

        Loja LojaA = new Loja(vendas, mutex, itens, espacos);
        LojaA.nomeLoja = 'A';
        Fabricante FabrA = new Fabricante(vendas, mutex, itens, espacos);

        //Loja LojaB = new Loja(vendas, mutex, itens, espacos);
        //Loja LojaC = new Loja(vendas, mutex, itens, espacos);
        //Loja LojaD = new Loja(vendas, mutex, itens, espacos);
        //Loja LojaE = new Loja(vendas, mutex, itens, espacos);
        //Loja LojaF = new Loja(vendas, mutex, itens, espacos);
        //Loja LojaG = new Loja(vendas, mutex, itens, espacos);
        //Loja LojaH = new Loja(vendas, mutex, itens, espacos);

        
        //Fabricante FabrB = new Fabricante(vendas, entregas, mutex, itens, espacos);
        //Fabricante FabrC = new Fabricante(vendas, entregas, mutex, itens, espacos);
        //Fabricante FabrD = new Fabricante(vendas, entregas, mutex, itens, espacos);

        //Transportadora TransA = new Transportadora(entregas, mutex, itens, espacos);
        //Transportadora TransB = new Transportadora(entregas, mutex, itens, espacos);

        LojaA.start();
        FabrA.start();
        try {
            LojaA.join();
            FabrA.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
