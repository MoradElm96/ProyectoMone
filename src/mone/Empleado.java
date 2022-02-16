/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mone;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Morad
 */
public class Empleado {

   
    //atributos
    private final String nombre;
    private final String apellido;
    private final String departamento;
    private Integer salario;

    private Empleado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
    
    

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

//constructor
    public Empleado(String nombre, String apellido, String departamento, Integer salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellido=" + apellido + ", departamento=" + departamento + ", salario=" + salario + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    //metodo mostrar
    public void mostrar(Empleado empleado) {

        empleado.toString();

    }

   
    public void subirSalario(float porcentaje) {

        float porcentSubida = porcentaje;

        float salarioFinal = 0;

        salarioFinal = (float) (salario * (porcentaje / 100) + salario);

        this.salario = (int) salarioFinal;

    }
  

  

}
