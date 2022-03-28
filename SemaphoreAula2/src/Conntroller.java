import java.util.concurrent.Semaphore;

public class Conntroller extends Thread {

    private Semaphore semaforonorte;
    private Semaphore semaforosul;
    private int idAviao;

    public Conntroller(int idAvião, Semaphore semaforonorte, Semaphore semaforosul) {
        this.semaforonorte = semaforonorte;
        this.semaforosul = semaforosul;
        this.idAviao = idAvião;
    }

    public void run() {
        decolagem();
    }

    private void decolagem() {
        int manobra = (int) (Math.random() * 2700) + 3000;
        int taxiar = (int) (Math.random() * 2) + 4999;
        int decolagem = (int) (Math.random() * 5) + 1000;
        int afastamento = (int) (Math.random() * 3) + 3000;

        int pista = (int) (Math.random() * 1.5) + 1;

        switch (pista) {

            case 1:
                try {
                    semaforonorte.acquire();
                    System.out.println("Avião ID# " + idAviao + " está circulando na pista Norte");
                    System.out.println("Irá fazer a manobra agora");
                    System.out.println("Manobra realizada");
                    System.out.println("Começando a fase de taxiamento");
                    sleep(taxiar);
                    System.out.println("Taxiamento realizado");
                    System.out.println("Preparando para a decolagem ");
                    sleep(decolagem);
                    System.out.println("Decolagem realizada");
                    System.out.println("Aguarde o afastamento para outro avião entrar na pista");
                    sleep(afastamento);
                    System.out.println("Afastamento realizado. Pista liberada");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaforonorte.release();
                }
            case 2:
                try {
                    semaforosul.acquire();
                    System.out.println("Avião ID# " + idAviao + " está circulando na pista sul");
                    System.out.println("Irá fazer a manobra agora");
                    sleep(manobra);
                    System.out.println("Manobra realizada");
                    System.out.println("Começando a fase de taxiamento");
                    sleep(taxiar);
                    System.out.println("Taxiamento realizado");
                    System.out.println("Preparando para a decolagem ");
                    sleep(decolagem);
                    System.out.println("Decolagem realizada");
                    System.out.println("Aguarde o afastamento para outro avião entrar na pista");
                    sleep(afastamento);
                    System.out.println("Afastamento realizado. Pista liberada");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaforosul.release();
                }
        }

    }
}