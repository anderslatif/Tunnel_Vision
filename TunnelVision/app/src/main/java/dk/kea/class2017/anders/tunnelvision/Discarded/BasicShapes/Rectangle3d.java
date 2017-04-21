package dk.kea.class2017.anders.tunnelvision.Discarded.BasicShapes;


import javax.microedition.khronos.opengles.GL10;

import dk.kea.class2017.anders.tunnelvision.Discarded.GLUtil.Vertices3;

public class Rectangle3d {

    Vertices3 vertices;

    private float[] verticeCoords = new float[] {
            -0.5f, 0.25f, 0, 1, 1, 1, 0.1f,
            -0.5f, -0.25f, 0, 1, 1, 1, 0.1f,
            0.5f,  -0.25f, 0, 1, 1, 1, 0.1f,

            -0.5f,  0.25f, 0, 1, 1, 1, 0.1f,
            0.5f,  -0.25f, 0, 1, 1, 1, 0.1f,
            0.5f,  0.25f, 0, 1, 1, 1, 0.1f,
    };

        public Rectangle3d(GL10 gl) {

            vertices = new Vertices3(gl, 6, 0, true, false);

            vertices.setVertices(verticeCoords, 0, 7 * 6);
        }


        public void present(GL10 gl, float[] position) {

            gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
            gl.glMatrixMode(GL10.GL_PROJECTION);
            gl.glLoadIdentity();
            gl.glOrthof(-1, 1, -1, 1, 10, -10);
            gl.glMatrixMode(GL10.GL_MODELVIEW);
            gl.glLoadIdentity();
            vertices.bind(gl);
            gl.glTranslatef(position[0], position[1], 0);
            vertices.draw(gl, GL10.GL_TRIANGLES, 0, 6);
            vertices.unbind(gl);
        }

}
