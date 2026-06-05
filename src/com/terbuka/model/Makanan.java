package com.terbuka.model;

// Mengimport fungsi dari class FormatUtil
import com.terbuka.util.FormatUtil; 

/*
    Class Makanan ini merupakan turunan dari MenuItem
    Class ini digunakan untuk merepresentasikan menu makanan yang ada pada program restoran.
    Konsep yang digunakan terdapat
    - Inheritance
    - Polymorphism
*/

public class Makanan extends MenuItem {
    
    /*
        Jenis makanan ini untuk saya menyimpan jenis seperti
        - menu utama
        - menu tamabahan
    */

    private String jenisMakanan;

    // Constructor makanan

    public Makanan(String nama, double harga, String kategori, String jenisMakanan) {
        super(nama, harga, kategori);
        this.jenisMakanan = jenisMakanan;
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }

    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }

    /*
        Menampilkan informasi menu makanan
        Method ini merupakan implementasi dari method abstrak tampilMenu() pada class MenuItem

        Konsep
        - Method Overriding
        - Polymorphism
    */

    @Override
    public void tampilMenu() {
        System.out.println("Nama Menu       : " + getNama());
        System.out.println("Harga           : " + FormatUtil.formatRupiah(getHarga()));
        System.out.println("Kategori        : " + getKategori());
        System.out.println("Jenis Makanan   : " + jenisMakanan);
    }
}
