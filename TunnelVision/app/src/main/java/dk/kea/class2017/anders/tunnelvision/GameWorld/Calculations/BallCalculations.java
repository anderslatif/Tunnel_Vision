package dk.kea.class2017.anders.tunnelvision.GameWorld.Calculations;


import dk.kea.class2017.anders.tunnelvision.GameWorld.World;

public class BallCalculations {

    Ball ball;
    public float[] ballCalculations = new float[6];


    // todo method to check if the ball is in proximity of the spot

    public float[] calculateNextBallPosition(float deltatime, float[] accelerometer) {
        // todo get the level.. depending on the level set the x, y and z value.. the z value should increase for each level

        float accelerometerConstant = 100;

        accelerometer[0] /= accelerometerConstant;
        accelerometer[1] /= accelerometerConstant;
        accelerometer[2] /= accelerometerConstant;


        ballCalculations[0] = ball.x;
        ballCalculations[1] = ball.vx;
        ballCalculations[2] = ball.y;
        ballCalculations[3] = ball.vy;


        return null;
    }


    public void setNewBallPosition(int level) {
        // todo get the level.. depending on the level set the x, y and z value.. the z value should increase for each level

        switch (World.level) {
            case 1:
                ball = new Ball(0.0f, 0.0f, -3.0f);
                ballCalculations[4] = ball.z;
                ballCalculations[5] = ball.vz;
                break;
            default:
                ball = new Ball(0.0f, 0.0f, -3.0f);
                ballCalculations[4] = ball.z;
                ballCalculations[5] = ball.vz;
        }


    }

}
