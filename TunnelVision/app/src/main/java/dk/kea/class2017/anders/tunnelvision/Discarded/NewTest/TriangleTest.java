package dk.kea.class2017.anders.tunnelvision.Discarded.NewTest;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class TriangleTest {

    FloatBuffer vertices;

    static float triangleCoords[] =
            new float[] {    20.0f,   0.0f,   0.0f,
                    319.0f,   0.0f, -3.0f,
                    160.0f, 479.0f, -1.0f};

    public TriangleTest() {

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(3 * 3 * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        vertices = byteBuffer.asFloatBuffer();
        vertices.put(triangleCoords);
        vertices.flip();
    }

    public void draw(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrthof(0, 320, 0, 480, 1, -1);

        gl.glColor4f(1, 0, 0, 1);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer( 3, GL10.GL_FLOAT, 0, vertices);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
    }



}