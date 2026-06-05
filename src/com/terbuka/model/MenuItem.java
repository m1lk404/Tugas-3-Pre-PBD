package com.terbuka.model;

/*
    Class abstrak yang menjadi induk dari seluruh item menu restoran.
    Class ini menyimpan informasi dasar yang dimiliki semua menu yaitu nama, harga, dan kategori.

    Kelas turunan:
    - Makanan
    - Minuman
    - Diskon

    Konsep yang digunakan:
    - Abstraction
    - Encapsulation
    - Inheritance
*/

public abstract class MenuItem {
    private String nama;
    private double harga;
    private String kategori;

    /*
        Contructor MenuItem
        
        Membuat parameter
    */

    public MenuItem(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    // Mengambil nama menu

    public String getNama() {
        return nama;
    }

    // Mengubah nama menu

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Mengambil harga menu

    public double getHarga() {
        return harga;
    }

    // mengubah harga menu

    public void setHarga(double harga) {
        this.harga = harga;
    }

    //  Mengambil kategori

    public String getKategori() {
        return kategori;
    }

    // Mengubah kategori

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    /*
        Method abstrak yang harus dioverride oleh setiap subclass.
        Digunakan untuk menampilkan informasi menu sesuai jenisnya.
        Meupakan konsep dari abstraction dan polymorphism.
    */

    public abstract void tampilMenu();
}
