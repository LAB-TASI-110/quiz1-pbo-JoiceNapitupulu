import java.util.ArrayList;
import java.util.Scanner;

class Order {
    private static int counter = 1;
    private String id;
    private String namaPelanggan;
    private String asrama;
    private double berat;
    private String hariMasuk;
    private String estimasiSelesai;
    private double totalHarga;

    public Order(String namaPelanggan, String asrama, double berat) {
        this.id = "DEL-" + (counter++);
        this.namaPelanggan = namaPelanggan;
        this.asrama = asrama;
        this.berat = berat;
        tentukanJadwal();
        this.totalHarga = berat * 7000; 
    }

    private void tentukanJadwal() {
        switch (asrama.toLowerCase()) {
            case "simon laplace": this.hariMasuk = "Senin"; this.estimasiSelesai = "Selasa Sore"; break;
            case "ada lovelace": this.hariMasuk = "Selasa"; this.estimasiSelesai = "Rabu Sore"; break;
            case "max planck": this.hariMasuk = "Rabu"; this.estimasiSelesai = "Kamis Sore"; break;
            case "rusun 4": this.hariMasuk = "Kamis"; this.estimasiSelesai = "Jumat Sore"; break;
            case "asrama jati":
            case "peniel": this.hariMasuk = "Jumat"; this.estimasiSelesai = "Sabtu Sore"; break;
            case "rusun 3": this.hariMasuk = "Sabtu"; this.estimasiSelesai = "Minggu Sore"; break;
            default: this.hariMasuk = "Tidak Valid"; this.estimasiSelesai = "Menunggu Konfirmasi"; break;
        }
    }

    public String getHariMasuk() { return hariMasuk; }
    public double getTotalHarga() { return totalHarga; }

    @Override
    public String toString() {
        return String.format("| %-6s | %-10s | %-14s | %-12s | Rp%-8.0f |",
                id, namaPelanggan, asrama, estimasiSelesai, totalHarga);
    }
}

public class Driver3 {
    private static ArrayList<Order> historyPesanan = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== SISTEM LAUNDRY DEL ===");
            System.out.println("1. Input Pesanan Baru");
            System.out.println("2. Lihat Riwayat (History) & Pendapatan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            if (pilihan == 1) {
                tambahPesanan();
            } else if (pilihan == 2) {
                tampilkanHistory();
            } else if (pilihan == 3) {
                running = false;
                System.out.println("Program selesai. Semangat kuliahnya di IT Del, Joice!");
            }
        }
    }

    private static void tambahPesanan() {
        System.out.println("\n--- Form Input Pesanan ---");
        System.out.print("Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Nama Asrama: ");
        String asrama = scanner.nextLine();
        System.out.print("Berat (kg): ");
        double berat = scanner.nextDouble();

        Order baru = new Order(nama, asrama, berat);
        if (baru.getHariMasuk().equals("Tidak Valid")) {
            System.out.println("Error: Asrama tidak ditemukan!");
        } else {
            historyPesanan.add(baru);
            System.out.println("Berhasil disimpan ke History!");
        }
    }

    private static void tampilkanHistory() {
        if (historyPesanan.isEmpty()) {
            System.out.println("\nBelum ada riwayat transaksi.");
            return;
        }
        
        double grandTotal = 0;
        System.out.println("\n======================= RIWAYAT LAUNDRY DEL =======================");
        System.out.println("| ID     | Nama       | Asrama         | Jadwal Ready | Harga     |");
        System.out.println("-------------------------------------------------------------------");
        
        for (Order o : historyPesanan) {
            System.out.println(o.toString());
            grandTotal += o.getTotalHarga();
        }
        
        System.out.println("-------------------------------------------------------------------");
        System.out.printf(" TOTAL PENDAPATAN SAAT INI: Rp%.0f\n", grandTotal);
        System.out.println("===================================================================");
    }
}