package dk.kea.class2017.anders.tunnelvision;


import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class OpenGLView extends GLSurfaceView {

//    private GameRenderer renderer;
    private SimpleRenderer renderer;

    private float[] accelerometer;

    private float mDownX = 0.0f;
    private float mDownY = 0.0f;

    public OpenGLView(Context context, float[] accelerometer) {
        super(context);
        this.accelerometer = accelerometer;

//        renderer = new GameRenderer();
        renderer = new SimpleRenderer();
        this.setRenderer(renderer);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mDownX = event.getX();
                mDownY = event.getY();
                return true;
            case MotionEvent.ACTION_UP:
                return true;
            case MotionEvent.ACTION_MOVE:
                float mX = event.getX();
                float mY = event.getY();
               /* renderer.mLightX += (mX-mDownX)/10;
                renderer.mLightY -= (mY-mDownY)/10;*/
                mDownX = mX;
                mDownY = mY;
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }


}