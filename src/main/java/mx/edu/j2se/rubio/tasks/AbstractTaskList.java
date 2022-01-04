package mx.edu.j2se.rubio.tasks;

// Abstract class of the TaskList
public abstract class AbstractTaskList {
    public abstract void add(Task task) throws Exception;
    public abstract boolean remove(Task task);
    public abstract int size();
    public abstract Task getTask(int index) throws Exception;
    public abstract AbstractTaskList incoming(int from, int to);
}