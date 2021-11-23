package mx.edu.j2se.rubio.tasks.tests;
import mx.edu.j2se.rubio.tasks.Task;
import org.junit.Assert;
import org.junit.Test;

/*
 * @author  Alonso Rafael Rubio Carmona
 *
 *
 *
 * */

public class TaskTest_1 {
    @Test
    public void taskTests(){
        Task tarea1 = new Task("Tarea 1",5);
        Task tarea2 = new Task("Tarea 2",4,11,2);

        tarea1.setActive(true);
        tarea2.setActive(true);

        Assert.assertEquals("Tarea 1",tarea1.getTitle());
        tarea1.setTitle("Tarea Prueba");
        Assert.assertEquals("Tarea Prueba",tarea1.getTitle());
        Assert.assertFalse(tarea1.isRepeated());
        Assert.assertTrue(tarea1.isActive());
        tarea1.setActive(true);
        Assert.assertTrue(tarea1.isActive());
        Assert.assertEquals(5,tarea1.getTime());
        tarea1.setTime(6);
        Assert.assertEquals(6,tarea1.getTime());
        tarea1.setTime(6,10,1);
        Assert.assertTrue(tarea1.isRepeated());




        Assert.assertEquals("Tarea 2",tarea2.getTitle());
        Assert.assertTrue(tarea2.isRepeated());

        Assert.assertEquals(6,tarea2.nextTimeAfter(4));
        Assert.assertEquals(6,tarea2.nextTimeAfter(3));
        Assert.assertEquals(-1,tarea2.nextTimeAfter(8));
        Assert.assertEquals(-1,tarea2.nextTimeAfter(10));
        Assert.assertEquals(-1,tarea2.nextTimeAfter(12));

        Assert.assertEquals(4,tarea2.getStartTime());
        Assert.assertEquals(11,tarea2.getEndTime());
        Assert.assertEquals(2,tarea2.getRepeatInterval());

        Assert.assertTrue(tarea2.isRepeated());
        tarea2.setTime(7);
        Assert.assertFalse(tarea2.isRepeated());
    }
}
