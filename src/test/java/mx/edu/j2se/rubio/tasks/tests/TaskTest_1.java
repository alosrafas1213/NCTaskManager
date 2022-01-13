package mx.edu.j2se.rubio.tasks.tests;
import mx.edu.j2se.rubio.tasks.ArrayTaskList;
import mx.edu.j2se.rubio.tasks.Task;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

/*
 * @author  Alonso Rafael Rubio Carmona
 *
 *
 *
 * */

public class TaskTest_1 {
    @Test
    public void taskTests(){
        //Non-Repetitive task
        //Task task1 = new Task("task 1",5);

        //Repetitive task
        //Task task2 = new Task("task 2",4,11,2);

        //Set both tasks active
        //task1.setActive(true);
        //task2.setActive(true);


        //repeatedTaskTest(task2);
        //nonRepeatedTaskTest(task1);

        //ArrayTaskList tasks = createTasksArray();
        //tasksArrayTest(tasks);


    }

    public void repeatedTaskTest(Task task){
        //assertEquals Test with the getTitle method
        Assert.assertEquals("task 2",task.getTitle());
        //Task title is changed to Repeated task
        task.setTitle("Repeated task");
        //assertEquals with the new title after using the setTitle method
        //Assert.assertEquals("Repeated task",task.getTitle());
        //assertTrue to verify if the task has been activated correctly
        //Assert.assertTrue(task.isActive());
        //assertEquals to verify the StartTime and EndTime attributes defined before
        //StartTime: 4    EndTime: 11
        //Assert.assertEquals(4,task.getStartTime());
        //Assert.assertEquals(11,task.getEndTime());
        //assertEquals to verify the nextTimeAfter method
        //Current time: 4      NextTime: 6
        //Assert.assertEquals(6,task.nextTimeAfter(4));
        //Current time: 10      NextTime: -1
        //Assert.assertEquals(-1,task.nextTimeAfter(10));
    }

    public void nonRepeatedTaskTest(Task task){
        //assertEquals Test with the getTitle method
        //Assert.assertEquals("task 1",task.getTitle());
        //Task title is changed
        //task.setTitle("Non-repeated task");
        //assertEquals with the new title after using the setTitle method
        //Assert.assertEquals("Non-repeated task",task.getTitle());
        //assertTrue to verify if the task has been activated correctly
        //Assert.assertTrue(task.isActive());
        //assertEquals to verify the time attribute
        //time: 5
        //Assert.assertEquals(5,task.getTime());
        //assertEquals to verify the nextTimeAfter method
        //Current time: 4      NextTime: 6
        //Assert.assertEquals(5,task.nextTimeAfter(4));
        //Current time: 10      NextTime: -1
        //Assert.assertEquals(-1,task.nextTimeAfter(10));

    }

    public ArrayTaskList createTasksArray(){
        //Creates and adds tasks to the arrayTaskList
        ArrayTaskList tasks = new ArrayTaskList();
        tasks.add(new Task("task 1", LocalDateTime.of(2022, 1, 13, 0, 0)));
        tasks.add(new Task("task 2",LocalDateTime.of(2022, 1, 13, 0, 0),LocalDateTime.of(2021, 1, 20, 2, 0),2));
        tasks.add(new Task("task 3",LocalDateTime.of(2022, 1, 20, 5, 55),LocalDateTime.of(2021, 2, 11, 3, 20),4));

        //For loop to set all tasks as active
        for(int index=0 ; index< tasks.size() ; index++)
        {
            tasks.getTask(index).setActive(true);
        }

        return tasks;
    }

    public void tasksArrayTest(ArrayTaskList tasks){
        //AssertEquals to check the arrayTaskList size
        //Assert.assertEquals(8,tasks.size());
        //One more task is added to verify again the size of the Array
        //Task testTask = new Task("task 9",1,11,2);
        //tasks.add(testTask);
        //Assert.assertEquals(9,tasks.size());
        //The last task added is removed to check if the size of the array is correct
        //tasks.remove(testTask);
        //Assert.assertEquals(8,tasks.size());
        //Generates a new arrayTaskList with the tasks between the time 1 and the time 40
        //and it compares the size of the new array with the expected size of 4
        //Assert.assertEquals(4,tasks.incoming(15,40).size());
    }

}
