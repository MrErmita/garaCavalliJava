public class GaraCavalli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci la lunghezza del percorso in metri: ");
        int distanzaTotale = scanner.nextInt();
        System.out.print("Inserisci il numero di cavalli: ");
        int numeroCavalli = scanner.nextInt();
        scanner.nextLine();

        List<Cavallo> cavalli = new ArrayList<>();
        CountDownLatch startLatch = new CountDownLatch(1);

        for (int i = 0; i < numeroCavalli; i++) {
            System.out.print("Inserisci il nome del cavallo " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            Cavallo cavallo = new Cavallo(nome, distanzaTotale, startLatch);
            cavalli.add(cavallo);
        }

        for (Cavallo cavallo : cavalli) {
            cavallo.start();
        }

        System.out.println("Tutti i cavalli sono pronti... VIA!");
        startLatch.countDown();

        for (Cavallo cavallo : cavalli) {
            try {
                cavallo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("La gara è terminata!");
    }
}
