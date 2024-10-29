package com.mycompany;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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
            System.out.print("Inserisci la velocità (metri al secondo) di " + horseName + ": ");
            int speed = scanner.nextInt();
            Horse horse = new Horse(horseName, raceDistance, speed);
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

        // Filtra i cavalli che non si sono infortunati
        ArrayList<Horse> finishedHorses = new ArrayList<>();
        for (Horse horse : horses) {
            if (!horse.isInjured()) {
                finishedHorses.add(horse);
            }
        }

        // Ordina i cavalli per distanza percorsa (dal maggiore al minore)
        finishedHorses.sort(Comparator.comparing(Horse::getDistanceCovered).reversed());

        // Visualizza la classifica finale e determina i primi 3
        System.out.println("Classifica finale:");
        for (int i = 0; i < finishedHorses.size(); i++) {
            Horse horse = finishedHorses.get(i);
            System.out.println((i + 1) + ". " + horse.getName() + " con " + horse.getDistanceCovered() + " metri");
        }

        // Primi 3 cavalli
        System.out.println("\nPrimi 3 arrivati:");
        for (int i = 0; i < Math.min(3, finishedHorses.size()); i++) {
            Horse horse = finishedHorses.get(i);
            System.out.println((i + 1) + ". " + horse.getName() + " con " + horse.getDistanceCovered() + " metri");
        }

        // Salvataggio dei risultati
        System.out.print("Inserisci il nome del file per salvare i risultati: ");
        String fileName = scanner.next();

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("Classifica della gara:\n");
            for (int i = 0; i < Math.min(3, finishedHorses.size()); i++) {
                Horse horse = finishedHorses.get(i);
                writer.write((i + 1) + ". " + horse.getName() + " con " + horse.getDistanceCovered() + " metri\n");
            }
            writer.write("----\n");
            System.out.println("Risultati salvati nel file " + fileName);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio del file: " + e.getMessage());
        }

        scanner.close();
    }
}
