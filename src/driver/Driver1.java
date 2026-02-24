import java.util.ArrayList;
import java.util.Scanner;

class Pesanan {
    String namaMenu;
    int porsi;
    int harga;
    int total;

    public Pesanan(String namaMenu, int porsi, int harga, int total) {
        this.namaMenu = namaMenu;
        this.porsi = porsi;
        this.harga = harga;
        this.total = total;
    }
}

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pesanan> daftarPesanan = new ArrayList<>();
        int totalPembayaran = 0;

        // Membaca input terus menerus sampai menemukan "END"
        while (scanner.hasNextLine()) {
            String kode = scanner.nextLine().trim();
            if (kode.equalsIgnoreCase("END")) {
                break;
            }

            // Membaca porsi butet
            int porsiButet = Integer.parseInt(scanner.nextLine().trim());
            
            // Logika porsi: Berat Ucok 100kg, Butet 50kg (Perbandingan 2:1)
            // Jadi Ucok makan 2x lipat porsi Butet. Total porsi = Butet (1) + Ucok (2) = 3x porsi Butet
            int totalPorsi = porsiButet * 3; 

            String namaMenu = "";
            int harga = 0;

            // Pemetaan kode menu ke nama makanan dan harga sesuai pamflet
            switch (kode.toUpperCase()) {
                case "NGS": namaMenu = "Nasi Goreng Spesial"; harga = 15000; break;
                case "AP": namaMenu = "Ayam Penyet"; harga = 20000; break;
                case "SA": namaMenu = "Sate Ayam (10 Tusuk)"; harga = 25000; break;
                case "BU": namaMenu = "Bakso Urat"; harga = 18000; break;
                case "MAP": namaMenu = "Mie Ayam Pangsit"; harga = 15000; break;
                case "GG": namaMenu = "Gado-Gado"; harga = 15000; break;
                case "SAM": namaMenu = "Soto Ayam"; harga = 17000; break;
                case "RD": namaMenu = "Rendang Daging"; harga = 25000; break;
                case "IB": namaMenu = "Ikan Bakar"; harga = 35000; break;
                case "NUK": namaMenu = "Nasi Uduk Komplit"; harga = 20000; break;
                default: 
                    // Jika kode tidak dikenali, lewati iterasi ini
                    continue; 
            }

            int totalHarga = totalPorsi * harga;
            totalPembayaran += totalHarga;
            
            // Simpan pesanan ke dalam list
            daftarPesanan.add(new Pesanan(namaMenu, totalPorsi, harga, totalHarga));
        }

        // Mencetak Struk Output dengan format yang sesuai gambar
        System.out.printf("%-22s %-8s %-12s %s\n", "Menu", "Porsi", "Harga", "Total");
        System.out.println("=========================================================");
        
        for (Pesanan p : daftarPesanan) {
            System.out.printf("%-22s %-8d %-12d %d\n", p.namaMenu, p.porsi, p.harga, p.total);
        }
        
        System.out.println("=========================================================");
        System.out.printf("%-44s %d\n", "Total Pembayaran", totalPembayaran);
        
        scanner.close();
    }
}