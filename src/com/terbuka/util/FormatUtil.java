package com.terbuka.util;

// Mengimport NumberFormat dan Locale
import java.text.NumberFormat;
import java.util.Locale;

/*
    Class utilitas untuk melakukan format nilai mata rupiah.

    Class ini dibuat agar format rupiah tidak perlu ditulis berulang kali pada banyak class.
*/

public final class FormatUtil {

    // Constructor private
    private FormatUtil() {

    }

    // Mengubah nilai angka menjadi format mata uang rupiah.
    public static String formatRupiah(double nilai) {
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        rupiah.setMaximumFractionDigits(0);
        rupiah.setMinimumFractionDigits(0);

        return rupiah.format(nilai);
    }
}
