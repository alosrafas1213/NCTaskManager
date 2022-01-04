package mx.edu.j2se.rubio.evaluation;

public class Evaluation1 {
    public static void main(String[] args) {
        try {
            Circle circle1 = new Circle(-1);
        }
        catch(IllegalArgumentException e){
            System.out.println("\nRadius value cannot be less than one\n");
        }

        Circle[] circleArray = {new Circle(40), new Circle(50), new Circle(20)};

        int bigCircle = biggestCircle(circleArray);

        System.out.println("Index of the Biggest circle radius is: " + bigCircle);
    }

    public static int biggestCircle(Circle[] circleArray){
        double biggestRadius = 0;
        int biggestIndex = 0;

        for (int index=0; index<circleArray.length ; index++){
            if (biggestRadius<circleArray[index].getRadius()){
                biggestRadius=circleArray[index].getRadius();
                biggestIndex = index;
            }
        }
        return biggestIndex;
    }
}
