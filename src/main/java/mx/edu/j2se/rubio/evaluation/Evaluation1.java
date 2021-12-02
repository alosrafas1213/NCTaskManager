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

        Circle bigCircle = biggestCircle(circleArray);

        System.out.println("Biggest circle radius is: " + bigCircle.getRadius());
    }

    public static Circle biggestCircle(Circle[] circleArray){
        double biggestRadius = 0;
        int biggestIndex = 0;

        for (int index=0; index<circleArray.length ; index++){
            if (biggestRadius<circleArray[index].getRadius()){
                biggestRadius=circleArray[index].getRadius();
                biggestIndex = index;
            }
        }
        return circleArray[biggestIndex];
    }
}
