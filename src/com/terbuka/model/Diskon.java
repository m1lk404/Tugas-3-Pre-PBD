package com.terbuka.model;

// Mengimport fungsi dari FormatUtil

import com.terbuka.util.FormatUtil;

/*
    Class Diskon merupakan turunan dari MenuItem.

    Class ini digunakan untuk merepresentasikan promo atau diskon yang dapat dipilih pelanggan.

    Contoh yang digunakan secara default:
    - Promo Mahasiswa 10%
    - Promo Weekend 20%

    Konsep yang digunakan:
    - Inheritance
    - Polymorphism
*/

public class Diskon extends MenuItem {
    
    // Persentase diskon
    
    private double diskon;

    // Constructor

    public Diskon(String nama, double harga, String kategori, double diskon) {
        super(nama, harga, kategori);
        this.diskon = diskon;
    }

    // Mengambil persentase diskon

    public double getDiskon() {
        return diskon;
    }

    // Mengubah persentase diskon

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    /*
        Menampilkan informasi diskon

        Method ini merupakan implementasi dari method abstrak tampilMenu()

        Konsep:
        - Method Overriding
        - Polymorphism
    */

    @Override
    public void tampilMenu() {
        System.out.println("Nama Promo          : " + getNama());
        System.out.println("Kategori            : " + getKategori());
        System.out.println("Nilai Diskon        : " + diskon + "%");
        System.out.println("Harga Referensi     : " + FormatUtil.formatRupiah(getHarga()));
    }
}
