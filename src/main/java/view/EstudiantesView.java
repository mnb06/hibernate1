package view;

import controllers.EstudianteController;

public class EstudiantesView {
    public static void main(String[] args) {


        //Crear Estudiante
        String createEstudiante = new EstudianteController().createEstudiante(2,"Nicolas", 43012543);
        System.out.println(createEstudiante);


        //Borrar Estudiante (con el id)
        //String deleteEstudiante = new EstudianteController().deleteEstudiante(2);
        //System.out.println(deleteEstudiante);


        //Actualizar Estudiante
        //String updateEstudiante = new EstudianteController().updateEstudiante(2);
        //System.out.println(updateEstudiante);


        // Mostrar estudiante
        //String getEstudiante = new EstudianteController().getEstudiante(2);
        //System.out.println(getEstudiante);

    }
}