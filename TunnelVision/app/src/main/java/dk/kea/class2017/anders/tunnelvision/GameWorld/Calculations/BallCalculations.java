package dk.kea.class2017.anders.tunnelvision.GameWorld.Calculations;


import dk.kea.class2017.anders.tunnelvision.GameWorld.Sounds.SoundUtil;
import dk.kea.class2017.anders.tunnelvision.GameWorld.World;

public class BallCalculations {

    Ball ball;
    float accelerometerConstant;

    // todo method to check if the ball is in proximity of the spot

    public void calculateNextBallPosition(float deltatime, float[] accelerometer) {
        accelerometerConstant = 4;

        Ball.x += -(accelerometer[0]*deltatime/accelerometerConstant);
        Ball.y += -(accelerometer[1]*deltatime/accelerometerConstant);


    }


    public void setNewBallPosition(int level) {
        // todo get the level.. depending on the level set the x, y and z value.. the z value should increase for each level

        switch (World.level) {
            case 1:
                ball = new Ball(0.0f, 0.0f, -3.0f);
                World.goalX = 0.8f;
                World.goalY = 0.1f;
                break;
            case 2:
                ball = new Ball(0.8f, 0.2f, -3.0f);
                World.goalX = 0.1f;
                World.goalY = 0.3f;
                break;
            default:
                ball = new Ball(0.0f, 0.0f, -3.0f);
        }


    }

}
