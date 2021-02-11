/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4bidi;

import numeros.Numero;

/**
 *
 * @author alumno
 */
public class Ej4Bidi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int ntra;
        ntra = Numero.pedirNumeroEntero("Introduce el número de trabajadores"
                , 1, 150);
        Empresa miEmpresa;
        miEmpresa= new Empresa(ntra);
        miEmpresa.pedirDatos();
        miEmpresa.pedirHijos();
        miEmpresa.informe();
    }
    
}
