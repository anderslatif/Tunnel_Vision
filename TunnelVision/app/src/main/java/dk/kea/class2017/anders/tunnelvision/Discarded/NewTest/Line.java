package dk.kea.class2017.anders.tunnelvision.Discarded.NewTest;


import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Line {

    private FloatBuffer VertexBuffer;

    private final String VertexShaderCode =
            // This matrix member variable provides a hook to manipulate
            // the coordinates of the objects that use this vertex shader
            "uniform mat4 uMVPMatrix;" +

                    "attribute vec4 vPosition;" +
                    "void main() {" +
                    // the matrix must be included as a modifier of gl_Position
                    "  gl_Position = uMVPMatrix * vPosition;" +
                    "}";

    private final String FragmentShaderCode =
            "precision mediump float;" +
                    "uniform vec4 vColor;" +
                    "void main() {" +
                    "  gl_FragColor = vColor;" +
                    "}";



    public void draw(GL10 gl) {



        gl.glDrawArrays(GL10.GL_LINES, 0, 2);

    }


}