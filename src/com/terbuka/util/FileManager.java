package com.terbuka.util;

import com.terbuka.model.Diskon;
import com.terbuka.model.Makanan;
import com.terbuka.model.MenuItem;
import com.terbuka.model.Minuman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
    Class ini digunakan untuk mengelola file pada program

    Fitur pada class ini:
    - Menyimpan menu ke file
    - Memuat menu dari file
    - Menyimpan struk ke file
    - Memuat struk ke file

    Konsep yang digunakan:
    - File I/O
    - Exception Handling
*/

public class FileManager {

    /*
        Menyimpan daftar menu ke file teks.

        Format:
        jenis;nama;harga;kategori;atributTambahan
    */
    public void simpanMenu(ArrayList<MenuItem> daftarMenu, String namaFile) throws IOException {
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile));

        for (MenuItem item : daftarMenu) {
            if (item instanceof Makanan makanan) {
                writer.write(
                    "MAKANAN;"
                    + makanan.getNama() + ";"
                    + makanan.getHarga() + ";"
                    + makanan.getKategori() + ";"
                    + makanan.getJenisMakanan()
                );
            } else if (item instanceof Minuman minuman) {
                writer.write(
                    "MINUMAN;"
                    + minuman.getNama() + ";"
                    + minuman.getHarga() + ";"
                    + minuman.getKategori() + ";"
                    + minuman.getJenisMinuman() + ";"
                );
            } else if (item instanceof Diskon diskon) {
                writer.write(
                    "DISKON;"
                    + diskon.getNama() + ";"
                    + diskon.getHarga() + ";"
                    + diskon.getKategori() + ";"
                    + diskon.getDiskon()
                );
            }

            writer.newLine();
        }

        writer.close();
    }

    // Memuat daftar menu dari file teks
    public ArrayList<MenuItem> muatMenu(String namaFile) throws IOException {
        ArrayList<MenuItem> daftarMenu = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(namaFile));
        String baris;

        while ((baris = reader.readLine()) != null) {
            String[] data = baris.split(";");

            String jenis = data[0];
            String nama = data[1];
            double harga = Double.parseDouble(data[2]);
            String kategori = data[3];

            switch (jenis) {
                case "MAKANAN" -> daftarMenu.add(
                    new Makanan(nama, harga, kategori, data[4])
                );
                case "MINUMAN" -> daftarMenu.add(
                    new Minuman(nama, harga, kategori, data[4])
                );
                case "DISKON" -> daftarMenu.add(
                    new Diskon(nama, harga, kategori, Double.parseDouble(data[4]))
                );
            }
        }

        reader.close();

        return daftarMenu;
    }

    // Menyimpan struk ke file teks.
    public void simpanStruk(
        String isiStruk,
        String namaFile
    ) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile));

        writer.write(isiStruk);
        writer.close();
    }

    // Memuat isi struk dari file teks.
    public String muatStruk(
        String namaFile
    ) throws IOException {
        StringBuilder isiStruk = new StringBuilder();

        BufferedReader reader = new BufferedReader(new FileReader(namaFile));

        String baris;

        while ((baris = reader.readLine()) != null) {
            isiStruk.append(baris).append(System.lineSeparator());
        }

        reader.close();
        return isiStruk.toString();
    }
}
