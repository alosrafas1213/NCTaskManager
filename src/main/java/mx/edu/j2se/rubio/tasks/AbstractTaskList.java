package mx.edu.j2se.rubio.tasks;
import java.util.Iterator;
import java.util.stream.Stream;

// Abstract class of the TaskList
public abstract class AbstractTaskList implements Iterable<Task>, Cloneable{
    public abstract void add(Task task) throws Exception;
    public abstract boolean remove(Task task);
    public abstract int size();
    public abstract Task getTask(int index) throws Exception;
    public abstract Stream<Task> getStream();


    public final AbstractTaskList incoming(int from, int to) throws IllegalArgumentException{
        if (from<0 || to<0)
            throw new IllegalArgumentException("Input values cannot be less than 1");
        AbstractTaskList incomingTasks;
        try {
            incomingTasks = (this instanceof LinkedTaskList)?new LinkedTaskList():new ArrayTaskList();
            Stream<Task> taskStream = this.getStream();
            taskStream.filter(task -> task.nextTimeAfter(from) > from && task.nextTimeAfter(from) < to).forEach(task -> {
                try {
                    incomingTasks.add(task);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            return incomingTasks;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Iterator<Task> iterator() {
        int size = this.size();
        AbstractTaskList taskList = this;

        Iterator<Task> taskIterator = new Iterator<Task>() {
            int index = 0;

            @Override
            public boolean hasNext() {return (index<size)?true:false;}

            @Override
            public Task next() {
                Task task = null;
                try {
                    task = taskList.getTask(index);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                index ++;
                return task;
            }
        };
        return taskIterator;
    }

    // Equals method that verifies if the list contains the same tasks in the same order
    @Override
    public boolean equals(Object comparingList) {
        AbstractTaskList thisTaskList = this;
        if (comparingList instanceof AbstractTaskList || comparingList instanceof LinkedTaskList || comparingList instanceof ArrayTaskList) {
            AbstractTaskList equalList = (AbstractTaskList) comparingList;
            if (thisTaskList.size() == equalList.size()) {
                int size = thisTaskList.size();
                for (int i = 0; i < size; i++) {
                    try {
                        if (thisTaskList.getTask(i).equals(equalList.getTask(i))) {
                            continue;
                        } else {
                            return false;
                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }

                }
                return true;
            }
        }

        return false;
    }

    // Returns the hash codes sum of the tasks
    @Override
    public int hashCode() {
        int sum = 0;
        for (Task task: this)
            sum += task.hashCode();
        return sum;
    }

    @Override
    public String toString() {
        String listToString = "\nTasksList\n";
        for (Task task: this)
            listToString += task + "\n";
        return listToString;
    }

    @Override
    protected AbstractTaskList clone() throws CloneNotSupportedException {
        return (AbstractTaskList) super.clone();
    }


}