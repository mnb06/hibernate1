package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import models.Estudiante;

import java.util.Scanner;


public class EstudianteController {



    //Crear Estudiante
    public String createEstudiante(int id, String nombre, int dni){

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class).buildSessionFactory();

        Session session = sessionFactory.openSession(); // Abre la sesion

        try{
            Estudiante estudiante = new Estudiante(id,nombre,dni);
            session.beginTransaction(); //Abre la conexion entre java y postgres
            session.save(estudiante); //Guarda el estudiante
            session.getTransaction().commit(); // Commit a la base de datos
            sessionFactory.close(); //Cierra la sesion
            return "Estudiante creado";

        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al crear";
    }

    // Borrar estudiante
    public String deleteEstudiante(int id){

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class).buildSessionFactory();

        Session session = sessionFactory.openSession(); // Abre la sesion

        try{
            session.beginTransaction(); //Abre la conexion entre java y postgres
            Estudiante estudiante = session.get(Estudiante.class, id); // Localizar el estudiante
            session.delete(estudiante);
            session.getTransaction().commit(); // Commit a la base de datos
            sessionFactory.close(); //Cierra la sesion
            return "Estudiante eliminado";

        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al eliminar";
    }


    // Actualizar estudiante
    public String updateEstudiante(int id){

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class).buildSessionFactory();

        Session session = sessionFactory.openSession(); // Abre la sesion


        try{
            session.beginTransaction(); //Abre la conexion entre java y postgres
            Estudiante estudiante = session.get(Estudiante.class, id); // Localizar el estudiante

            update(estudiante); //Llamada al modulo de update

            session.update(estudiante);
            session.getTransaction().commit(); // Commit a la base de datos
            sessionFactory.close(); //Cierra la sesion
            return "Estudiante actualizado";

        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al actualizar";
    }


    public void update(Estudiante e){
        Scanner in = new Scanner(System.in);

        System.out.println("Ingrese dato a modificar: ");
        System.out.println("1) nombre");
        System.out.println("2) dni");
        System.out.println(" ");

        int x = in.nextInt();

        if(x == 1){
            System.out.println("Ingrese nombre nuevo");
            String name = in.next();
            e.setNombre(name);
        } else if (x == 2) {
            System.out.println("Ingrese dni nuevo");
            int dni = in.nextInt();
            e.setDni(dni);

        }
    }

    // Mostrar al estudiante
    public String getEstudiante(int id){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class).buildSessionFactory();

        Session session = sessionFactory.openSession(); // Abre la sesion


        try{
            session.beginTransaction(); //Abre la conexion entre java y postgres
            Estudiante estudiante = session.get(Estudiante.class, id); // Localizar el estudiante


            session.getTransaction().commit(); // Commit a la base de datos
            sessionFactory.close(); //Cierra la sesion
            return estudiante.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return "No se ha encontrado al estudiante";
    }
}