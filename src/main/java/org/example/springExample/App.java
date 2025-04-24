package org.example.springExample;

public class App
{
    public static void main( String[] args ) {

        Participant[] participants = {
                new Human("Алексей", 500, 2),
                new Cat("Мурзик", 200, 3),
                new Robot("R2D2", 1000, 5)
        };

        Obstacle[] obstacles = {
                new Treadmill(300),
                new Wall(1),
                new Treadmill(700),
                new Wall(4)
        };

        for (Participant participant : participants) {
            boolean success = true;
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    success = false;
                    break;
                }
            }
            System.out.println();
        }


    }
}
