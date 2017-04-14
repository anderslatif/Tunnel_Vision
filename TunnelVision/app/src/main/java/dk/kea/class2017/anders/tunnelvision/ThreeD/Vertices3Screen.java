package dk.kea.class2017.anders.tunnelvision.ThreeD;


import javax.microedition.khronos.opengles.GL10;

public class Vertices3Screen {

        Vertices3 vertices;

        public Vertices3Screen(GL10 gl) {

            vertices = new Vertices3(gl, 6, 0, true, false);
            vertices.setVertices(new float[] { -0.5f, -0.5f, -3, 1, 0, 0, 1,
                    0.5f, -0.5f, -3, 1, 0, 0, 1,
                    0.0f,  0.5f, -3, 1, 0, 0, 1,

                    0.0f,  -0.5f, -5, 0, 1, 0, 1,
                    1.0f,  -0.5f, -5, 0, 1, 0, 1,
                    0.5f,  0.5f, -5, 0, 1, 0, 1}, 0, 7 * 6);
        }

        public void present(GL10 gl) {
            gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//            gl.glViewport(0, 0, glGraphics.getWidth(), glGraphics.getHeight());
            gl.glMatrixMode(GL10.GL_PROJECTION);
            gl.glLoadIdentity();
            gl.glOrthof(-1, 1, -1, 1, 10, -10);
            gl.glMatrixMode(GL10.GL_MODELVIEW);
            gl.glLoadIdentity();
            vertices.bind(gl);
            vertices.draw(gl, GL10.GL_TRIANGLES, 0, 6);
            vertices.unbind(gl);
        }

}
