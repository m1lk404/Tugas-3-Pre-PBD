package com.terbuka.exception;

/*
    Exception yang digunakan ketika menu yang dicari tidak ditemukan.

    Contoh kasus:
    - Nomor menu tidak ditemukan
    - Index menu tidak valid
    - Data menu tidak ditemukan

    Konsep yang digunakan:
    - Exception Handling
    - Custom Exception
*/

public class MenuNotFoundException extends Exception{
    
    // Constructor
    public MenuNotFoundException(String message) {
        super(message);
    }
}
