package mx.edu.j2se.rubio.tasks;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Tasks {
    public static Iterable<Task> incoming(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){
        if (start.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("Incoming tasks cannot be in the past");
        if (end.isBefore(start))
            throw new IllegalArgumentException("Incoming tasks interval error");
        Iterator<Task> incomingStream;
        try {
            Stream<Task> taskStream = StreamSupport.stream(tasks.spliterator(),false);
            incomingStream = taskStream.filter(task -> task.nextTimeAfter(start).isEqual(end) || task.nextTimeAfter(start).isBefore(end)).iterator();
            Iterable<Task> incomingTasks = () -> incomingStream;
            return incomingTasks;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SortedMap<LocalDateTime, Set<Task>> calendar(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){
        if (start.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("Incoming tasks cannot be in the past");
        if (end.isBefore(start))
            throw new IllegalArgumentException("Incoming tasks interval error");

        SortedMap<LocalDateTime, Set<Task>> calendar = new TreeMap<>();
        //Iterable<Task> incomingTasks = Tasks.incoming(tasks, start, end);
        LocalDateTime date = start;
        while (date.isBefore(end) || date.isEqual(end)) {
            Set<Task> taskSet = new HashSet<>();
            Iterable<Task> taskIterable = Tasks.incoming(tasks, date, date);
            taskIterable.forEach(task -> taskSet.add(task));
            if (!taskSet.isEmpty()) {
                calendar.put(date, taskSet);
            }
            date = date.plusMinutes(1);
        }

        return calendar;
    }
}
