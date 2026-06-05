package com.terbuka;

import com.terbuka.exception.MenuNotFoundException;
import com.terbuka.model.MenuItem;
import com.terbuka.model.DetailPesanan;
import com.terbuka.model.Diskon;
import com.terbuka.model.Makanan;
import com.terbuka.model.Minuman;
import com.terbuka.model.Pesanan;
import com.terbuka.service.Menu;
import com.terbuka.util.FileManager;
import com.terbuka.util.FormatUtil;

import java.io.IOException;
import java.util.Scanner;

/*
    Program Manajamen Restoran

    Implementasi:
    - Abstraction
    - Inheritance
    - Encapsulation
    - Polymorphism
    - File I/O
    - ArrayList
    - Struktur keputusan
    - Struktur pengulangan
*/

public class Main {
    private static final Scanner userInput = new Scanner(System.in);

    private static final Menu menu = new Menu();
    private static final Pesanan pesanan = new Pesanan();
    private static final FileManager fileManager = new FileManager();

    // Method utama program
    public static void main(String[] args) {
        inisialisasiDataAwal();

        int pilihan;

        do {
            tampilkanMenuUtama();

            System.out.print("Pilih Menu : ");
            pilihan = bacaInteger();

            switch (pilihan) {
                case 1 -> tambahMakanan();
                case 2 -> tambahMinuman();
                case 3 -> tambahDiskon();
                case 4 -> menu.tampilkanMenu();
                case 5 -> buatPesanan();
                case 6 -> tampilkanTotalPesanan();
                case 7 -> tampilkanStruk();
                case 8 -> simpanMenu();
                case 9 -> muatMenu();
                case 10 -> simpanStruk();
                case 11 -> muatStruk();
                case 12 -> ubahHargaMenu();
                case 13 -> hapusMenu();
                case 0 -> System.out.println("Program Selesai!");
                default -> System.out.println("Pilihan Tidak Valid!");
            }
        } while (pilihan != 0);
    }

    // Menampilkan menu utama
    private static void tampilkanMenuUtama() {
        System.out.println("\n=============================");
        System.out.println("=RESTORAN PADANG SUBUH MALAM=");
        System.out.println("==== MANAJEMEN RESTORAN =====");
        System.out.println("=============================");
        System.out.println("1. Tambah Makanan");
        System.out.println("2. Tambah Minuman");
        System.out.println("3. Tambah Diskon");
        System.out.println("4. Tampilkan Menu");
        System.out.println("5. Buat Pesanan");
        System.out.println("6. Hitung Total Pesanan");
        System.out.println("7. Tampilkan Struk");
        System.out.println("8. Simpan Menu");
        System.out.println("9. Muat Menu");
        System.out.println("10. Simpan Struk");
        System.out.println("11. Muat Struk");
        System.out.println("12. Ubah Harga Menu");
        System.out.println("13. Hapus Menu");
        System.out.println("0. Keluar");
        System.out.println("=============================");
    }

    // Menambahkan data awal
    private static void inisialisasiDataAwal() {
        menu.tambahMenu(
            new Makanan(
                "Nasi Rendang", 
                25000, 
                "Makanan", 
                "Menu Utama"));

        menu.tambahMenu(new Makanan(
                "Nasi Ayam Bakar", 
                25000, 
                "Makanan", 
                "Menu Utama"));

        menu.tambahMenu(
            new Makanan(
                "Kerupuk",
                5000,
                "Makanan",
                "Menu Tambahan"));

        menu.tambahMenu(
            new Minuman(
                "Es Teh",
                8000,
                "Minuman",
                "Teh"));

        menu.tambahMenu(
            new Minuman(
                "Teh Panas", 
                8000, 
                "Minuman", 
                "Teh"));

        menu.tambahMenu(
            new Minuman(
                "Kopi Hitam",
                10000,
                "Minuman",
                "Kopi"));

        menu.tambahMenu(
            new Diskon(
                "Promo Mahasiswa",
                0,
                "Diskon",
                10));

        menu.tambahMenu(
            new Diskon(
                "Promo Weekend",
                0,
                "Diskon",
                20));
    }

    // Menambah makanan
    private static void tambahMakanan() {
        System.out.print("Nama Makanan : ");
        String nama = userInput.nextLine();

        System.out.print("Harga : ");
        double harga = bacaDouble();

        System.out.print("Jenis Makanan : ");
        String jenis = userInput.nextLine();

        menu.tambahMenu(
            new Makanan(nama, harga, "Makanan", jenis)
        );

        System.out.println("Makanan berhasil ditambahkan!");
    }

    // Menambah minuman
    private static void tambahMinuman() {
        System.out.print("Nama Minuman : ");
        String nama = userInput.nextLine();

        System.out.print("Harga : ");
        double harga = bacaDouble();

        System.out.print("Jenis Minuman : ");
        String jenis = userInput.nextLine();

        menu.tambahMenu(
            new Minuman(nama, harga, "Minuman", jenis)
        );

        System.out.println("Minuman berhasil ditambahkan!");
    }

    // Menambah diskon
    private static void tambahDiskon() {
        System.out.print("Nama Diskon : ");
        String nama = userInput.nextLine();

        System.out.print("Persentase Diskon : ");
        double diskon = bacaDouble();

        menu.tambahMenu(
            new Diskon(nama, 0, "Diskon", diskon)
        );

        System.out.println("Diskon berhasil ditambahkan!");
    }

    // Membuat pesanan pelanggan
    private static void buatPesanan() {
        if (menu.isKosong()) {
            System.out.println("Menu masih kosong.");
            return;
        }

        String lanjut;

        do {
            menu.tampilkanMenu();

            try {
                System.out.print("Nomor Menu : ");
                int nomorMenu = bacaInteger();

                MenuItem item = menu.cariMenu(nomorMenu);

                if (item instanceof Diskon diskon) {
                    if (pesanan.memilikiDiskon()) {
                        System.out.println("Diskon Sudah Dipilih!");
                    } else {
                        pesanan.setDiskonAktif(diskon);
                        System.out.println("Diskon Berhasil Dipilih!");
                    }
                } else {
                    System.out.print("Jumlah : ");
                    int jumlah = bacaInteger();

                    pesanan.tambahPesanan(item, jumlah);

                    System.out.println("Pesanan Berhasil Ditambahkan.");
                }
            } catch (MenuNotFoundException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Tambah pesanan lagi? (Y/T) : ");
            lanjut = userInput.nextLine();
        } while (lanjut.equalsIgnoreCase("Y"));
    }

    // Menampilkan total pesanan
    private static void tampilkanTotalPesanan() {
        double totalAwal = pesanan.hitungTotalSebelumDiskon();

        double nilaiDiskon = pesanan.hitungNilaiDiskon();

        double totalAkhir = pesanan.hitungTotalSetelahDiskon();

        System.out.println("\n===== TOTAL PESANAN =====");
        System.out.println("Total Awal      : " + FormatUtil.formatRupiah(totalAwal));
        System.out.println("Nilai Diskon    : " + FormatUtil.formatRupiah(nilaiDiskon));
        System.out.println("Total Akhir     : " + FormatUtil.formatRupiah(totalAkhir));
    }

    // Menampilkan struk
    private static void tampilkanStruk() {
        System.out.println(generateStruk());
    }

    // Membuat isi struk
    private static String generateStruk() {
        StringBuilder struk = new StringBuilder();

        struk.append("\n===== STRUK PESANAN =====\n");

        for (DetailPesanan detail : pesanan.getDaftarPesanan()) {
            struk.append(detail.getItem().getNama()).append(" x ").append(detail.getJumlah()).append(" = ").append(FormatUtil.formatRupiah(detail.getSubtotal())).append("\n");
        }

        struk.append("\n");

        if (pesanan.memilikiDiskon()) {
            struk.append("Diskon : ").append(pesanan.getDiskonAktif().getNama()).append("\n");
        }

        struk.append("Total Sebelum Diskon : ").append(FormatUtil.formatRupiah(pesanan.hitungTotalSebelumDiskon())).append("\n");

        struk.append("Nilai Diskon : ").append(FormatUtil.formatRupiah(pesanan.hitungNilaiDiskon())).append("\n");

        struk.append("Total Bayar : ").append(FormatUtil.formatRupiah(pesanan.hitungTotalSetelahDiskon())).append("\n");

        return struk.toString();
    }

    // Menyimpan menu
    private static void simpanMenu() {
        try {
            fileManager.simpanMenu(
                menu.getDaftarMenu(),
                "menu.txt");
            
            System.out.println("Menu Berhasil Disimpan.");
        } catch (IOException e) {
            System.out.println("Gagal Menyimpan Menu.");
        }
    }

    // memuat menu
    private static void muatMenu() {
        try {
            menu.getDaftarMenu().clear();

            menu.getDaftarMenu().addAll(fileManager.muatMenu("menu.txt"));

            System.out.println("Menu Berhasil Dimuat.");
        } catch (IOException e) {
            System.out.println("Gagal Memuat Menu!");
        }
    }

    // Menyimpan struk
    private static void simpanStruk() {
        try {
            fileManager.simpanStruk(generateStruk(), "struk.txt");

            System.out.println("Struk Berhasil Disimpan.");
        } catch (IOException e) {
            System.out.println("Gagal Menyimpan Struk.");
        }
    }

    // Memuat struk
    private static void muatStruk() {
        try {
            System.out.println(fileManager.muatStruk("struk.txt"));
        } catch (IOException e) {
            System.out.println("Gagal Memuat Struk!");
        }
    }

    // Mengubah harga menu
    private static void ubahHargaMenu() {
        try {
            menu.tampilkanMenu();

            System.out.print("Nomor Menu : ");
            int nomor = bacaInteger();

            System.out.print("Harga Baru : ");
            double hargaBaru = bacaDouble();

            menu.ubahHargaMenu(nomor, hargaBaru);

            System.out.println("Harga Berhasil Diubah!");
        } catch (MenuNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Menghapus menu
    private static void hapusMenu() {
        try {
            menu.tampilkanMenu();
            
            System.out.print("Nomor Menu : ");
            int nomor = bacaInteger();

            System.out.print("Yakin Hapus? (Ya/Tidak) : ");
            String konfirmasi = userInput.nextLine();

            if (konfirmasi.equalsIgnoreCase("Ya")) {
                menu.hapusMenu(nomor);

                System.out.println("Menu Berhasil Dihapus!");
            } else {
                System.out.println("Penghapusan Dibatalkan.");
            }
        } catch (MenuNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Membaca integer dengan validasi
    private static int bacaInteger() {
        while (true) {
            try {
                int nilai = Integer.parseInt(userInput.nextLine());
                return nilai;
            } catch (NumberFormatException e) {
                System.out.print("Masukkan Angka : ");
            }
        }
    }

    // Membaca double dengan validasi
    private static double bacaDouble() {
        while (true) {
            try {
                double nilai = Double.parseDouble(userInput.nextLine());
                return nilai;
            } catch (NumberFormatException e) {
                System.out.print("Masukkan Angka : ");
            }
        }
    }
}
