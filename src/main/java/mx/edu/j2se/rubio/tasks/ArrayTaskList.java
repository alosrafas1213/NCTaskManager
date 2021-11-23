package mx.edu.j2se.rubio.tasks;

public class ArrayTaskList {

    private Task[] tasks = {};

    void add (Task task){
        int size = tasks.length;
        Task[] newArray = new Task[size+1];
        System.arraycopy( tasks, 0, newArray, 0, tasks.length );
        newArray[size] = task;
        tasks = newArray;
    }

    boolean remove (Task task){
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

    int size(){
        return tasks.length;
    }

    Task getTask(int index){
        return tasks[index];
    }

    String[] getTasksnames(){
        int size = tasks.length;
        String[] titles = new String[size];
        for (int i = 0 ; i<size ; i++)
            titles[i] = tasks[i].getTitle();
        return titles;
    }

    Task getTask2(Task task)
    {
        int size = tasks.length;
        for(int i=0 ; i<size ; i++){
            if (task.equals(tasks[i]))
                return tasks[i];
        }
        return null;
    }

    ArrayTaskList incoming(int from, int to){
        ArrayTaskList taskSelection = new ArrayTaskList();
        int size = tasks.length;
        for (int index=0 ; index<size ; index++){
            if(tasks[index].nextTimeAfter(from)>from && tasks[index].nextTimeAfter(from)<to) {
                taskSelection.add(tasks[index]);
            }
        }
        return taskSelection;
    }
}
