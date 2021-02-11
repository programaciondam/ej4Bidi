/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4bidi;

import fecha.Fecha;

/**
 *
 * @author alumno
 */
public class Empleado {

    private String nombre;
    private Fecha falta;
    private Fecha[] fnac;

    public Empleado(int nhijos) {
        fnac = new Fecha[nhijos];
    }

    public void grabar(String nombre, Fecha falta) {
        this.nombre = nombre;
        this.falta = falta;
    }

    public void grabarHijos(Fecha[] fnac) {
        this.fnac = fnac;
    }

    public void grabarHijo(Fecha fechaNacimiento, int pos) {
        this.fnac[pos] = fechaNacimiento;
    }

    public int hijoComputable() {
        int anno;
        int hijosC = 0;

        for (int pos = 0; pos < fnac.length; pos++) {
            if (fnac[pos].calculoNAnos() < 18) {
                hijosC++;
            }
        }
        return hijosC;
    }

    public int hijoNoComputable() {
        int hijosNC;
        return hijosNC = fnac.length - hijoComputable();
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFalta() {
        return falta;
    }

    public Fecha[] getFnac() {
        return fnac;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFalta(Fecha falta) {
        this.falta = falta;
    }

    public void setFnac(Fecha[] fnac) {
        this.fnac = fnac;
    }
}
