package com.mycompany;
public class Horse extends Thread {
    private String name;
    private int distanceToRun;
    private int distanceCovered = 0;

    public Horse(String name, int distanceToRun) {
        this.name = name;
        this.distanceToRun = distanceToRun;
    }

    @Override
    public void run() {
        while (distanceCovered < distanceToRun) {
            int step = (int) (Math.random() * 10) + 1;
            distanceCovered += step;
            if (distanceCovered > distanceToRun) {
                distanceCovered = distanceToRun;
            }
            System.out.println(name + " ha percorso " + distanceCovered + " metri.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " ha terminato la corsa!");
    }
}
