package produtorConsumidor;

import java.util.Random;

public class Fabricacao extends Thread {
    Fabricante fabricante;
    Venda venda;

    public Fabricacao(Fabricante fabricante, Venda venda) {
        this.fabricante = fabricante;
        this.venda = venda;
    }

    public void produzirMovel(Venda venda){

        Random random = new Random();
        try {
            switch (this.fabricante.nomeFabricante) {
                case 'A':
                    switch (this.venda.nomeProduto) {
                        case 'A' : sleep(random.nextInt(401) + 600);break;
                        case 'B' : sleep(random.nextInt(201) + 200);break;
                        case 'C' : sleep(random.nextInt(201) + 1000);break;
                        case 'D' : sleep(random.nextInt(201) + 400);break;
                        case 'E' : sleep(random.nextInt(201) + 800);break;
                        case 'F' : sleep(random.nextInt(201) + 1400);break;
                        case 'G' : sleep(random.nextInt(201) + 400);break;
                        case 'H' : sleep(random.nextInt(201) + 800);break;
                    }
                    break;
                case 'B':
                    switch (this.venda.nomeProduto) {
                        case 'A' : sleep(random.nextInt(201) + 400);break;
                        case 'B' : sleep(random.nextInt(201) + 1200);break;
                        case 'C' : sleep(random.nextInt(201) + 1000);break;
                        case 'D' : sleep(random.nextInt(201) + 800);break;
                        case 'E' : sleep(random.nextInt(201) + 200);break;
                        case 'F' : sleep(random.nextInt(201) + 1000);break;
                        case 'G' : sleep(random.nextInt(201) + 1000);break;
                        case 'H' : sleep(random.nextInt(201) + 600);break;
                    }
                    break;
                case 'C':
                    switch (this.venda.nomeProduto) {
                        case 'A' : sleep(random.nextInt(201) + 1000);break;
                        case 'B' : sleep(random.nextInt(201) + 1000);break;
                        case 'C' : sleep(random.nextInt(201) + 400);break;
                        case 'D' : sleep(random.nextInt(201) + 600);break;
                        case 'E' : sleep(random.nextInt(201) + 400);break;
                        case 'F' : sleep(random.nextInt(201) + 400);break;
                        case 'G' : sleep(random.nextInt(201) + 1000);break;
                        case 'H' : sleep(random.nextInt(201) + 400);break;
                    }
                    break;
                case 'D':
                    switch (this.venda.nomeProduto) {
                        case 'A' : sleep(random.nextInt(201) + 800);break;
                        case 'B' : sleep(random.nextInt(201) + 600);break;
                        case 'C' : sleep(random.nextInt(201) + 400);break;
                        case 'D' : sleep(random.nextInt(201) + 1000);break;
                        case 'E' : sleep(random.nextInt(201) + 1200);break;
                        case 'F' : sleep(random.nextInt(201) + 800);break;
                        case 'G' : sleep(random.nextInt(201) + 600);break;
                        case 'H' : sleep(random.nextInt(201) + 1200);break;
                    }
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.produzirMovel(this.venda);
        this.fabricante.limitadorFabricacao.release();
    }
}
