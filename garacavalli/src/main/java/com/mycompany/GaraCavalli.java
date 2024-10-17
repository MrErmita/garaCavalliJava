package com.mycompany;

import java.util.Scanner;

public class GaraCavalli {
    public static void main(String[] args) {
        // input dei dati del cavallo
        System.out.println("Inserisci il nome del cavallo");

        Scanner name = new Scanner(System.in); // Create a Scanner object
        System.out.println("Inserisci il nome del cavallo: ");

        String userName = name.nextLine(); // Read user input
        System.out.println("nome cavallo: " + userName); // Output user input
    }
}