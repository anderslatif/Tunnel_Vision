package dk.kea.class2017.anders.tunnelvision.GameWorld.Calculations;


import dk.kea.class2017.anders.tunnelvision.GameWorld.World;

public class BallCalculations {

    Ball ball;

    // todo method to calculate movement based on the accelerometer

    // todo method to check if the ball is in proximity of the spot


    public void setNewBallPosition(int level) {
        // todo get the level.. depending on the level set the x, y and z value.. the z value should increase for each level

        switch (World.level) {
            case 1:
                ball = new Ball(0.0f, 0.0f, -3.0f);
                break;
            default:

        }


    }

}