package com.mycompany;
import java.util.Random;

public class Horse extends Thread {
    private String name;
    private int distanceToRun;
    private int speed;
    private int distanceCovered = 0;
    private boolean injured = false;

    public Horse(String name, int distanceToRun, int speed) {
        this.name = name;
        this.distanceToRun = distanceToRun;
        this.speed = speed;
    }

    public String getHorseName() {
        return name;
    }

    public int getDistanceCovered() {
        return distanceCovered;
    }

    public boolean isInjured() {
        return injured;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (distanceCovered < distanceToRun && !injured) {
            int chanceOfInjury = random.nextInt(100);
            if (chanceOfInjury < 1) {
                injured = true;
                System.out.println(name + " si è infortunato e ha lasciato la gara!");
                break;
            }

            distanceCovered += speed;
            if (distanceCovered > distanceToRun) {
                distanceCovered = distanceToRun;
            }

            System.out.println(name + " ha percorso " + distanceCovered + " metri.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!injured) {
            System.out.println(name + " ha terminato la corsa!");
        }
    }
}
