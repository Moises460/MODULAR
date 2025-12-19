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
        char[][] prueba = {
                {'1','-','-','-','-','-','-','-','2'},
                {'-','-','-','-','-','-','-','-','-'},
                {'-','-','-','-','-','-','-','-','-'},
                {'-','-','-','-','-','-','-','-','-'},
                {'-','-','-','-','-','-','-','-','-'},
                {'-','-','-','-','-','-','-','-','-'},
                {'-','-','-','-','-','-','-','-','-'},
                {'-','-','-','-','-','-','-','-','-'},
                {'2','-','-','-','-','-','-','-','1'}
        };

        assertTrue(Sudokus.Comprobar_simetria(prueba));
    }


    @Test
    void validador() {
        char[][] prueba = new char[9][9];


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                prueba[i][j] = '-';
            }
        }

        // Colocar números simétricos
        prueba[0][0] = '1';
        prueba[8][8] = '1';

        assertTrue(Sudokus.Validador(prueba));
    }
}