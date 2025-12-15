package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokusTest {

    @Test
    void lectura() {
    }

    @Test
    void contarlinea() {
        char[][]prueba={
                {'-','5','-','-','6','8','9','-','-'},
                {'-','5','-','-','6','8','9','-','-'},
                {'-','5','-','-','6','8','9','-','-'},
                {'-','5','-','-','6','8','9','-','-'},
                {'-','5','-','-','6','8','9','-','-'},
                {'-','5','-','-','6','8','9','-','-'},
                {'-','5','-','-','6','8','9','-','-'},
                {'-','5','-','-','6','8','9','-','-'},
                {'-','5','-','-','6','8','9','-','-'}};
        assertEquals(36,Sudokus.Contarlinea(prueba));
    }

    @Test
    void comprobar_simetria() {
    }

    @Test
    void validador() {
    }
}