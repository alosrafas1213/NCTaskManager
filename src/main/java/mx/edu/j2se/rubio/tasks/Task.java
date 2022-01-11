package mx.edu.j2se.rubio.tasks;

import java.util.Objects;

/**
* @author  Alonso Rafael Rubio Carmona
*
* The Task class represents a repetitive and a non-repetitive task
* Both types of tasks have a defined time, in case of the non-repetitive ones
* there is only one attribute time, the title of the task and the isActive flag
* For the repetitive ones, there are two attributes of time, start and end,
* an interval attribute and also the title and isActive flag as well
*
* */

public class Task  {
    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean isActive;
    private boolean repetitive;

    /*
    * Constructor of the Task class with 2 attributes
    * used for the non-repetitive tasks
    * */
    public Task(String title, int time) throws IllegalArgumentException{
        if (time<0)
            throw new IllegalArgumentException("Input values cannot be less than 1");
        this.title = title;
        this.time = time;
        this.isActive = false;
        this.repetitive = false;
    }


    /*
     * Constructor of the Task class with 4 attributes
     * used for the repetitive tasks
     * */
    public Task(String title, int start, int end, int interval) throws IllegalArgumentException{
        if (start<0 || end<0 || interval<0)
            throw new IllegalArgumentException("Input values cannot be less than 1");
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.isActive = false;
        this.repetitive = true;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public boolean isActive(){
        return isActive;
    }

    public void setActive(boolean active){
        isActive = active;
    }

    public int getTime(){
        return time;
    }


    /**
     * @param time The time to be set
     * setTime method with one parameter, if the task was a repetitive one it becomes a non-repetitive one
     */
    public void setTime(int time) throws IllegalArgumentException{
        if (time<0)
            throw new IllegalArgumentException("Input values cannot be less than 1");
        this.time = time;
        repetitive = false;
        start = 0;
        end = 0;
    }

    /**
     * @param start Start time to be set
     * @param end End time to be set
     * @param interval Interval to be set
     *
     * setTime method with three parameters, if the task is a non-repetitive one
     * it becomes a repetitive one
     */
    public void setTime(int start, int end, int interval) throws IllegalArgumentException{
        if (start<0 || end<0 || interval<0)
            throw new IllegalArgumentException("Input values cannot be less than 1");
         this.time = 0;
         this.start = start;
         this.end = end;
         this.interval = interval;
         this.repetitive = true;
    }

    public int getStartTime() {
        return start;
    }

    public int getEndTime() {
        return end;
    }

    public boolean isRepeated(){
        return repetitive;
    }

    public int getRepeatInterval() {
        return interval;
    }

    /**
     * @param current Current time
     * @return Next start time of the task execution after the current time
     * Returns the next start time after the start time if the current time is
     * less than the current time, otherwise if the current time is greater than
     * the end time it returns -1, and it returns the next start time if the
     * current time is less than the end time and greater or equals than the start time
     */

    public int nextTimeAfter (int current){
        if (current<0)
            throw new IllegalArgumentException("Values cannot be less than 1");
        if (isActive){
            if (current<=start || current<=time)
                return start+interval+time;
            else{
                if (current>end || current>time)
                    return -1;
                else
                    for(int i=start+interval ; i<end ; i=i+interval)
                        if (current<i)
                            return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object comparingTask) {
        if (comparingTask == null || getClass() != comparingTask.getClass())
            return false;
        Task task = (Task) comparingTask;
        boolean isEqual;
        isEqual = time == task.time && start == task.start && end == task.end && interval == task.interval && isActive == task.isActive && repetitive == task.repetitive && Objects.equals(title, task.title);
        return isEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, time, start, end, interval, isActive, repetitive);
    }

    @Override
    public String toString() {
        if (repetitive==true)
            return "Task " + title + " -> Is repetitive: " + repetitive + ", Is Active: " + isActive + ", Time: " + time + ", Start Time: " + start + ", End Time: " + end + ", Interval: " + interval;
        else
        return "Task "+ title + " -> Is repetitive: " + repetitive + ", Is Active: " + isActive + ", Time: " + time;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
