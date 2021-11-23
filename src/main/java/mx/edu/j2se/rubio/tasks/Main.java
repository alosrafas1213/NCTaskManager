package mx.edu.j2se.rubio.tasks;

/*
 * @author  Alonso Rafael Rubio Carmona
 *
 *
 *
 * */

public class Main {
	
	public static void main(String[] args) {

		Task tarea2 = new Task("Tarea 2",4,11,2);
		Task tarea3 = new Task("Tarea 3",24,28,2);
		Task tarea4 = new Task("Tarea 4",34,41,2);
		Task tarea5 = new Task("Tarea 5",50,54,2);
		Task tarea6 = new Task("Tarea 6",60,64,2);
		Task tarea7 = new Task("Tarea 7",5);
		Task tarea8 = new Task("Tarea 8",20);
		Task tarea9 = new Task("Tarea 9",60);

		ArrayTaskList tareas = new ArrayTaskList();

		tareas.add(tarea2);
		tareas.add(tarea3);
		tareas.add(tarea4);
		tareas.add(tarea5);
		tareas.add(tarea6);
		tareas.add(tarea7);
		tareas.add(tarea8);
		tareas.add(tarea9);

		ArrayTaskList tareas2 = tareas.incoming(4,60);
		String[] titles = tareas2.getTasksnames();
		for (String title : titles) System.out.println(title);
	}
	
}
