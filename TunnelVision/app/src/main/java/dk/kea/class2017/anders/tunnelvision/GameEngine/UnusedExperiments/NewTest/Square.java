package dk.kea.class2017.anders.tunnelvision.GameEngine.UnusedExperiments.NewTest;


import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import dk.kea.class2017.anders.tunnelvision.GameEngine.GLUtil.Vertices;

public class Square {

    Vertices squareModel;



    final int VERTEX_SIZE = (2 + 2) * 4;
    FloatBuffer vertices;
    ShortBuffer indices;


    float[] verticeCoords = new float[] {  100.0f, 100.0f, 0.0f, 1.0f,
            228.0f, 100.0f, 1.0f, 1.0f,
            228.0f, 228.0f, 1.0f, 0.0f,
            100.0f, 228.0f, 0.0f, 0.0f };

    short[] indiceOrdering = { 0, 1, 2,
            2, 3, 0 };

    public Square() {

/*        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * VERTEX_SIZE);
        byteBuffer.order(ByteOrder.nativeOrder());
        vertices = byteBuffer.asFloatBuffer();
        vertices.put(verticeCoords);
        vertices.flip();


        byteBuffer = ByteBuffer.allocateDirect(6 * 2);
        byteBuffer.order(ByteOrder.nativeOrder());
        indices = byteBuffer.asShortBuffer();
        indices.put(indiceOrdering);
        indices.flip();*/

        squareModel = new Vertices(4, 12, false, true);
        squareModel.setVertices(verticeCoords, 0, 16);
        squareModel.setIndices(indiceOrdering, 0, 6);
    }

    public void draw(GL10 gl) {
/*         gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
       gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrthof(0, 320, 0, 480, 1, -1);

        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        vertices.position(0);
        gl.glVertexPointer(2, GL10.GL_FLOAT, VERTEX_SIZE, vertices);
        vertices.position(2);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, VERTEX_SIZE, vertices);

        gl.glDrawElements(GL10.GL_TRIANGLES, 6, GL10.GL_UNSIGNED_SHORT, indices);*/

        squareModel.draw(gl, GL10.GL_TRIANGLES, 0, 6);
    }

}
