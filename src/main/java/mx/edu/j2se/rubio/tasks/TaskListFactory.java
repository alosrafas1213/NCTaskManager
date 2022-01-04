package mx.edu.j2se.rubio.tasks;

public class TaskListFactory {
    public static AbstractTaskList createTaskList(ListTypes.types type) throws IllegalArgumentException {
        AbstractTaskList taskList;
        switch (type) {
            case ARRAY:
                //ArrayTaskList is created
                taskList = new ArrayTaskList();
                break;
            case LINKED:
                //LinkedTaskList is created
                taskList = new LinkedTaskList();
                break;
            default:
                throw new IllegalArgumentException("The type of the list must be ARRAY or LINKED");
        }
        return taskList;
    }
}
