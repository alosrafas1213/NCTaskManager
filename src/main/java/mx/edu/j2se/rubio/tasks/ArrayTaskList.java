package mx.edu.j2se.rubio.tasks;

/**
 * @author  Alonso Rafael Rubio Carmona
 *
 * The ArrayTaskList class represents an array list of the task class having an array
 * of tasks as the only attribute of the class
 *
 * */

public class ArrayTaskList {
    /**
    * Empty array of tasks
    * */
    private Task[] tasks = {};


    /**
    * @param task the task to be added to the array
     *
     * The method receives the task that is going to
     * be added, and it copies the actual array into
     * a new one to be able to add the new task
    * */
    public void add (Task task){
        int size = tasks.length;
        Task[] newArray = new Task[size+1];
        System.arraycopy( tasks, 0, newArray, 0, tasks.length );
        newArray[size] = task;
        tasks = newArray;
    }

    /**
     * @param task the task to be removed from the array
     * @return true if there is a match of the task to be
     *         removed or false if there is not any match
     *
     * The method receives the task that is going to
     * be removed, using the index of the actual array
     * and a second index of the new array of size -1
     * it checks within the array for any match of the
     * task in the array, if it finds a match, the flag
     * updates its value to 1 and the task is skipped,
     * then the method continues copying the remaining tasks
     * into the new array and the method returns true
     * otherwise if there is not any match, the
     * method returns false
     * */
    public boolean remove (Task task){
        int index;
        int index2 = 0;
        int flag = 0;
        int size = tasks.length;
        Task[] newArray = new Task[size-1];

        for (index=0 ; index<size ; index++,index2++){
            if (!task.equals(tasks[index]))
                newArray[index2] = tasks[index];
            else{
                if(flag!=1){
                    flag = 1;
                    index2--;
                }
                else
                    newArray[index2] = tasks[index];
            }
            if(index2==size-1)
                break;
        }
        if (flag==0)
            return false;
        else{
            tasks = newArray;
            return true;
        }
    }

    public int size(){
        return tasks.length;
    }

    public Task getTask(int index){
        return tasks[index];
    }

    /**
     * @param from start time to check if there is a task
     *            within the interval
     * @param to end time to check if there is a tasks
     *           whithin the interval
     * @return ArrayTaskList of the tasks found in the time interval
     *
     * The method creates a new ArrayTaskList object to add the found tasks
     * within the interval into the array
     **/
    public ArrayTaskList incoming(int from, int to){
        ArrayTaskList taskSelection = new ArrayTaskList();
        for (Task task : tasks) {
            System.out.println("nextTimeAfter: "+task.nextTimeAfter(from));
            if (task.nextTimeAfter(from) > from && task.nextTimeAfter(from) < to) {
                taskSelection.add(task);
            }
        }
        return taskSelection;
    }
}
