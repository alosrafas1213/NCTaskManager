package mx.edu.j2se.rubio.tasks;

import java.time.LocalDateTime;
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
    private LocalDateTime time;
    private LocalDateTime start;
    private LocalDateTime end;
    private int interval;
    private boolean isActive;
    private boolean repetitive;
    private LocalDateTime now;

    /*
    * Constructor of the Task class with 2 attributes
    * used for the non-repetitive tasks
    * */
    public Task(String title, LocalDateTime time) throws IllegalArgumentException{
        this.now = LocalDateTime.now();
        if (time.isBefore(now))
            throw new IllegalArgumentException("Cannot create task in the past");
        this.title = title;
        this.time = time;
        this.isActive = false;
        this.repetitive = false;
    }


    /*
     * Constructor of the Task class with 4 attributes
     * used for the repetitive tasks
     * */
    public Task(String title, LocalDateTime start, LocalDateTime end, int interval) throws IllegalArgumentException{
        this.now = LocalDateTime.now();
        if (start.isBefore(now))
            throw new IllegalArgumentException("Cannot create task in the past");
        if (end.isBefore(start))
            throw new IllegalArgumentException("End time cannot be before the start time");
        if (interval<0)
            throw new IllegalArgumentException("Interval cannot be less or equal than 0");
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

    public LocalDateTime getTime(){
        return time;
    }


    /**
     * @param time The time to be set
     * setTime method with one parameter, if the task was a repetitive one it becomes a non-repetitive one
     */
    public void setTime(LocalDateTime time) throws IllegalArgumentException{
        now = LocalDateTime.now();
        if (time.isBefore(now))
            throw new IllegalArgumentException("Input values cannot be less than 1");
        this.time = time;
        repetitive = false;
        start = null;
        end = null;
    }

    /**
     * @param start Start time to be set
     * @param end End time to be set
     * @param interval Interval to be set
     *
     * setTime method with three parameters, if the task is a non-repetitive one
     * it becomes a repetitive one
     */
    public void setTime(LocalDateTime start, LocalDateTime end, int interval) throws IllegalArgumentException{
        now = LocalDateTime.now();
        if (start.isBefore(now))
            throw new IllegalArgumentException("Cannot create task in the past");
        if (end.isBefore(start))
            throw new IllegalArgumentException("End time cannot be before the start time");
        if (interval<0)
            throw new IllegalArgumentException("Interval cannot be less or equal than 0");
         this.time = null;
         this.start = start;
         this.end = end;
         this.interval = interval;
         this.repetitive = true;
    }

    public LocalDateTime getStartTime() {
        return start;
    }

    public LocalDateTime getEndTime() {
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

    public LocalDateTime nextTimeAfter (LocalDateTime current){
        if (isActive){
            if (current.isBefore(start) && isRepeated())
                return start.plusHours(interval);
            if (current.isBefore(time) && !isRepeated())
                return time;
            else{
                if (current.isAfter(end) && isRepeated())
                    return LocalDateTime.MIN;
                if (current.isAfter(time) && !isRepeated())
                    return LocalDateTime.MIN;
                else
                    if(isRepeated()) {
                        LocalDateTime date = start;
                        while (date.isBefore(end)){
                            if (current.isBefore(date))
                                return date;
                            date = date.plusHours(interval);
                        }
                    }
            }
        }
        return LocalDateTime.MIN;
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
