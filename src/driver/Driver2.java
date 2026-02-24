import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return; 
        int N = scanner.nextInt();

        int[] nilai = new int[N];
        for (int i = 0; i < N; i++) {
            nilai[i] = scanner.nextInt();
        }

        int kodeKelompok = scanner.nextInt();
        int totalNilai = 0;
        String namaKelompok = (kodeKelompok == 1) ? "Perempuan" : "Laki-laki";

        for (int i = 0; i < N; i++) {
            if (kodeKelompok == 1 && i % 2 == 0) {
                totalNilai += nilai[i];
            } else if (kodeKelompok == 2 && i % 2 != 0) {
                totalNilai += nilai[i];
            }
        }

        System.out.println("Total nilai kelompok " + namaKelompok + " adalah: " + totalNilai);

        scanner.close();
    }
}