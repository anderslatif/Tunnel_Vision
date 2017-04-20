package dk.kea.class2017.anders.tunnelvision.GameWorld;


public class PaddleCalculations {

    public static float[] nextPaddlePosition(float[] accelerometer, float deltatime) {

/*
        System.out.println("****************************0      " + accelerometer[0]);
        System.out.println("****************************1      " + accelerometer[1]);
        System.out.println("****************************2      " + accelerometer[1]);
*/

        float accelerometerConstant = 100;

        accelerometer[0] /= accelerometerConstant;
        accelerometer[1] /= accelerometerConstant;
        accelerometer[2] /= accelerometerConstant;

        // todo calculate position so that the paddle never leaves the screen

        return accelerometer;
    }

}
