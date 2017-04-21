package dk.kea.class2017.anders.tunnelvision.GameWorld.Calculations;


/**
 *  This class contains position and velocity values for the sphere
 */
public class Ball {

    public float x;
    public float vx; // velocity x
    public float y;
    public float vy;
    public float z;
    public float vz;


                // starting positions
    public Ball(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;

        vx = 0.1f;
        vy = 0.1f;
        vz = 0.1f;
    }


}
