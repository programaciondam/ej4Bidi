/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4bidi;

import fecha.Fecha;
import numeros.Numero;

/**
 *
 * @author alumno
 */
public class Empresa {

    Empleado[] empleados;
    Float[][] incentivos;
    int[] antiguedades;

    public Empresa(int ntra) {
        empleados = new Empleado[ntra];
        antiguedades = new int[]{5, 10, 20, Integer.MAX_VALUE};
        incentivos = new Float[][]{
            {100f, 250f, 500f},
            {200f, 400f, 800f},
            {400f, 800f, 1600f},
            {600f, 1200f, 2400f}
        };
    }

    public void pedirDatos() {
        String nombre;
        Fecha falta;
        int nhijos;

        for (int ntra = 0; ntra < empleados.length; ntra++) {
            nombre = Numero.pedirString("Introduce el nombre del trabajador:");
            falta = Numero.pedirFecha("Introduce la fecha de entrada del "
                    + "trabajador en formato dd/mm/aaaa:");
            nhijos = Numero.pedirNumeroEntero("Introduce el numero de hijos del trabajador",
                    0, 10);
            empleados[ntra] = new Empleado(nhijos);
            empleados[ntra].grabar(nombre, falta);
        }
    }

    public void pedirHijos() {
        Fecha fnac;

        for (int pos = 0; pos < empleados.length; pos++) {
            System.out.println(empleados[pos].getNombre());
            for (int hijos = 0; hijos < empleados[pos].getFnac().length; hijos++) {
                fnac = Numero.pedirFecha("Introduce la fecha de nacimiento de los hijos");
                empleados[pos].grabarHijo(fnac, hijos);
            }
        }
    }

    public void informe() {
        int fila, columna;
        int hCompu;
        System.out.println("Nombre \t Numero hijos \t "
                + "Fecha nacimiento primer hijo \t Fecha nacimiento segundo hijo"
                + "Incentivo \t Observaciones ");

        for (int ntra = 0; ntra < empleados.length; ntra++) {
            System.out.print(empleados[ntra].getNombre() + "\t");
            System.out.print(empleados[ntra].getFnac().length + "\t");
            for (int hijo = 0; hijo < empleados[ntra].getFnac().length; hijo++) {
                System.out.print(empleados[ntra].getFnac()[hijo].visualizar() + "\t");
            }
            System.out.print(empleados[ntra].hijoNoComputable() + "\t");
            fila = buscarAntiguedad(empleados[ntra].getFalta());
            hCompu = empleados[ntra].hijoComputable();

            if (hCompu > 0) {
                if (hCompu >= 1 && hCompu <= 3) {
                    columna= hCompu - 1;
                } else {
                    columna = 2;
                }
                System.out.println(incentivos[fila][columna]);
            }
            System.out.println("0");
        }
    }

    private int buscarAntiguedad(Fecha fecha) {
        int nanos = fecha.calculoNAnos();
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < antiguedades.length) {
            if (nanos < antiguedades[pos]) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        return pos;
    }
}
