package kr.ac.inhatc.juha.android_image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 4-401 on 2017-04-04.
 */

public class AndroiView extends View {
    Drawable imgAndroi;
    int ix, iy;
    int imgWidth, imgHeight;

    public AndroiView(Context context, AttributeSet attrs) {
        super(context, attrs);

        imgAndroi=this.getResources().getDrawable(R.drawable.androi);
        imgWidth = imgAndroi.getIntrinsicWidth();
        imgHeight = imgAndroi.getIntrinsicHeight();
        ix = 0;
        iy = 0;
    }

    /**
     * Implement this to do your drawing.
     *
     * @param canvas the canvas on which the background will be drawn
     */
    @Override
    protected void onDraw(Canvas canvas) {
        imgAndroi.setBounds(ix, iy, ix+imgWidth, iy+imgHeight);
        imgAndroi.draw(canvas);

        super.onDraw(canvas);
    }

    /**
     * This is called during layout when the size of this view has changed. If
     * you were just added to the view hierarchy, you're called with the old
     * values of 0.
     *
     * @param w    Current width of this view.
     * @param h    Current height of this view.
     * @param oldw Old width of this view.
     * @param oldh Old height of this view.
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        ix = (this.getWidth()-imgWidth)/2;
        iy = (this.getHeight()-imgHeight)/2;

        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * Default implementation of {@link KeyEvent.Callback#onKeyDown(int, KeyEvent)
     * KeyEvent.Callback.onKeyDown()}: perform press of the view
     * when {@link KeyEvent#KEYCODE_DPAD_CENTER} or {@link KeyEvent#KEYCODE_ENTER}
     * is released, if the view is enabled and clickable.
     * <p>
     * Key presses in software keyboards will generally NOT trigger this
     * listener, although some may elect to do so in some situations. Do not
     * rely on this to catch software key presses.
     *
     * @param keyCode a key code that represents the button pressed, from
     *                {@link KeyEvent}
     * @param event   the KeyEvent object that defines the button action
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch(keyCode)
        {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                ix -= 15;
                if (ix <= 0) ix = 0;
                break;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                ix += 15;
                if (ix >= this.getWidth()-imgWidth) ix = this.getWidth() - imgWidth;
                break;

            case KeyEvent.KEYCODE_DPAD_UP:
                iy -= 15;
                if (iy <= 0) iy =0;
                break;

            case KeyEvent.KEYCODE_DPAD_DOWN:
                iy += 15;
                if(iy >= this.getHeight()-imgHeight) iy = this.getHeight()-imgHeight;
                break;
        }
        this.invalidate();

        return super.onKeyDown(keyCode, event);
    }

    /**
     * Implement this method to handle touch screen motion events.
     * <p>
     * If this method is used to detect click actions, it is recommended that
     * the actions be performed by implementing and calling
     * {@link #performClick()}. This will ensure consistent system behavior,
     * including:
     * <ul>
     * <li>obeying click sound preferences
     * <li>dispatching OnClickListener calls
     * <li>handling {@link AccessibilityNodeInfo#ACTION_CLICK ACTION_CLICK} when
     * accessibility features are enabled
     * </ul>
     *
     * @param event The motion event.
     * @return True if the event was handled, false otherwise.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        ix = (int)event.getX()-imgWidth/2;
        iy = (int)event.getY()-imgHeight/2;
        this.invalidate();

        return super.onTouchEvent(event);
    }
}
