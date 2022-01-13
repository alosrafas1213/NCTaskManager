package mx.edu.j2se.rubio.tasks;

import java.util.stream.Stream;

/**
 * @author  Alonso Rafael Rubio Carmona
 *
 * The LinkedTaskList class represents a Linked List of the tasks
 *
 * */
public class LinkedTaskList extends AbstractTaskList {

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
            // Insert the new_node at last node
            TaskNode lastElement = tail;
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
        if (index>=size)
            throw new IndexOutOfBoundsException("Index out of bounds");
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

    @Override
    public Stream<Task> getStream() {
        Stream.Builder<Task> taskStream = Stream.builder();
        TaskNode task = this.head;
        while (task != null) {
            taskStream.add(task.task);
            task = task.nextElement;
        }
        return taskStream.build();
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


