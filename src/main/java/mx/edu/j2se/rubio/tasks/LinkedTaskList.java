package mx.edu.j2se.rubio.tasks;
/**
 * @author  Alonso Rafael Rubio Carmona
 *
 * The LinkedTaskList class represents a Linked List of the tasks
 *
 * */
public class LinkedTaskList {

    private TaskNode head;
    private TaskNode tail;
    private int size;

    static class TaskNode{
        TaskNode nextElement;
        TaskNode previousElement;
        Task task;
        /**
         * TaskNode class which will contain the task as well as the
         * next and the previous task in the list
         * */
        TaskNode(Task task, TaskNode nextElement ,TaskNode previousElement){
            this.task = task;
            this.nextElement = nextElement;
            this.previousElement = previousElement;
        }


    }
    /**
     * @param task the task to be added to the List
     *
     * The method receives the task that is going to
     * be added to the List
     * */
    public void add(Task task) {
        if (head==null) {
            TaskNode newTask = new TaskNode(task,null,null);
            head = newTask;
            tail = newTask;
            size++;
        }
        else{
            TaskNode lastElement = head;
            while (lastElement.nextElement != null) {
                lastElement = lastElement.nextElement;
            }

            // Insert the new_node at last node
            TaskNode newTask = new TaskNode(task,null,lastElement);
            lastElement.nextElement = newTask;
            tail = newTask;
            size++;
        }
    }


    /**
     * @param task the task to be removed from the List
     * @return true if there is a match of the task to be
     *         removed or false if there is not any match
     *
     * The method receives the task that is going to
     * be removed, using the index of the actual List
     * and a second index of the new List of size -1
     * it checks within the List for any match of the
     * task in the List, if it finds a match, the flag
     * updates its value to 1 and the task is skipped,
     * then the method continues copying the remaining tasks
     * into the new List and the method returns true
     * otherwise if there is not any match, the
     * method returns false
     * */
    public boolean remove (Task task){
        if (head==null) {
            return false;
        }
        TaskNode lastElement = head;
        while (!lastElement.task.equals(task)) {
            if (lastElement.nextElement == null)
                return false;
            lastElement = lastElement.nextElement;
        }

        lastElement.previousElement.nextElement = lastElement.nextElement;
        size--;
        lastElement = null;

        return true;
    }

    public int size(){
        return size;
    }

    public Task getTask(int index){
        int count = 0;
        TaskNode lastElement = head;
        while (lastElement != null && count <= index) {
            if(count==index)
                return lastElement.task;
            lastElement = lastElement.nextElement;
            count++;
        }
        return null;
    }

    /**
     * @param from start time to check if there is a task
     *            within the interval
     * @param to end time to check if there is a tasks
     *           within the interval
     * @return LinkedTaskList of the tasks found in the time interval
     *
     * The method creates a new LinkedTaskList object to add the found tasks
     * within the interval into the array
     **/
    public LinkedTaskList incoming(int from, int to){
        LinkedTaskList taskSelection = new LinkedTaskList();
        TaskNode lastElement = head;
        if(head!=null) {
            if (lastElement.task.nextTimeAfter(from) > from && lastElement.task.nextTimeAfter(from) < to)
                taskSelection.add(lastElement.task);
            while (lastElement.nextElement != null) {
                lastElement = lastElement.nextElement;
                if (lastElement.task.nextTimeAfter(from) > from && lastElement.task.nextTimeAfter(from) < to)
                    taskSelection.add(lastElement.task);
            }
        }
        return taskSelection;
    }

    public String[] titles(){
        int index = 0;
        String[] titles = new String[size];
        if (head!=null) {
            TaskNode lastElement = head;
            titles[index++] = lastElement.task.getTitle();
            while (lastElement.nextElement != null) {
                lastElement = lastElement.nextElement;
                titles[index] = lastElement.task.getTitle();
                index++;
            }
        }
        return titles;
    }

}


