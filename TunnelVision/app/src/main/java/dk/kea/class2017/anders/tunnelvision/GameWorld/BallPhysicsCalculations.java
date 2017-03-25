package dk.kea.class2017.anders.tunnelvision.GameWorld;


import dk.kea.class2017.anders.tunnelvision.GameWorld.GraphicalElements.Ball;
import dk.kea.class2017.anders.tunnelvision.GameWorld.GraphicalElements.Tunnel;

public class BallPhysicsCalculations {

   Ball ball;
   public float[] ballCalculations = new float[6];

    public BallPhysicsCalculations(Ball ball) {
        this.ball = ball;
    }


    public float[] calculateNextMove() {

        if (ball.z <= Tunnel.LENGTH) {
            ball.z = Tunnel.LENGTH; // reposition the ball so it doesn't get stuck outside of the boundaries
            ball.vz = -ball.vz; // the ball comes back forward with a positive velocity value
            ball.z += ball.z * ball.vz;
        } else if (ball.z > -2f) {  // the ball is too close if bigger than -2f
            ball.vz = -ball.vz; // reverse the velocity to a negative number
            ball.z += ball.z * ball.vz;
        } else  {
            ball.z += ball.z * ball.vz;
        }

        System.out.println("################" + ball.z);
        System.out.println("@@@@@@@@@ "+ ball.vz);

        ballCalculations[0] = ball.x;
        ballCalculations[1] = ball.vx;
        ballCalculations[2] = ball.y;
        ballCalculations[3] = ball.vy;
        ballCalculations[4] = ball.z;
        ballCalculations[5] = ball.vz;

        return ballCalculations;
    }




}
