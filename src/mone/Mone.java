/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mone;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Morad
 */
public class Mone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Empleado> listaEmpleados = new ArrayList();
        // Empleado empleados = new Empleado();

        //Empleado1.subirSalario(10.55555555f);//hay que poner  f porque es un float
        //  System.out.println(Empleado1);
        int opcion = 0;
        cargarDatosIniciales(listaEmpleados);

        do {
            mostrarMenu();
            opcion = pedirOpcionMenu(opcion);

            switch (opcion) {
                case 1:
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("hola estos son los empleados que hay actualmente");
                    mostrarEmpleados(listaEmpleados);
                    break;

                case 2:
                    System.out.println("-----------------------------------------------------------");
                    altaNuevoEmpleado(listaEmpleados);
                    break;

                case 3:
                    buscarEmpleadoNombre(listaEmpleados);

                    break;

                case 4:
                    buscarEmpleadoDepartamento(listaEmpleados);
                    break;

                case 5:
                    borrarEmpleado(listaEmpleados);
                    break;

                case 6:
                    buscarEmpleadosSegunSueldo(listaEmpleados);
                    break;

                case 7:
                    subirSueldo(listaEmpleados);
                    break;

            }

        } while (opcion != 8);

        System.out.println("Fin");

    }

    public static void cargarDatosIniciales(ArrayList<Empleado> listaEmpleados) {

        Empleado empleado;
        String[] datosIniciales = {
            "Aitor Tilla Informática 60000",
            "Ester Colero Logística 34000",
            "AndRés Trozado Informática 56000",
            "ArmAndo Ruido Logística 39000",
            "Dolores Fuertes Comercial 45000",
            "Enrique Cide Comercial 48000",
            "Estela Gartija Logística 52000",
            "Josechu Leton Informática 49000",
            "Lola Mento Informática 51000"};

        for (int i = 0; i < datosIniciales.length; i++) {

            String[] array2 = datosIniciales[i].split(" ");

            // System.out.println(empleado.toString());
            empleado = new Empleado(array2[0], array2[1], array2[2], Integer.parseInt(array2[3]));

            listaEmpleados.add(empleado);

        }

        for (int i = 0; i < listaEmpleados.size(); i++) {

            System.out.println(listaEmpleados.get(i).toString());
        }

    }

    public static String inicialMayuscula(String palabra) {

        return palabra;
    }

    public static void mostrarMenu() {

        System.out.println("-----------------------------------------------------------");
        System.out.println("1- Mostrar todos los empleados.");
        System.out.println("2- Dar de alta un nuevo empleado.");
        System.out.println("3- Buscar un empleado por el nombre.");
        System.out.println("4- Buscar todos los empleados de un departamento.");
        System.out.println("5- Borrar un empleado indicando el nombre.");
        System.out.println("6- Buscar los empleados que tengan sueldos entre dos que se solicitan por pantalla.");
        System.out.println("7- Subir el sueldo a un empleado. Hay que solicitar el nombre del empleado y el porcentaje de subida.");

    }

    //metodo para pedir opcion por teclado
    public static int pedirOpcionMenu(int opcion) {
        Scanner sc = new Scanner(System.in);
        opcion = sc.nextInt();

        return opcion;

    }

    public static void mostrarEmpleados(ArrayList<Empleado> listaEmpleados) {

        for (int i = 0; i < listaEmpleados.size(); i++) {

            System.out.println(listaEmpleados.get(i).toString());
        }

    }

    public static void altaNuevoEmpleado(ArrayList<Empleado> listaEmpleados) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre del empleado");
        String nombre;
        String apellido;
        String departamento;
        Integer salario;

        System.out.println("Introduce nombre del empleado");
        nombre = sc.nextLine();

        System.out.println("Introduce apellido del empleado");
        apellido = sc.nextLine();

        System.out.println("Introduce Departamento del empleado");
        departamento = sc.nextLine();

        System.out.println("Introduce salario del empleado");
        salario = sc.nextInt();

        Empleado empleado = new Empleado(nombre, apellido, departamento, salario);
        listaEmpleados.add(empleado);

    }

    public static boolean buscarNombre(ArrayList<Empleado> listaEmpleados, String nombre) {

        boolean encontrado = false;

        int i = 0;

        while (encontrado == false && i < listaEmpleados.size()) {
            if (listaEmpleados.get(i).getNombre().compareToIgnoreCase(nombre) == 0) {
                encontrado = true;

            } else {
                i++;
                //si no encontramos la variable en la lista incrementamos para seguir buscando
            }

        }

        if (encontrado) {
            System.out.println(listaEmpleados.get(i).toString());
            return false;
        } else {
            System.out.println("no existe el empleado");
            return true;
        }

    }

    public static void buscarEmpleadoNombre(ArrayList<Empleado> listaEmpleados) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre del empleado");
        String nombre;
        nombre = sc.nextLine();

        //uso el metodo de aariba
        buscarNombre(listaEmpleados, nombre);

    }

    public static void buscarEmpleadoDepartamento(ArrayList<Empleado> listaEmpleados) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce departamento");
        String departamento;
        departamento = sc.nextLine();
        //ojo aqui si se mete otro departamento distinto no funciona
        if (departamento.equalsIgnoreCase("comercial") || departamento.equalsIgnoreCase("informática") || departamento.equalsIgnoreCase("logística")) {

            for (int i = 0; i < listaEmpleados.size(); i++) {

                if (listaEmpleados.get(i).getDepartamento().compareToIgnoreCase(departamento) == 0) {
                    System.out.println(listaEmpleados.get(i).toString());
                }
                // else System.out.println("no hay ningun empleado en ese departamento");

            }

        } else {
            System.out.println("departamento no existe");
        }

    }

    public static void borrarEmpleado(ArrayList<Empleado> listaEmpleados) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre del empleado");
        String nombre;
        nombre = sc.nextLine();

        int contador = 0;
        for (int i = 0; i < listaEmpleados.size(); i++) {

            //si el nombre existe
            if (listaEmpleados.get(i).getNombre().contains(nombre)) {

                listaEmpleados.remove(i);
                contador++;
                System.out.println("se ha eliminado" + contador + "empleados");

            }

        }

    }

    public static void buscarEmpleadosSegunSueldo(ArrayList<Empleado> listaEmpleados) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce El primer sueldo");
        Integer salario1;
        salario1 = sc.nextInt();

        System.out.println("Introduce El segundo sueldo");
        Integer salario2;
        salario2 = sc.nextInt();

        for (int i = 0; i < listaEmpleados.size(); i++) {

            if (listaEmpleados.get(i).getSalario() > salario1 && listaEmpleados.get(i).getSalario() < salario2) {

                System.out.println(listaEmpleados.get(i).toString());

            }

        }

    }

    public static void subirSueldo(ArrayList<Empleado> listaEmpleados) {

        //el metodo subir salario esta en la clase empleado, no lo he puesto aqui
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce nombre del empleado");
        String nombre;
        nombre = sc.nextLine();

        //este numero puede ser decimal
        System.out.println("Introduce El porcentaje sin el %");
        float porcentSubida;
        porcentSubida = sc.nextFloat();

        for (int i = 0; i < listaEmpleados.size(); i++) {

            if (listaEmpleados.get(i).getNombre().compareToIgnoreCase(nombre) == 0) {

                listaEmpleados.get(i).subirSalario(porcentSubida);
            }

        }

    }

    
}
