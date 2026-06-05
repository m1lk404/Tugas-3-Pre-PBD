package com.terbuka.model;

// Mengimport fungsi dari Menu

import com.terbuka.service.Menu;

/*
    Membuat setiap pesanan yang dipilih berulang kali tersimpan secara rapih.

    Konsep yang digunakan:
    - Object composition
    - Encapsulation
*/

public class DetailPesanan {

    // Item menu yang dipesan

    private MenuItem item;

    // Jumlah pesanan

    private int jumlah;

    // Constructor

    public DetailPesanan(MenuItem item, int jumlah) {
        this.item = item;
        this.jumlah = jumlah;
    }

    // Mengambil item menu

    public MenuItem getItem() {
        return item;
    }

    // Mengubah item menu

    public void setItem(MenuItem item) {
        this.item = item;
    }

    // Mengambil jumlah pesanan

    public int getJumlah() {
        return jumlah;
    }

    // Mengubah jumlah pesanan

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    /*
        Menghitung subtotal item pesanan

        harga menu x jumlah
    */

    public double getSubtotal() {
        return item.getHarga() * jumlah;
    }

    /*
        Menambah jumlah pesanan
        Digunakan ketika pelanggan memesan menu yang sama lebih dari satu kali.
    */

    public void tambahJumlah(int tambahan) {
        this.jumlah += tambahan;
    }
}
