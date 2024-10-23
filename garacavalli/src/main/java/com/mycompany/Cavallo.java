import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Cavallo extends Thread {
    private String nome;
    private int distanzaTotale;
    private int distanzaPercorsa = 0;
    private CountDownLatch startLatch;
    private static final int PASSO = 10;

    public Cavallo(String nome, int distanzaTotale, CountDownLatch startLatch) {
        this.nome = nome;
        this.distanzaTotale = distanzaTotale;
        this.startLatch = startLatch;
    }

    @Override
    public void run() {
        try {
            startLatch.await();

            while (distanzaPercorsa < distanzaTotale) {
                distanzaPercorsa += PASSO;
                if (distanzaPercorsa > distanzaTotale) {
                    distanzaPercorsa = distanzaTotale;
                }
                System.out.println(nome + " ha percorso " + distanzaPercorsa + " metri.");
                Thread.sleep(500);
            }
            System.out.println(nome + " ha terminato la gara!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}