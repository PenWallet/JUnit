import java.io.*;
import org.junit.Assert;
import org.junit.Test;

public class Testooooo {
    @Test
    public void test(){



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
    public boolean ContarBarcos(int[][] array)
    {
        int contadorGeneral = 0, cB5 = 0, cB4 = 0, cb3 = 0, cB2 = 0;

        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[0].length; j++)
            {
                if(array[i][j] == 1)
                {
                    contadorGeneral++;
                    if(contadorGeneral == 1)
                    {
						
                    }

                }
            }
        }
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
               if(i != 0 && array[i-1][j] == 1)
                   correcto = false;
               if(i != 0 && j != (array[0].length - 1) && array[i-1][j+1] == 1)
                   correcto = false;
               if(j != 0 && array[i][j-1] == 1)
                   correcto = false;
               if(i != (array.length - 1) && j != 0 && array[i+1][j-1] == 1)
                   correcto = false;
               if(i != (array.length - 1) && array[i+1][j] == 1)
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
                    correcto = true;
                if(i != 0 && j != (array[0].length - 1) && array[i-1][j+1] == 1)
                    correcto = false;
                if(j != 0 && array[i][j-1] == 1)
                    correcto = false;
                if(j != (array[0].length - 1) && array[i][j+1] == 1)
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
                if(i != (array.length - 1) && array[i+1][j] == 1)
                    correcto = false;
                if(i != (array.length - 1) && j != (array[0].length - 1) && array[i+1][j+1] == 1)
                    correcto = false;
            }
        }

        return(correcto);

    }

}
