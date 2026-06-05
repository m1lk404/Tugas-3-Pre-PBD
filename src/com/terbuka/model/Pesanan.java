package com.terbuka.model;

import java.util.ArrayList;

/*
    Class untuk mengelola pesanan dari user

    Fitur:
    - Menambah pesanan
    - Menggabungkan item yang sama
    - Menyimpan satu diskon aktif
    - Menghitung total pesanan
    - Menghitung nilai diskon

    Konsep yang digunakan:
    - ArrayList
    - Encapsulation
    - Object Composition
*/

public class Pesanan {

    // Daftar item yang dipesan user.
    private ArrayList<DetailPesanan> daftarPesanan;

    // Mengecek diskon yang dipilih user (Maksimal satu diskon aktif).
    private Diskon diskonAktif;

    // Constructor
    public Pesanan() {
        daftarPesanan = new ArrayList<>();
    }

    // Menambahkan item ke pesanan
    public void tambahPesanan(MenuItem item, int jumlah) {
        for (DetailPesanan detail : daftarPesanan) {
            if (detail.getItem().getNama().equalsIgnoreCase(item.getNama())) {
                detail.tambahJumlah(jumlah);
                return;
            }
        }

        daftarPesanan.add(new DetailPesanan(item, jumlah));
    }

    // Mengambil daftar pesanan
    public ArrayList<DetailPesanan> getDaftarPesanan() {
        return daftarPesanan;
    }

    // Mengambil diskon yang aktif
    public Diskon getDiskonAktif() {
        return diskonAktif;
    }

    // Menetapkan diskon aktif
    public void setDiskonAktif(Diskon diskon) {
        this.diskonAktif = diskon;
    }

    // Mengecek apakah pesanan memiliki diskon aktif
    public boolean memilikiDiskon() {
        return diskonAktif != null;
    }

    // Menghitung total pesanan sebelum diskon
    public double hitungTotalSebelumDiskon() {
        double total = 0;

        for (DetailPesanan detail : daftarPesanan) {
            total += detail.getSubtotal();
        }
        return total;
    }

    // Menghitung nilai potongan diskon
    public double hitungNilaiDiskon() {
        if (diskonAktif == null) {
            return 0;
        }

        return hitungTotalSebelumDiskon() * (diskonAktif.getDiskon() / 100);
    }

    // Nenghitung total setelah diskon
    public double hitungTotalSetelahDiskon() {
        return hitungTotalSebelumDiskon() - hitungNilaiDiskon();
    }

    // Menghapus seluruh data pesanan
    public void kosongkanPesanan() {
        daftarPesanan.clear();
        diskonAktif = null;
    }
}
