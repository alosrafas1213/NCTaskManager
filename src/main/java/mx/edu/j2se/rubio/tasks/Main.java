package mx.edu.j2se.rubio.tasks;
import java.time.LocalDateTime;
import java.util.Iterator;
/*
 * @author  Alonso Rafael Rubio Carmona
 *
 *
 *
 * */

public class Main {
	
	public static void main(String[] args) throws Exception {
		/*
		//LinkedTaskList tasks = new LinkedTaskList();
		tasks.add(new Task("task 1",5));
		tasks.add(new Task("task 2",4,11,2));
		tasks.add(new Task("task 3",10,25,4));
		tasks.add(new Task("task 4",25));
		Task middleTask = new Task("Middle task",1,60,7);
		tasks.add(middleTask);
		tasks.add(new Task("task 5",20,31,1));
		tasks.add(new Task("task 6",25,40,5));
		tasks.add(new Task("task 7",52));
		tasks.add(new Task("task 8",21,50,2));

		Task task9 = new Task("task 9",12,37,2);

		tasks.add(task9);

		//System.out.println("Size: " + tasks.size());

		//System.out.println(tasks.getTask(7).getTitle());

		String[] titles = tasks.titles();

		System.out.println("Before removing task 9");

		for(String title : titles)
			System.out.println(title);



		tasks.remove(task9);

		titles = tasks.titles();

		System.out.println("After removing task 9");

		for(String title : titles)
			System.out.println(title);

		System.out.println("After removing middleTask");

		Task testoTask = new Task("testoTask",1);

		System.out.println("Task removed: " + tasks.remove(middleTask));

		titles = tasks.titles();

		for(String title : titles)
			System.out.println(title);


		/*
		for(int index=0 ; index< tasks.size() ; index++)
		{
			tasks.getTask(index).setActive(true);
		}

		String[] titlesIncoming = tasks.incoming(15,40).titles();
		System.out.println("Tasks after incoming method");
		for(String title : titlesIncoming)
			System.out.println(title);

	*/

		AbstractTaskList tasks = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
		Task task1 = new Task("task 1", LocalDateTime.of(2022, 1, 13, 5, 0));
		Task task2 = new Task("task 2",LocalDateTime.of(2022, 1, 13, 5, 0),LocalDateTime.of(2022, 1, 20, 2, 0),2);
		Task task3 = new Task("task 3",LocalDateTime.of(2022, 1, 20, 5, 55),LocalDateTime.of(2022, 2, 11, 3, 20),4);

		AbstractTaskList task4 = tasks.clone();

		System.out.println("\n"+task4);

		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		for(int index=0 ; index< tasks.size() ; index++)
		{
			tasks.getTask(index).setActive(true);
		}

		System.out.println(tasks);



		Iterable<Task> incomingTasks = Tasks.incoming(tasks,LocalDateTime.of(2022, 1, 13, 4, 55),LocalDateTime.of(2022, 2, 15, 5, 55));
		System.out.println("Tasks after incoming method");
		incomingTasks.forEach(System.out::println);

	}

}
