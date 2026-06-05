package com.terbuka.model;

// Mengimport fungsi dari class FormatUtil

import com.terbuka.util.FormatUtil;

/*
    Sama seperti pada class Makanan
    Class ini juga merupakan turunan dari class MenuItem
*/

public class Minuman extends MenuItem {

    /*
        Jenis Minuman untuk saya menyimpan
        Minuman Jus
        Minuman air mineral
        Minuman Dingin
        Minuman Panas
    */

    private String jenisMinuman;

    // Constructor

    public Minuman(String nama, double harga, String kategori, String jenisMinuman) {
        super(nama, harga, kategori);
        this.jenisMinuman = jenisMinuman;
    }

    public String getJenisMinuman() {
        return jenisMinuman;
    }

    public void setJenisMinuman(String jenisMinuman) {
        this.jenisMinuman = jenisMinuman;
    }

    /*
        Implemntasi dari method abstrak seperti class Makanan

        Konsep:
        - Method Overriding
        - Polymorphism
    */

    @Override
    public void tampilMenu() {
        System.out.println("Nama Menu           : " + getNama());
        System.out.println("Harga               : " + FormatUtil.formatRupiah(getHarga()));
        System.out.println("Kategori            : " + getKategori());
        System.out.println("Jenis Minuman       : " + jenisMinuman);
    }
}
