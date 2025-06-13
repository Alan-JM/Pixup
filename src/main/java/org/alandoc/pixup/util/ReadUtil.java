package org.alandoc.pixup.util;

import java.util.Scanner;

public class ReadUtil
{
    private Scanner scanner;
    private static ReadUtil readUtil;

    private ReadUtil()
    {
        scanner = new Scanner( System.in );
    }

    public Scanner getScanner()
    {
        return scanner;
    }

    public static ReadUtil getInstance( )
    {
        if(readUtil==null)
        {
            readUtil = new ReadUtil();
        }
        return readUtil;
    }

    public static String read( )
    {
        return getInstance( ).getScanner( ).nextLine();
    }

    public static Integer readInt( )
    {
        String valor = null;
        boolean flag = true;
        Integer aux = null;

        while (flag)
        {
            valor = read();
            if (valor != null && !valor.isEmpty())
            {
                try
                {
                    aux = Integer.valueOf(valor);
                    if (aux != null)
                    {
                        return aux;
                    }
                }
                catch (Exception e)
                {
                }
            }
            System.out.println( "Valor incorrecto, intentelo nuevamente" );
        }
        return null;
    }

    public static Integer string2Integer( String valor )
    {
        try
        {
            return Integer.valueOf(valor);
        }
        catch (Exception e)
        {
        }
        return null;
    }
<<<<<<< HEAD

    public static Float readFloat() {
        String valor = null;
        boolean flag = true;
        Float aux = null;

        while (flag) {
            valor = read();
            if (valor != null && !valor.isEmpty()) {
                try {
                    aux = Float.valueOf(valor);
                    if (aux != null) {
                        return aux;
                    }
                } catch (Exception e) {
                    // Ignoramos la excepción y mostramos el mensaje de error
                }
            }
            System.out.println("Valor incorrecto, inténtelo nuevamente");
        }
        return null;
    }
    public static java.sql.Date readDate() {
        String input;
        java.sql.Date date = null;
        boolean flag = true;

        while (flag) {
            input = read(); // reutiliza el metodo read() de tu utilidad
            if (input != null && !input.isEmpty()) {
                try {
                    date = java.sql.Date.valueOf(input);
                    return date;
                } catch (IllegalArgumentException e) {
                    // Formato incorrecto
                }
            }
            System.out.println("Fecha inválida, use el formato yyyy-MM-dd");
        }
        return null;
    }

    public static java.sql.Time readSqlTime() {
        String input;
        java.sql.Time time = null;
        boolean flag = true;

        while (flag) {
            input = read(); // reutiliza tu método read()
            if (input != null && !input.isEmpty()) {
                try {
                    time = java.sql.Time.valueOf(input);
                    return time;
                } catch (IllegalArgumentException e) {
                    // Formato incorrecto
                }
            }
            System.out.println("Hora inválida, use el formato HH:mm:ss");
        }
        return null;
    }
=======
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
}