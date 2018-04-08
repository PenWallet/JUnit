package Gestora;

import Gestora.*;
import Clases.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testooooo {
    @Test
    public static void main(String[] args){
        int c1 = 0, c2 = 0, c3 = 0;

        Casilla[][] t1 = GestoraBuscaMinas.CrearTableroFacil();
        Casilla[][] t2 = GestoraBuscaMinas.CrearTableroFacil();
        Casilla[][] t3 = GestoraBuscaMinas.CrearTableroFacil();

        //Comprobamos que el tama�o de los tableros es de 8x8
        assertEquals(8, t1.length);
        assertEquals(8, t1[0].length);
        assertEquals(8, t2.length);
        assertEquals(8, t2[0].length);
        assertEquals(8, t3.length);
        assertEquals(8, t3[0].length);

        //Una vez comprobados que el tama�o de los tableros es de 8x8, pasamos a comprobar que en el tablero
        //hay efectivamente, 10 bombas y no m�s
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(t1[i][j].getMina())
                    c1++;
                if(t2[i][j].getMina())
                    c2++;
                if(t3[i][j].getMina())
                    c3++;

            }
        }

        assertEquals(10, c1);
        assertEquals(10, c2);
        assertEquals(10, c3);

    }

}
