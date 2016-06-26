package default_xyz.playground.drag_and_drop;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;

public class DragStartListener implements View.OnTouchListener {

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData dragData = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(dragData, shadowBuilder, v, 0);
        }
        return false;
    }
}
