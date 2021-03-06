package dk.kea.class2017.anders.tunnelvision.Discarded.NewTest;


import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import dk.kea.class2017.anders.tunnelvision.Discarded.GLUtil.Vertices;

public class ColoredTriangleTest {

    final int VERTEX_SIZE = (2 + 4) * 4;
    FloatBuffer vertices;

    Vertices triangleModel;

    float[] verticeCoords =  new float[] {   0.0f,   0.0f, 1, 0, 0, 1,
            319.0f,   0.0f, 0, 1, 0, 1,
            160.0f, 479.0f, 0, 0, 1, 1};

    public ColoredTriangleTest() {
/*        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(3 * VERTEX_SIZE);
        byteBuffer.order(ByteOrder.nativeOrder());
        vertices = byteBuffer.asFloatBuffer();
        vertices.put( new float[] {   0.0f,   0.0f, 1, 0, 0, 1,
                319.0f,   0.0f, 0, 1, 0, 1,
                160.0f, 479.0f, 0, 0, 1, 1});
        vertices.flip();*/

        triangleModel = new Vertices(3, 17, true, false);

    }

    public void draw(GL10 gl) {
/*        gl.glViewport(0, 0, 200, 200);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrthof(0, 320, 0, 480, 1, -1);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        vertices.position(0);
        gl.glVertexPointer(2, GL10.GL_FLOAT, VERTEX_SIZE, vertices);
        vertices.position(2);
        gl.glColorPointer(4, GL10.GL_FLOAT, VERTEX_SIZE, vertices);

        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);*/

        triangleModel.draw(gl, GL10.GL_TRIANGLES, 0, 3);
    }


}
