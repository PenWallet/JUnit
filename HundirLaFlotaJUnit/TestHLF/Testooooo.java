import java.io.*;
import org.junit.Assert;
import org.junit.Test;

public class Testooooo {
    @Test
    public void test(){
        //Array correcto, no debería dar fallos
        int[][] array1 = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,1,1,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {1,0,0,1,1,1,1,0,0,0},
                {1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,1,0,0}
        };

        Assert.assertTrue(ContarUnos(array1));
        Assert.assertTrue(ContarBarcos(array1));

        //Array incorrecto
        int[][] array2 = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,1,1,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,0},
                {1,0,0,1,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,1,0,0}
        };

        Assert.assertTrue(ContarUnos(array2));
        Assert.assertTrue(ContarBarcos(array2));

        //Array incorrecto
        int[][] array3 = {
                {1,0,0,0,0,0,0,0,0,0},
                {0,0,1,1,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,0},
                {1,0,0,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,1,0,0}
        };

        Assert.assertTrue(ContarUnos(array3));
        Assert.assertTrue(ContarBarcos(array3));

    }

    //Devolverá true si cuenta dieciseis 1, false en caso contrario
    public boolean ContarUnos(int[][] array)
    {
        boolean dieciseis = false;
        int c = 0;

        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[0].length; j++)
            {
                if(array[i][j] == 1)
                    c++;
            }
        }

        if(c == 16)
            dieciseis = true;

        return(dieciseis);

    }


    //Devolverá true si cuenta 1 barco de 5, otro de 4, otro de 3, y dos de 2
    //Devolverá false si encuentra algún error de diseño
    /* Errores de diseño:
        - No hay uno y solo un barco de 5
        - No hay uno y solo un barco de 4
        - No hay uno y solo un barco de 3
        - No hay dos y solo dos barcos de 2
        - Hay algún barco pegado a otro, horizontal, vertical o diagonalmente
     */
    public boolean ContarBarcos(int[][] array)
    {
        int contadorGeneral = 0, cB5 = 0, cB4 = 0, cB3 = 0, cB2 = 0, i = 0, j = 0;
        boolean correcto = CasillasAlrededor(array, i, j, contadorGeneral, true);

        //Parte horizontal
        for(i = 0; i < array.length && correcto; i++)
        {
            for(j = 0; j < array[0].length && correcto; j++)
            {
                if(array[i][j] == 1 && correcto)
                    contadorGeneral++;
                else if(array[i][j] == 0 && correcto)
                {
                    switch(contadorGeneral)
                    {
                        case 2: cB2++; break;
                        case 3: cB3++; break;
                        case 4: cB4++; break;
                        case 5: cB5++; break;
                    }
                    contadorGeneral = 0;
                }

                correcto = CasillasAlrededor(array, i, j, contadorGeneral, true);
            }
        }

        i = 0; j = 0;

        //Parte vertical
        if(correcto)
            correcto = CasillasAlrededor(array, i, j, contadorGeneral, false);

        for(j = 0; j < array.length && correcto; j++)
        {
            for(i = 0; i < array[0].length && correcto; i++)
            {
                if(array[i][j] == 1 && correcto)
                    contadorGeneral++;
                else if(array[i][j] == 0 && correcto)
                {
                    switch(contadorGeneral)
                    {
                        case 2: cB2++; break;
                        case 3: cB3++; break;
                        case 4: cB4++; break;
                        case 5: cB5++; break;
                    }
                    contadorGeneral = 0;
                }

                correcto = CasillasAlrededor(array, i, j, contadorGeneral, false);
            }
        }

        if(cB2 != 2 || cB3 != 1 || cB4 != 1 || cB5 != 1)
            correcto = false;

        return(correcto);


    }

    //Necesita:
    //      el array en el que mira
    //      la i y la j
    //      el contador que lleve ContarBarcos
    //      true si está contando en Horizontal, false en Vertical
    //Devolverá true si es correcto que haya 2 casillas alrededor, false en caso contrario
    public boolean CasillasAlrededor(int[][] array, int i, int j, int contador, boolean HoV)
    {
        boolean correcto = true;
        int contadorAlrededor = 0;

        if(contador == 0)
        {
            if(i != 0 && j != 0 && array[i-1][j-1] == 1)
                contadorAlrededor++;
            if(i != 0 && array[i-1][j] == 1)
                contadorAlrededor++;
            if(i != 0 && j != (array[0].length - 1) && array[i-1][j+1] == 1)
                contadorAlrededor++;
            if(j != 0 && array[i][j-1] == 1)
                contadorAlrededor++;
            if(j != (array[0].length - 1) && array[i][j+1] == 1)
                contadorAlrededor++;
            if(i != (array.length - 1) && j != 0 && array[i+1][j-1] == 1)
                contadorAlrededor++;
            if(i != (array.length - 1) && array[i+1][j] == 1)
                contadorAlrededor++;
            if(i != (array.length - 1) && j != (array[0].length - 1) && array[i+1][j+1] == 1)
                contadorAlrededor++;

            if(contadorAlrededor > 6)
                correcto = false;
            else
                correcto = true;
        }
        else if(HoV)
        {
           if(contador == 1)
           {
               if(j != (array[0].length - 1) && array[i][j+1] == 1)
                   correcto = true;

               if(i != 0 && j != 0 && array[i-1][j-1] == 1)
                   correcto = false;
               if(i != 0 && j != (array[0].length - 1) && array[i-1][j+1] == 1)
                   correcto = false;
               if(j != 0 && array[i][j-1] == 1)
                   correcto = false;
               if(i != (array.length - 1) && j != 0 && array[i+1][j-1] == 1)
                   correcto = false;
               if(i != (array.length - 1) && j != (array[0].length - 1) && array[i+1][j+1] == 1)
                   correcto = false;
           }
           else if(contador > 1)
           {
               if(j != 0 && array[i][j-1] == 1)
                   correcto = true;

               if(i != 0 && j != 0 && array[i-1][j-1] == 1)
                   correcto = false;
               if(i != 0 && array[i-1][j] == 1)
                   correcto = false;
               if(i != 0 && j != (array[0].length - 1) && array[i-1][j+1] == 1)
                   correcto = false;
               if(i != (array.length - 1) && j != 0 && array[i+1][j-1] == 1)
                   correcto = false;
               if(i != (array.length - 1) && array[i+1][j] == 1)
                   correcto = false;
               if(i != (array.length - 1) && j != (array[0].length - 1) && array[i+1][j+1] == 1)
                   correcto = false;
           }
        }
        else
        {
            if(contador == 1)
            {
                if(i != (array.length - 1) && array[i+1][j] == 1)
                    correcto = true;

                if(i != 0 && j != 0 && array[i-1][j-1] == 1)
                    correcto = false;
                if(i != 0 && array[i-1][j] == 1)
                    correcto = false;
                if(i != 0 && j != (array[0].length - 1) && array[i-1][j+1] == 1)
                    correcto = false;
                if(i != (array.length - 1) && j != 0 && array[i+1][j-1] == 1)
                    correcto = false;
                if(i != (array.length - 1) && j != (array[0].length - 1) && array[i+1][j+1] == 1)
                    correcto = false;
            }
            else if(contador > 1)
            {
                if(i != 0 && array[i-1][j] == 1)
                    correcto = true;

                if(i != 0 && j != 0 && array[i-1][j-1] == 1)
                    correcto = false;
                if(i != 0 && j != (array[0].length - 1) && array[i-1][j+1] == 1)
                    correcto = false;
                if(j != 0 && array[i][j-1] == 1)
                    correcto = false;
                if(i != (array.length - 1) && j != 0 && array[i+1][j-1] == 1)
                    correcto = false;
                if(i != (array.length - 1) && j != (array[0].length - 1) && array[i+1][j+1] == 1)
                    correcto = false;
                if(j != (array[0].length - 1) && array[i][j+1] == 1)
                    correcto = false;
            }
        }

        return(correcto);

    }

}
