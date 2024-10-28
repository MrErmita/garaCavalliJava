package com.mycompany;
import java.util.ArrayList;
import java.util.Scanner;

public class HorseRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la lunghezza del percorso in metri: ");
        int raceDistance = scanner.nextInt();
        
        System.out.print("Inserisci il numero di cavalli in gara: ");
        int numberOfHorses = scanner.nextInt();
        
        ArrayList<Horse> horses = new ArrayList<>();
        
        for (int i = 1; i <= numberOfHorses; i++) {
            System.out.print("Inserisci il nome del cavallo " + i + ": ");
            String horseName = scanner.next();
            Horse horse = new Horse(horseName, raceDistance);
            horses.add(horse);
        }
        
        System.out.println("La gara è iniziata!");
        for (Horse horse : horses) {
            horse.start();
        }
        
        for (Horse horse : horses) {
            try {
                horse.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("La gara è terminata!");
        scanner.close();
    }
}
