package org.alandoc.vista;

import org.alandoc.model.Localidad;

public class Menu {
    public static void Estado(){
        System.out.println("Ingrese Estado");
    }
    public static void Menu1(){
        System.out.println("Estado");
        System.out.println("1.- Alta");
        System.out.println("2.- Baja");
        System.out.println("3.- Ver");
        System.out.println("4.- Actualizar");
        System.out.println("5.- Salir");
    }
    public static void Menu2(){
        System.out.println("Menu Localidades");
        System.out.println("1.- Estado");
        System.out.println("2.- Municipio");
        System.out.println("3.- Colonia");
        System.out.println("4.- Salir");
    }
    public static void Menu3(){
        System.out.println("Menu Resumen");
        System.out.println("1.- Catagolo");
        System.out.println("2.- Pendiente");
        System.out.println("3.- Salir");
    }
    public static void Menu4(){
        System.out.println("1.- Consola");
        System.out.println("2.- Ventana");
        System.out.println("3.- Salir");
    }
    public static void errorDato( )
    {
        System.out.println("No es un dato valido");
    }

    public static void opcionInvalida( )
    {
        System.out.println("La opción no es correcta");
    }

    public static void ingreosEstados(Localidad localidad){
        System.out.println(localidad);

    }
    public static void ingresosLocalidad(Localidad localidad){
        System.out.println(localidad);

    }
}
