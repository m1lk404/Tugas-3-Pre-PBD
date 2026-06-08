package com.terbuka.service;

import com.terbuka.exception.MenuNotFoundException;
import com.terbuka.model.MenuItem;
import java.util.ArrayList;

/*
    Class Menu digunakan untuk mengelola seluruh item menu restoran.
    
    Class ini menyimpan data menu menggunakan ArrayList

    Fitur :
    - Menambah menu
    - Menampilkan menu
    - Mencari menu berdasarkan nomor
    - Menghapus menu

    Konsep yang digunakan:
    - ArrayList
    - Encapsulation
    - Exception Handling
*/

public class Menu {

    // Daftar seluruh menu restoran
    private ArrayList<MenuItem> daftarMenu;

    // Constructor
    public Menu() {
        daftarMenu = new ArrayList<>();
    }

    // Menambahkan item menu ke daftar menu.
    public void tambahMenu(MenuItem item) {
        daftarMenu.add(item);
    }

    // Mengambil seluruh daftar menu.
    public ArrayList<MenuItem> getDaftarMenu() {
        return daftarMenu;
    }

    // Menampilkan seluruh menu restoran
    public void tampilkanMenu() {
        if (daftarMenu.isEmpty()) {
            System.out.println("Menu masih kosong!");
            return;
        }

        System.out.println("\n===== DAFTAR MENU =====");
        for (int i = 0; i < daftarMenu.size(); i++) {
            System.out.println("\nNomor Menu : " + (i + 1));
            daftarMenu.get(i).tampilMenu();
            System.out.println("------------------------");
        }
    }

    // Mengambil menu berdasarkan nomor menu dimulai dari 1
    public MenuItem cariMenu(int nomorMenu) throws MenuNotFoundException {
        int index = nomorMenu - 1;

        if (index < 0 || index >= daftarMenu.size()) {
            throw new MenuNotFoundException("Menu Tidak Ditemukan!");
        }

        return daftarMenu.get(index);
    }

    // Menghapus menu berdasarkan nomor
    public void hapusMenu(int nomorMenu) throws MenuNotFoundException {
        int index = nomorMenu - 1;

        if (index < 0 || index >= daftarMenu.size()) {
            throw new MenuNotFoundException("Menu Tidak Ditemukan!");
        }

        daftarMenu.remove(index);
    }

    // Mengubah harga menu
    public void ubahHargaMenu(int nomorMenu, double hargaBaru) throws MenuNotFoundException {
        MenuItem item = cariMenu(nomorMenu);
        item.setHarga(hargaBaru);
    }

    // Mengecek apakah daftar menu kosong
    public boolean isKosong() {
        return daftarMenu.isEmpty();
    }
}
