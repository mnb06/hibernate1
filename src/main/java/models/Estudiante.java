package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")

public class Estudiante {
    @Id
    @Column(name = "idestudiante")
    private int idestudiante;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "dni")
    private int dni;

    //Constructor vacio
    public Estudiante() {

    }

    //Constructor
    public Estudiante(int id,String nombre, int dni) {
        this.idestudiante = id;
        this.nombre = nombre;
        this.dni = dni;
    }


    @Override
    public String toString() {
        return "Estudiante{" +
                "idestudiante=" + idestudiante +
                ", nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }

    //Idestudiante
    public int getIdestudiante() {
        return idestudiante;
    }
    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }


    //Nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    //DNI
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
}