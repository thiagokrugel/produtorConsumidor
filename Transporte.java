package produtorConsumidor;

import java.util.Random;

public class Transporte extends Thread{
    Transportadora transportadora;
    Entrega entrega;

    public Transporte(Transportadora transportadora, Entrega entrega) {
        this.transportadora = transportadora;
        this.entrega = entrega;
    }

    public void efetuarEntrega( Transportadora transportadora) {
        Random random = new Random();

        try {
            switch (this.transportadora.nomeTransportadora) {
                case 'A' : sleep(random.nextInt(101) + 100); break;
                case 'B' : sleep(random.nextInt(201) + 400); break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        this.efetuarEntrega(this.transportadora);
        this.transportadora.limitadorEntrega.release();
        
    }
}
